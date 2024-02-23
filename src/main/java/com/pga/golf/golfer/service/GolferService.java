package com.pga.golf.golfer.service;

import com.pga.golf.golfer.domain.GolferDTO;

public interface GolferService {

    /**
     * 회원가입 메서드
     * @param golferDTO 를받아서 role세팅, 비밀번호 암호화
     */
    void join(GolferDTO golferDTO);
}
