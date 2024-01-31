package com.pga.golf.board.domain;


import com.pga.golf.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "reply")
@NoArgsConstructor
@Getter
@SequenceGenerator(
        name = "reply_seq_generator"
        ,sequenceName = "reply_seq"
        ,initialValue = 1
        ,allocationSize = 1
)
public class ReplyEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
            , generator = "reply_seq_generator"
    )
    @Column(name = "reply_seq")
    private long replySeq;

    @ManyToOne(fetch = FetchType.LAZY)
    private BoardEntity board;

    @Column(name = "reply")
    @NotNull
    private String reply;

}
