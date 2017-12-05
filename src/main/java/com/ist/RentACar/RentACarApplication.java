package com.ist.RentACar;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Queue;

@SpringBootApplication
@EnableJms
public class RentACarApplication {


    @Bean
    public Queue queue() {
        return new ActiveMQQueue("postvoiture");
    }

    @Bean
    public Queue queue2() {
        return new ActiveMQQueue("getvoiture");
    }

    @Bean
    public Queue queue3() {
        return new ActiveMQQueue("getvoitures");
    }

    @Bean
    public Queue queue4() {
        return new ActiveMQQueue("louervoiture");
    }

    @Bean
    public Queue queue5() {
        return new ActiveMQQueue("deletevoiture");
    }

    @Bean
    public Queue queue6() {
        return new ActiveMQQueue("returnvoiture");
    }


    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(RentACarApplication.class, args);

        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
    }

}
