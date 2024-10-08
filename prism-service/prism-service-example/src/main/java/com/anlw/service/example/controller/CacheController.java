package com.anlw.service.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author anliwen
 */
@RestController
public class CacheController {

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
