package com.example.onenight;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import javax.validation.constraints.Max;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.onenight.*"})
@MapperScan(basePackages ={"com.example.onenight.mapper"} )
@EnableRedisHttpSession//将session持久化到redis,作用是当服务器关闭时session不会注销，用于跨服务调用session
public class OnenightApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnenightApplication.class, args);
    }

}
