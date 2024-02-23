package com.pga.golf.common.jwt.config.jwt;


public interface JwtProperties {
    String SECRET = "우리서버만알고있는비밀값";
    int EXPIRATION_TIME = 864000000;//10일 1/100초
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
}
