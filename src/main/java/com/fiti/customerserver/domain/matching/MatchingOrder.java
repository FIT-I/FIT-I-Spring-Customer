package com.fiti.customerserver.domain.matching;

import com.fiti.customerserver.domain.BaseTimeEntity;
import com.fiti.customerserver.domain.user.entity.Customer;
import com.fiti.customerserver.domain.user.entity.Trainer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class MatchingOrder extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="matching_order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="trainer_id")
    private Trainer trainer;

    private LocalDate startAt;

    private LocalDate finishAt;

    private PickupType pickupType;

    private MatchingState state;

    private String openchatLink;
}
