package com.anlw.service.user.controller;

import com.anlw.service.user.model.CourseType;
import com.anlw.service.user.model.MapEnumUser;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

/**
 * @author anliwen
 */
@RestController
@Tag(name = "这是类Tag名称")
public class UserController {

    @GetMapping("/test1")
    @ApiOperationSupport(author = "这是接口作者", order = 1)
    @Operation(summary = "这是接口名称", description = "这是接口描述")
    public String test1() {
        return "this is test1";
    }

    @GetMapping("/test2")
    public String test2() {
        return "this is test2";
    }

    @PostMapping("/test3")
    public MapEnumUser test3(@RequestBody MapEnumUser mapEnumUser) {
        return mapEnumUser;
    }

    @GetMapping("/test4")
    public CourseType test4(@RequestParam(name = "courseType") CourseType courseType) {
        return courseType;
    }

    @GetMapping("/test5")
    @Parameters({
            @Parameter(name = "username", description = "用户名", required = false),
            @Parameter(name = "password", description = "密码", schema = @Schema(name = "pwd", format = "binary"))
    })
    public String test5(@RequestParam(value = "username", required = false) String username, @RequestParam("password") String password) {
        return username + password;
    }

    @GetMapping("/test6")
    @Parameter(name = "username", description = "用户名", required = false)
    public String test6(String username) {
        return username;
    }
}
