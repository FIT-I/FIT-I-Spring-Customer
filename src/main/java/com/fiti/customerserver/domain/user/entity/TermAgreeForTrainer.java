package com.fiti.customerserver.domain.user.entity;

import com.fiti.customerserver.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class TermAgreeForTrainer extends BaseTimeEntity {
    @EmbeddedId
    private TermAgreeForTrainerId termAgreeForTrainerId;

    @MapsId("termId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "term_id")
    private Term term;

    @MapsId("trainerId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    private Boolean agree;

    @Embeddable
    @NoArgsConstructor
    @EqualsAndHashCode
    public static class TermAgreeForTrainerId implements Serializable {
        private Long termId;
        private Long trainerId;
    }
}
