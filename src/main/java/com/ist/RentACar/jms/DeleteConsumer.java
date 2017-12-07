package com.ist.RentACar.jms;

import com.ist.RentACar.service.VoitureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DeleteConsumer {

    private static final Logger log = LoggerFactory.getLogger(DeleteConsumer.class);

    @Autowired
    private VoitureService voitureService;

    @JmsListener(destination = "deletevoiture")
    public void receiveQueue(Message msg) {
        log.info("Received");
        voitureService.delete((Long)msg.getPayload());
    }

}