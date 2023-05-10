package com.fiti.customerserver.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fiti.customerserver.domain.user.entity.*;
import com.fiti.customerserver.domain.user.repository.CustomerImgRepository;
import com.fiti.customerserver.domain.user.repository.CustomerRepository;
import com.fiti.customerserver.jwt.JwtTokenProvider;
import com.fiti.customerserver.response.exception.BusinessException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fiti.customerserver.web.AccountDto.*;
import static com.fiti.customerserver.response.exception.ErrorCode.*;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountService {

    private final CustomerRepository customerRepository;
    private final CustomerImgRepository customerImgRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;

    public void join(String email, String password, String name) {
        String encodedPwd = passwordEncoder.encode(password);
        Customer customer = Customer.join(email, encodedPwd, name);
        CustomerImg customerImg = CustomerImg.builder().customer(customer).build();
        customerRepository.save(customer);
        customerImgRepository.save(customerImg);
        //todo 존재하는 email인지 확인 필요?
    }

    public Tokens login(String email, String password) throws BusinessException {
        //유저 존재 여부 체크
        if(customerRepository.existsByEmail(email)){
            return generateJwtTokens(email, password);
        }else{
            throw new BusinessException(ACCOUNT_NOT_FOUND);
        }

    }

    public Tokens generateJwtTokens(String email, String password) throws BusinessException {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, password);
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        try{
            return jwtTokenProvider.generateTokens(authentication);
        }catch (JsonProcessingException e){
            throw new BusinessException(INVALID_JWT_TOKEN);
        }
    }

}
