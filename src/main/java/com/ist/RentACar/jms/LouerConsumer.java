package com.ist.RentACar.jms;

import com.ist.RentACar.model.Client;
import com.ist.RentACar.service.VoitureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class LouerConsumer {

    private static final Logger log = LoggerFactory.getLogger(LouerConsumer.class);

    @Autowired
    private VoitureService voitureService;

    @JmsListener(destination = "louervoiture")
    public void receiveQueue(Message msg) {
        Map<String, String> map = (Map<String, String>) msg.getPayload();

        voitureService.rentVoiture(Long.parseLong(map.get("voiture_id"), 10), new Client(map.get("firstName"), map.get("lastName")));

    }

}