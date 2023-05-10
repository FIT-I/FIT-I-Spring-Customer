package com.fiti.customerserver.domain.user.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class TrainerBgImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="trainer_bg_img_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="trainer_img_id")
    private TrainerImg trainerImg;

    private String trainerBgImgUrl;
}
