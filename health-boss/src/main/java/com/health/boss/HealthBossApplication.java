package com.health.boss;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Create By yangwei
 * Create at 2020/04/15 14:48
 * Description: 
 */

@MapperScan("com.health.boss.mapper")
//@EnableScheduling
@SpringBootApplication
public class HealthBossApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthBossApplication.class, args);
    }


}
