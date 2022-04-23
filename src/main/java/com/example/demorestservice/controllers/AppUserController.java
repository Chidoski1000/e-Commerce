package com.example.demorestservice.controllers;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demorestservice.config.UserDetailServiceImpl;
import com.example.demorestservice.entities.AppUser;
import com.example.demorestservice.exceptions.IncorrectCredentialsException;
import com.example.demorestservice.models.request.LoginRequestDto;
import com.example.demorestservice.models.request.SignUpRequestDto;
import com.example.demorestservice.models.response.TokenResponseDto;
import com.example.demorestservice.services.AppUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import static com.example.demorestservice.filter.util.FilterUtil.*;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailServiceImpl userDetailService;


    @PostMapping("/signup")
    private ResponseEntity<String> register(@RequestBody SignUpRequestDto signUpRequestDto) throws Exception {
        return new ResponseEntity<>(appUserService.registerUser(signUpRequestDto), HttpStatus.CREATED);
    }


    @PostMapping("/login")
    private ResponseEntity<TokenResponseDto> login(@RequestBody LoginRequestDto loginRequestDto, HttpServletRequest request) throws Exception {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginRequestDto.getUsername(),
                    loginRequestDto.getPassword()));
        } catch (Exception e){
            log.info("User " +loginRequestDto.getUsername() +" " +"is not verified");
            throw new IncorrectCredentialsException("Incorrect username or password");
        }

        log.info("User verified and logged in");
        User user = (User) userDetailService.loadUserByUsername(loginRequestDto.getUsername());
        TokenResponseDto responseDto = new TokenResponseDto(generateToken(request, user),
                generateRefreshToken(request, user));

        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @PostMapping("/refreshToken")
    private ResponseEntity<?> refreshToken(HttpServletRequest request) throws Exception {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
            try {
                DecodedJWT decodedJWT = decodeUser(request);
                String username = decodedJWT.getSubject();
                User user = (User) userDetailService.loadUserByUsername(username);
                TokenResponseDto responseDto = new TokenResponseDto(generateToken(request, user),
                        decodedJWT.getToken());
                return ResponseEntity.status(HttpStatus.OK).body(responseDto);
            } catch (Exception exception){
                throw new Exception(exception.getMessage());
            }
        }else{
            throw new Exception("Refresh token is missing");
        }
    }
}
