package com.fiti.customerserver.domain.user.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class School {

    @Column(name="school_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, name = "email_domain")
    private String emailDomain;

    @OneToMany(mappedBy="school", fetch = FetchType.LAZY)
    private List<Trainer> trainerList = new ArrayList<>();

}
