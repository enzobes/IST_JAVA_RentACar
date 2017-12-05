package com.ist.RentACar;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;

@SpringBootApplication
@EnableJms
public class RentACarApplication {

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("rentacard.queue");
    }

    public static void main(String[] args) {

        SpringApplication.run(RentACarApplication.class, args);
    }

}
