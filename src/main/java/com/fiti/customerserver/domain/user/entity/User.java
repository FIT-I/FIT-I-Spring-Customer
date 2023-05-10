package com.fiti.customerserver.domain.user.entity;

import com.fiti.customerserver.domain.BaseTimeEntity;
import com.fiti.customerserver.domain.user.enums.Role;
import com.fiti.customerserver.domain.user.enums.UserState;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;

@Getter
@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
public class User extends BaseTimeEntity {

    @Column(unique = true, name = "email")
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String name;

    private UserState state;

    @ColumnDefault("'off'")
    private String alarmState;

    private String location;

}
