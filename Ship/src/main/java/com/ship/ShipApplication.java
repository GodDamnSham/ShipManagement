package com.ship;

import com.ship.entity.Ship;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@EnableFeignClients
@EnableDiscoveryClient
@ComponentScan(basePackages="com.ship.*")
@SpringBootApplication
public class ShipApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShipApplication.class, args);
    }

}
