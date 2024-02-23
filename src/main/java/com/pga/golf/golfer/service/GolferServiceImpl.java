package com.pga.golf.golfer.service;

import com.pga.golf.golfer.domain.GolferDTO;
import com.pga.golf.golfer.repository.GolferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GolferServiceImpl implements GolferService {

    private final GolferRepository golferRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void join(GolferDTO golferDTO) {
        System.out.println("서비스 입장");
        golferDTO.setRoles("ROLE_USER");
        golferDTO.setPassword(bCryptPasswordEncoder.encode(golferDTO.getPassword()));
        golferDTO.setGolferStatus(1);
        golferRepository.save(golferDTO.toEntity());
    }
}
