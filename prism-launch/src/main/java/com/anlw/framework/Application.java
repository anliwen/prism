package com.anlw.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author anliwen
 */
@SpringBootApplication(scanBasePackages = "com.anlw.*")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
