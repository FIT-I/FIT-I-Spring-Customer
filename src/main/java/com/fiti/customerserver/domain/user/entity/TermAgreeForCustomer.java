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
public class TermAgreeForCustomer extends BaseTimeEntity {
    @EmbeddedId
    private TermAgreeForCustomerId termAgreeForCustomerId;

    @MapsId("termId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "term_id")
    private Term term;

    @MapsId("customerId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private Boolean agree;

    @Embeddable
    @NoArgsConstructor
    @EqualsAndHashCode
    public static class TermAgreeForCustomerId implements Serializable {
        private Long termId;
        private Long customerId;
    }
}
