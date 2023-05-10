package com.fiti.customerserver.domain.user.repository;

import com.fiti.customerserver.domain.user.entity.CustomerImg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerImgRepository extends JpaRepository<CustomerImg, Long> {
}
