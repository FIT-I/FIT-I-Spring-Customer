package com.fiti.customerserver.web;

import com.fiti.customerserver.response.BaseResponse;
import com.fiti.customerserver.response.exception.BusinessException;
import com.fiti.customerserver.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
     * 이메일 중복 체크
     */
    @Operation(summary = "이메일 중복 체크", description = "고객 회원가입시 이메일 중복 체크")
    @GetMapping("email-duplicate/{email}")
    public BaseResponse<EmailDuplicateCheck> joinValidation(@Parameter(name = "email", description = "이메일",
            in = ParameterIn.PATH) @PathVariable String email){
        boolean emailDuplicated = accountService.emailDuplicateCheck(email);
        return new BaseResponse(new EmailDuplicateCheck(emailDuplicated));
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
