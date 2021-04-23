package org.abc.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.abc.demo.dao")
public class DemoApplication {
    public static void main(String[] args) {
         SpringApplication.run(DemoApplication.class,args);
    }
}
