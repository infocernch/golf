package com.pga.golf.common.jwt.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.pga.golf.common.jwt.config.auth.PrincipalDetails;
import com.pga.golf.golfer.domain.GolferDTO;
import com.pga.golf.golfer.domain.GolferEntity;
import com.pga.golf.golfer.repository.GolferRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.io.IOException;

/**
 * 인가
 */
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final GolferRepository golferRepository;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, GolferRepository golferRepository) {
        super(authenticationManager);
        this.golferRepository = golferRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(JwtProperties.HEADER_STRING);
        if (header == null || !header.startsWith(JwtProperties.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
        }
        logger.info("===================인가 필터 동작 헤더값 출력====================");
        logger.info("header : " + header);
        logger.info("=============================================================");

        String token = request.getHeader(JwtProperties.HEADER_STRING)
                .replace(JwtProperties.TOKEN_PREFIX, "");

        //토큰 검증(이게 인증이기 때문에 authenticationManager 필요없음)
        //내가 securityContext에 직접 접근해서 세션을 만들 때 자동으로 UserDetailService에 있는 loadByUsername이 호출됨
        String id = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(token)
                .getClaim("id").asString();

        if (id != null) {
            GolferEntity golfer = golferRepository.findById(id);

            //인증은 토큰 검증 할때 끝.
            //인증을 하기위해서가 아닌 스프링 시큐리티가 수행해주는 권한처리를 위해 토큰을 만들어서
            //Authentication 객체를 만들고 세션에 저장.
            PrincipalDetails principalDetails = new PrincipalDetails(golfer);

            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    principalDetails, //나중에 컨트롤러에서 di 할때 사용하기 편함
                    null, //패스워드는 모르니까 null
                    principalDetails.getAuthorities()
            );

            //시큐리티의 세션에 접근하여 값 저장
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        chain.doFilter(request,response);
    }
}
