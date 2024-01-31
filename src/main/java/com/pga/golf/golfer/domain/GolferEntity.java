package com.pga.golf.golfer.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pga.golf.board.domain.BoardEntity;
import com.pga.golf.common.BaseTimeEntity;
import com.pga.golf.game.domain.RoundInfoEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "GOLFER")
@SequenceGenerator(//시퀀스
        name = "golfer_seq_generator"
        , sequenceName = "golfer_seq"
        , initialValue = 1
        ,allocationSize = 1
)
public class GolferEntity extends BaseTimeEntity {

    //기본키
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
            , generator = "golfer_seq_generator"
    )
    @Column(name = "golfer_seq")
    private long golferSeq;


    @Column(name = "name")
    private String name;//닉네임

    @Column(name = "id")
    @NotNull
    private String id;

    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "handy", nullable = false)
    private int handy;

    @Column(name = "golfer_status")
    @ColumnDefault("1")
    private int golferStatus; //회원 상태


    @OneToMany(mappedBy = "golfer")
    @JsonIgnore
    private List<RoundInfoEntity> rounds;

    @OneToMany(mappedBy = "golfer")
    @JsonIgnore
    private List<BoardEntity> boards;

}
