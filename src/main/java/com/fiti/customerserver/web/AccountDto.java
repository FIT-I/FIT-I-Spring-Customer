package com.fiti.customerserver.web;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class AccountDto {

    @Schema(title = "트레이너 회원가입")
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Join {
        @NotBlank(message = "이메일을 입력해주세요.")
        @Email(message = "올바른 이메일 주소를 입력해주세요.")
        @Schema(description = "이메일", example = "test@email.com")
        private String email;

        @NotBlank(message = "비밀번호를 입력해주세요.")
        @Schema(description = "비밀번호", example = "qlalfqjsgh")
        //@Size(min = 8, max = 20, message = "비밀번호는 8자 이상 20자 이하로 입력해주세요.")
        private String password;

        @NotBlank(message = "이름 입력해주세요.")
        @Schema(description = "이름", example = "김무땡")
        //@Size(min = 2, max = 10, message = "닉네임은 2자 이상 10자 이하로 입력해주세요.")
        private String name;
    }
}
