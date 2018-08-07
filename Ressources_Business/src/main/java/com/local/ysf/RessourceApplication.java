package com.local.ysf;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.local.ysf")
@EntityScan(basePackages="com.local.ysf")
public class RessourceApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(RessourceApplication.class, args);
	}

}
