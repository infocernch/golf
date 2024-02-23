package com.pga.golf.golfer.domain;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GolferDTO {
    private long golferSeq;
    private String name;//닉네임
    private String id;
    private String email;
    private String password;
    private int handy;
    private int golferStatus; //회원 상태
//    private List<RoundInfoEntity> rounds;
//    private List<BoardEntity> boards;
    private String roles;//user, admin

    public List<String> getRoleList() {
        if (this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }
        @Builder
        public GolferDTO(String name, @NotNull String id, @NotNull String email, @NotNull String password, int handy, int golferStatus, @NotNull String roles) {
            this.name = name;
            this.id = id;
            this.email = email;
            this.password = password;
            this.handy = handy;
            this.golferStatus = golferStatus;
            this.roles = roles;
        }

    /**
     * DTO를 Entity로 변환해주는 메서드
     * @return GolferEntity
     */
    public GolferEntity toEntity() {
        return GolferEntity.builder()
                .name(name)//사용자 진짜 이름
                .id(id)//사용자 ID
                .email(email)//사용자 이메일
                .password(password)//비밀번호
                .roles(roles)//사용자 권한
                .build();
    }

}
