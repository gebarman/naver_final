package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@ComponentScan(basePackages="websocket")
@ComponentScan(basePackages="config")
@ComponentScan(basePackages="upload")
@ComponentScan(basePackages="board.spring.mybatis")
@ComponentScan(basePackages="db_jasypt")

@MapperScan(basePackages="board.spring.mybatis")
@SpringBootApplication
//@SpringBootApplication가 있는 클래스의 동일 패키지에선 자동으로 component-scan
//다른 패키지에 있는건 따로 => @ComponentScan
//<context:component-scan base-package="board.spring.mybatis"/>
//필요할 때마다 추가 혹은 배열형태로 {}

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}


