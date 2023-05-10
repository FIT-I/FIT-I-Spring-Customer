package com.fiti.customerserver.domain.user.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="certificate_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy="certificate", fetch = FetchType.LAZY)
    private List<TrainerCertificate> trainerCertificateList = new ArrayList<>();
}
