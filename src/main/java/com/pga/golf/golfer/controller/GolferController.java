package com.pga.golf.golfer.controller;

import com.pga.golf.golfer.domain.GolferDTO;
import com.pga.golf.golfer.service.GolferService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GolferController {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final GolferService golferService;
    @PostMapping("/join")
    public String join(@RequestBody GolferDTO golferDTO) {
        System.out.println("컨트롤러입장");
        golferService.join(golferDTO);
        return "회원가입 성공";
    }


}
