package com.pga.golf.common.jwt.config.auth;

import com.pga.golf.golfer.domain.GolferEntity;
import com.pga.golf.golfer.repository.GolferRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PrincipalDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(PrincipalDetailsService.class);
    private final GolferRepository golferRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("PrincipalDetailsService의 loadUserByUsername()");
        logger.info("=========="+username+"==========");
        GolferEntity golferEntity = golferRepository.findById(username);

        return new PrincipalDetails(golferEntity);
    }
}
