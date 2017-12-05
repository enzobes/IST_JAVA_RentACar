package com.ist.RentACar.jms;

import com.ist.RentACar.model.Voiture;
import com.ist.RentACar.service.VoitureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class VoitureConsumer {

    private static final Logger log = LoggerFactory.getLogger(VoitureConsumer.class);

    @Autowired
    private VoitureService voitureService;

    @JmsListener(destination = "rentacard.queue")
    public void receiveQueue(Message msg) {

        log.info("Voiture Received: " + msg.getPayload().toString());
        Map<String, String> map = (Map<String, String>) msg.getPayload();

        Voiture v = new Voiture(map.get("plateNumber"), map.get("marque"));

        this.voitureService.saveVoiture(v);
        log.info("Voiture Created: " + v.toString());
    }

}