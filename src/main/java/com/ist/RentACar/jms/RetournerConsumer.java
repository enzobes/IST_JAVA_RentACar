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
public class RetournerConsumer {

    private static final Logger log = LoggerFactory.getLogger(RetournerConsumer.class);

    @Autowired
    private VoitureService voitureService;

    @JmsListener(destination = "returnvoiture")
    public void receiveQueue(Message msg) {
        Map<String, String> map = (Map<String, String>) msg.getPayload();

        log.info("Received: id=" + map.get("id"));
        Long id = Long.parseLong(map.get("id"), 10);
        this.voitureService.retournerVoitue(id);
    }

}