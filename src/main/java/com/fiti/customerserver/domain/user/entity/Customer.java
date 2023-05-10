package com.fiti.customerserver.domain.user.entity;

import com.fiti.customerserver.domain.matching.MatchingOrder;
import com.fiti.customerserver.domain.matching.Wish;
import com.fiti.customerserver.domain.redbell.Redbell;
import com.fiti.customerserver.domain.review.Review;
import com.fiti.customerserver.domain.user.enums.Role;
import com.fiti.customerserver.domain.user.enums.UserState;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
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

    public static Customer join(String email, String password, String name){
        return Customer.builder().email(email).password(password).name(name)
                .role(Role.CUSTOMER).state(UserState.ACTIVE)
                .location("not-set").alarmState("off").build();
    }
}
