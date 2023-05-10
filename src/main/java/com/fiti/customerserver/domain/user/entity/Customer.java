package com.fiti.customerserver.domain.user.entity;

import com.fiti.customerserver.domain.matching.MatchingOrder;
import com.fiti.customerserver.domain.matching.Wish;
import com.fiti.customerserver.domain.redbell.Redbell;
import com.fiti.customerserver.domain.review.Review;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @OneToOne(mappedBy = "customer", fetch = FetchType.LAZY)
    private CustomerImg customerImg;

    @OneToMany(mappedBy="customer", fetch = FetchType.LAZY)
    private List<TermAgreeForCustomer> termAgreeForCustomerList = new ArrayList<>();

    @OneToMany(mappedBy="customer", fetch = FetchType.LAZY)
    private List<MatchingOrder> matchingOrderList = new ArrayList<>();

    @OneToMany(mappedBy="customer", fetch = FetchType.LAZY)
    private List<Wish> wishList = new ArrayList<>();

    @OneToMany(mappedBy="customer", fetch = FetchType.LAZY)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy="customer", fetch = FetchType.LAZY)
    private List<Redbell> redbellList = new ArrayList<>();
}
