package com.example.modulith;

import com.example.modulith.order.Order;
import com.example.modulith.order.OrderManagement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
@ConfigurationPropertiesScan
public class SpringmodulithApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmodulithApplication.class, args)
				.getBean(OrderManagement.class)
				.complete(new Order());	}

}
