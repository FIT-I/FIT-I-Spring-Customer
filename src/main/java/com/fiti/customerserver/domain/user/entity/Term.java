package com.fiti.customerserver.domain.user.entity;

import com.fiti.customerserver.domain.user.enums.Role;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Term {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="term_id")
    private Long id;

    @Column(unique = true)
    private String title;

    private String content;

    private Role target;

    private Boolean required;

    @OneToMany(mappedBy="term", fetch = FetchType.LAZY)
    private List<TermAgreeForTrainer> termAgreeForTrainerList = new ArrayList<>();

    @OneToMany(mappedBy="term", fetch = FetchType.LAZY)
    private List<TermAgreeForCustomer> termAgreeForCustomerList = new ArrayList<>();

}
