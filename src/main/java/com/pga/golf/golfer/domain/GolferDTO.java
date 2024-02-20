package com.pga.golf.golfer.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pga.golf.board.domain.BoardEntity;
import com.pga.golf.game.domain.RoundInfoEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

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
}
