package com.fiti.customerserver.service;

import com.fiti.customerserver.domain.user.entity.*;
import com.fiti.customerserver.domain.user.repository.CustomerImgRepository;
import com.fiti.customerserver.domain.user.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountService {

    private final CustomerRepository customerRepository;
    private final CustomerImgRepository customerImgRepository;
    private final PasswordEncoder passwordEncoder;

    public void join(String email, String password, String name) {
        String encodedPwd = passwordEncoder.encode(password);
        Customer customer = Customer.join(email, encodedPwd, name);
        CustomerImg customerImg = CustomerImg.builder().customer(customer).build();
        customerRepository.save(customer);
        customerImgRepository.save(customerImg);
        //todo 존재하는 email인지 확인 필요?
    }

}
