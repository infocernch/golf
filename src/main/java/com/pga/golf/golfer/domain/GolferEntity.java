package com.pga.golf.golfer.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pga.golf.board.domain.BoardEntity;
import com.pga.golf.common.BaseTimeEntity;
import com.pga.golf.game.domain.RoundInfoEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Column(name = "roles")
    @NotNull
    private String roles;//user, admin


    public List<String> getRoleList() {
        if (this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    @Builder
    public GolferEntity(String name, @NotNull String id, @NotNull String email, @NotNull String password, int handy, int golferStatus, @NotNull String roles) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.password = password;
        this.handy = handy;
        this.golferStatus = golferStatus;
        this.roles = roles;
    }
}
