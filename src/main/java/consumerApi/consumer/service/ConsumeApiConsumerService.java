package consumerApi.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class ConsumeApiConsumerService {

    private final Logger logger = LoggerFactory.getLogger(ConsumeApiConsumerService.class);

    @GetMapping()
    public void getPokemon(){
        logger.info("CONTROLLER: invoked getPokemon method");
    }

}
