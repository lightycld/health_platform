package com.health.wechat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Create By yangwei
 * Create at 2020/04/15 14:48
 * Description: 
 */

@MapperScan("com.health.boss.mapper")
//@EnableScheduling
@SpringBootApplication
public class HealthWechatApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthWechatApplication.class, args);
    }


}
