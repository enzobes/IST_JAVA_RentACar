package com.ist.RentACar.jms;

        import com.ist.RentACar.model.Client;
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
public class LouerProducer implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(LouerProducer.class);

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue4;

    @Override
    public void run(String... args) throws Exception {
        log.info("LouerProducer");
    }


    public void send(Client v, Long id) {
        log.info("Sending: " + v.toString());
        Map m1 = new HashMap();
        m1.put("voiture_id", id.toString());
        m1.put("firstName", v.getFirstName());
        m1.put("lastName", v.getLastName());
        jmsMessagingTemplate.convertAndSend(this.queue4, m1);
    }


}
