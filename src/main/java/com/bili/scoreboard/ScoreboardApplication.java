package com.bili.scoreboard;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
 /**
 　　* @description: application start
 　　* @return ${return_type}
 　　* @throws
 　　* @author oxx
 　　* @date 2021/1/26 20:46
 　　*/
//开启缓存（redis）
@EnableCaching
//开启注解支持Swagger
@EnableSwagger2
//开启注解支持rabbitmq
@EnableRabbit
//开启注解支持事务
@EnableTransactionManagement
@SpringBootApplication
public class ScoreboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScoreboardApplication.class, args);
    }

}
