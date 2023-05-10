package com.fiti.customerserver.web;

import com.fiti.customerserver.response.BaseResponse;
import com.fiti.customerserver.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public BaseResponse<String> join(@Valid @RequestBody AccountDto.Join join){
        accountService.join(join.getEmail(), join.getPassword(), join.getName());
        return new BaseResponse("ok");
    }


}
