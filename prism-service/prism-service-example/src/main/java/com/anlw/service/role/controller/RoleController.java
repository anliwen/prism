package com.anlw.service.role.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author anliwen
 */
@Tag(name = "DBxx")
@RestController
@ApiSupport(author = "aaa安")
public class RoleController {

    @ApiOperationSupport(author = "安利文abk", order = 113)
    @PostMapping("/db")
    @Operation(summary = "db操作缓存测试示例11")

    public LoginReqVO test(@RequestBody LoginReqVO loginReqVO) {
        return null;
    }

    @ApiOperationSupport(order = 31)
    @Operation(summary = "xx")
    @GetMapping("/db2")
    public String test2() {
        return "this is db23";
    }

    @Schema(name = "登录VO", description = "登录校验 - 接收登录请求参数 request vo")
    @Data
    public class LoginReqVO {

        @Schema(description = "用户账号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "admin")
        @NotBlank(message = "用户名不能为空")
        @Pattern(regexp = "^[A-Za-z0-9]+$", message = "账号格式为数字以及字母")
        private String username;

        @Schema(description = "用户密码", requiredMode = Schema.RequiredMode.REQUIRED, example = "123456")
        @NotBlank(message = "密码不能为空")
        private String password;
    }
}
