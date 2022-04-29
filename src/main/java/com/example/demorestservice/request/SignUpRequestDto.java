package com.example.demorestservice.request;

import com.example.demorestservice.annotations.PasswordValueMatch;
import com.example.demorestservice.annotations.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@PasswordValueMatch.List({
        @PasswordValueMatch(
                field = "password",
                fieldMatch = "repeat_password",
                message = "Passwords do not match!"
        )
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequestDto {

    private String username;
    @ValidPassword
    private String password;
    @ValidPassword
    private String repeat_password;
    @Email
    private String email;
    private String firstName;
    private String lastName;

}
