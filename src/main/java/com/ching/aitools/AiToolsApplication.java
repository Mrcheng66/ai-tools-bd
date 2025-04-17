package com.ching.aitools;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ching.aitools.mapper")
public class AiToolsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiToolsApplication.class, args);
    }

}
