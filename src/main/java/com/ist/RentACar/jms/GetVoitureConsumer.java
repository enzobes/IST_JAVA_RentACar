package com.ist.RentACar.jms;

import com.ist.RentACar.model.Voiture;
import com.ist.RentACar.service.VoitureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class GetVoitureConsumer {

    private static final Logger log = LoggerFactory.getLogger(GetVoitureConsumer.class);

    @Autowired
    private VoitureService voitureService;

    @JmsListener(destination = "getvoiture")
    public Voiture receiveQueue(Message msg) {
        log.info("Received id:" + msg.getPayload());
        return voitureService.findOne((Long)msg.getPayload());
    }

}