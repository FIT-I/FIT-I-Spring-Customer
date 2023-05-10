package com.fiti.customerserver.domain.user.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {

    PT("개인 PT"),
    DIET("다이어트"),
    FOOD_CHECK("식단관리"),
    REHAB("재활치료");

    private final String krName;

}
