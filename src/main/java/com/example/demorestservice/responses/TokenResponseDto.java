package com.example.demorestservice.responses;

import lombok.Data;

@Data
public class TokenResponseDto {
    private String token;
    private String refreshToken;

    public TokenResponseDto(String token, String refreshToken) {
        this.token = token;
        this.refreshToken = refreshToken;
    }
}
