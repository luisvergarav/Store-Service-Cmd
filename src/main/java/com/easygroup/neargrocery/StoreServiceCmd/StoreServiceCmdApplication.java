package com.easygroup.neargrocery.StoreServiceCmd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration(exclude = {
		HibernateJpaAutoConfiguration.class})
public class StoreServiceCmdApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreServiceCmdApplication.class, args);
	}
}
