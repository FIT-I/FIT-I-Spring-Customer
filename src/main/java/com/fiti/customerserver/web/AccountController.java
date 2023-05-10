package com.fiti.customerserver.web;

import com.fiti.customerserver.response.BaseResponse;
import com.fiti.customerserver.response.exception.BusinessException;
import com.fiti.customerserver.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiti.customerserver.web.AccountDto.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/accounts/")
public class AccountController {

    private final AccountService accountService;

    /**
     * 회원가입
     */
    @Operation(summary = "고객 회원가입", description = "고객 회원가입")
    @PostMapping("join")
    public BaseResponse<String> join(@Valid @RequestBody Join join){
        accountService.join(join.getEmail(), join.getPassword(), join.getName());
        return new BaseResponse("ok");
    }
    /**
     * 로그인
     */
    @Operation(summary = "고객 로그인", description = "고객 로그인")
    @PostMapping("login")
    public BaseResponse<Tokens> login(@Valid @RequestBody Login login){
        try{
            Tokens tokens = accountService.login(login.getEmail(), login.getPassword());
            return new BaseResponse(tokens);

        }catch (BusinessException e){
            return new BaseResponse<>(e.getErrorCode());
        }
    }

}
