package com.ist.RentACar.jms;

import com.ist.RentACar.model.Voiture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.util.HashMap;
import java.util.Map;

@Component
public class PostVoitureProducer implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(PostVoitureProducer.class);

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Override
    public void run(String... args) throws Exception {
        log.info("PostVoitureProducer");
    }


    public void send(Voiture v) {
        log.info("Sending: " + v.toString());
        jmsMessagingTemplate.convertAndSend(this.queue, v);
    }


}
