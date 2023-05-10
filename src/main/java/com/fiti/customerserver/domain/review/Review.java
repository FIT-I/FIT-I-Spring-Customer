package com.fiti.customerserver.domain.review;

import com.fiti.customerserver.domain.BaseTimeEntity;
import com.fiti.customerserver.domain.user.entity.Customer;
import com.fiti.customerserver.domain.user.entity.Trainer;
import jakarta.persistence.*;
import lombok.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Review extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="review_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="trainer_id")
    private Trainer trainer;

    private String content;

    private Integer grade;

    private ReviewState state;
}
