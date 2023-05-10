package com.fiti.customerserver.domain.user.entity;

import com.fiti.customerserver.domain.matching.MatchingOrder;
import com.fiti.customerserver.domain.matching.Wish;
import com.fiti.customerserver.domain.redbell.Redbell;
import com.fiti.customerserver.domain.review.Review;
import com.fiti.customerserver.domain.user.enums.Category;
import com.fiti.customerserver.domain.user.enums.Level;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicInsert;

import java.util.ArrayList;
import java.util.List;

@DynamicInsert
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Trainer extends User{

    @Column(name="trainer_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "trainer", cascade = CascadeType.ALL)
    private TrainerImg trainerImg;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_id")
    private School school;

    private String major;

    @Enumerated(EnumType.STRING)
    private Level level;

    private Integer priceHour1;

    private Integer priceHour2;

    private Integer priceHour3;

    private String intro;

    private String serviceInfo;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String openChatLink;

    @Builder.Default
    @OneToMany(mappedBy="trainer", fetch = FetchType.LAZY)
    private List<TrainerCertificate> trainerCertificateList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy="trainer", fetch = FetchType.LAZY)
    private List<TermAgreeForTrainer> termAgreeForTrainerList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy="trainer", fetch = FetchType.LAZY)
    private List<MatchingOrder> matchingOrderList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy="trainer", fetch = FetchType.LAZY)
    private List<Wish> wishList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy="trainer", fetch = FetchType.LAZY)
    private List<Review> reviewList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy="trainer", fetch = FetchType.LAZY)
    private List<Redbell> redbellList = new ArrayList<>();

}
