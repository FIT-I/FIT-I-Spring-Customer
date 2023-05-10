package com.fiti.customerserver.domain.matching;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PickupType {
    TRAINER_GO("트레이너가 가요"),
    CUSTOMER_GO("고객이 가요");

    private final String krName;
}
