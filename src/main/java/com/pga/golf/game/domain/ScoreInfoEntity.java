package com.pga.golf.game.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Entity
@Table(name = "score_info")
@NoArgsConstructor
@Getter
public class ScoreInfoEntity implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name = "round_seq")
    private RoundInfoEntity roundInfo;

    @Column(name = "one")
    @NotNull
    private int one; //1번홀

    @Column(name = "two")
    @NotNull
    private int two; //2번홀

    @Column(name = "three")
    @NotNull
    private int three; //3번홀

    @Column(name = "four")
    @NotNull
    private int four; //4번홀

    @Column(name = "five")
    @NotNull
    private int five; //5번홀

    @Column(name = "six")
    @NotNull
    private int six; //6번홀

    @Column(name = "seven")
    @NotNull
    private int seven; //7번홀

    @Column(name = "eight")
    @NotNull
    private int eight; //8번홀

    @Column(name = "nine")
    @NotNull
    private int nine; //9번홀

    @Column(name = "ten")
    @NotNull
    private int ten; //10번홀

    @Column(name = "eleven")
    @NotNull
    private int eleven; //11번홀

    @Column(name = "twelve")
    @NotNull
    private int twelve; //12번홀

    @Column(name = "thirteen")
    @NotNull
    private int thirteen; //13번홀

    @Column(name = "fourteen")
    @NotNull
    private int fourteen; //14번홀

    @Column(name = "fifteen")
    @NotNull
    private int fifteen; //15번홀

    @Column(name = "sixteen")
    @NotNull
    private int sixteen; //16번홀

    @Column(name = "seventeen")
    @NotNull
    private int seventeen; //17번홀

    @Column(name = "eighteen")
    @NotNull
    private int eighteen; //18번홀
}
