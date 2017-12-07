package com.ist.RentACar.jms;

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
public class DeleteProducer implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DeleteProducer.class);

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue5;

    @Override
    public void run(String... args) throws Exception {
        log.info("DeleteProducer");
    }


    public void send(Long id) {
        log.info("Delete: id=" + id.toString());
        jmsMessagingTemplate.convertAndSend(this.queue5, id);
    }


}
