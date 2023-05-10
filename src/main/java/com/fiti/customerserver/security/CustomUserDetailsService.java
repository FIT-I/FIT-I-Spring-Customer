package com.fiti.customerserver.security;

import com.fiti.customerserver.domain.user.entity.Customer;
import com.fiti.customerserver.domain.user.repository.CustomerRepository;
import com.fiti.customerserver.response.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import static com.fiti.customerserver.response.exception.ErrorCode.*;


@Slf4j
@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws BusinessException{
        log.info("CustomUserDetailService loadUserByUsername username : "+ username);
        Customer customer = customerRepository.findByEmail(username)
                .orElseThrow(()-> new BusinessException(ACCOUNT_NOT_FOUND));
        return new CustomUserDetails(customer);
    }

}
