package com.pga.golf.board.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pga.golf.common.BaseTimeEntity;
import com.pga.golf.golfer.domain.GolferEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Table(name = "board")
@NoArgsConstructor
@Getter
@SequenceGenerator(
        name = "board_seq_generator"
        ,sequenceName = "board_seq"
        ,initialValue = 1
        ,allocationSize = 1
)
public class BoardEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
            , generator = "board_seq_generator"
    )
    @Column(name = "board_seq")
    private long boardSeq;

    @ManyToOne(fetch = FetchType.LAZY)
    private GolferEntity golfer;

    @Column(name = "description")
    @NotNull
    private String description;//본문

    @Column(name = "views")
    @NotNull
    private int views;//조회수

    @Column(name = "likes")
    @NotNull
    private long likes;//좋아요

    @OneToMany(mappedBy = "board")
    private List<ReplyEntity> replies;
}
