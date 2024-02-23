package com.pga.golf.golfer.domain;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String id;
    private String password;
}
