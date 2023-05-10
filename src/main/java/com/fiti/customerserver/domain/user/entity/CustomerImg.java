package com.fiti.customerserver.domain.user.entity;

import jakarta.persistence.*;
import lombok.*;


@Builder
@AllArgsConstructor
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CustomerImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_img_id")
    private Long id;

    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private String customerProfileImgUrl;
}
