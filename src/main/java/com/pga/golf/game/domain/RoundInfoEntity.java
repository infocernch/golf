package com.pga.golf.game.domain;

import com.pga.golf.common.BaseTimeEntity;
import com.pga.golf.golfer.domain.GolferEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "round_info")
@NoArgsConstructor
@SequenceGenerator(
        name = "roundInfo_seq_generator",
        sequenceName = "round_seq",
        initialValue = 1,
        allocationSize = 1
)
public class RoundInfoEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
            , generator = "roundInfo_seq_generator"
    )
    @Column(name = "round_seq")
    private long roundSeq;//라운딩 시퀀스

    @ManyToOne(fetch = FetchType.LAZY)
    private GolferEntity golfer;

    @OneToOne(mappedBy = "roundInfo", cascade = CascadeType.ALL)
    private HoleInfoEntity holeInfo;

    @OneToOne(mappedBy = "roundInfo", cascade = CascadeType.ALL)
    private ScoreInfoEntity scoreInfo;


}
