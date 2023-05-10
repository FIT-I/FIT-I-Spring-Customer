package com.fiti.customerserver.domain.user.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Builder
public class TrainerImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="trainer_img_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="trainer_id")
    private Trainer trainer;

    @ColumnDefault("'default.jpg'")
    private String trainerProfileImgUrl;

    @Builder.Default
    @OneToMany(mappedBy="trainerImg", fetch = FetchType.LAZY)
    private List<TrainerBgImg> trainerBgImgList = new ArrayList<>();
}
