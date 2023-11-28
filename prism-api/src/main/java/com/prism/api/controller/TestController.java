package com.prism.api.controller;

import com.prism.api.model.Test;
import com.prism.api.service.TestService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author anliwen
 */
@RestController
@Slf4j
public class TestController {

    @Resource
    TestService testService;

    @GetMapping("/test1")
    private String test1() {
        List<Test> test = testService.test1();
        log.info("This log info test! come from api!");
        return test.toString();
    }

    @GetMapping("/test2")
    private String test2() {
        List<Test> test = testService.test2();
        log.info("This log info test! come from api!");
        return test.toString();
    }
}
