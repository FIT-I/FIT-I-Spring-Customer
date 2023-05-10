package com.fiti.customerserver.domain.user.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class TrainerCertificate {
    @EmbeddedId
    private TrainerCertificateId trainerCertificateId;

    @MapsId("trainerId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    @MapsId("certificateId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "certificate_id")
    private Certificate certificate;

    @Embeddable
    @NoArgsConstructor
    @EqualsAndHashCode
    public static class TrainerCertificateId implements Serializable {
        private Long trainerId;
        private Long certificateId;
    }
}
