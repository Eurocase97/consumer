package consumerApi.consumer.Controller;

import consumerApi.consumer.service.PokemonApiConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class PokemonApiConsumer {

    private final PokemonApiConsumerService pokemonApiConsumerService;
    private final Logger log = LoggerFactory.getLogger(PokemonApiConsumer.class);

    public PokemonApiConsumer(PokemonApiConsumerService pokemonApiConsumerService) {
        this.pokemonApiConsumerService = pokemonApiConsumerService;
    }

    @GetMapping("/{pokemonName}")
    public ResponseEntity<String> UsePokemonEndpoint(@PathVariable String pokemonName) {
        return pokemonApiConsumerService.usePokemonEndpoint("", pokemonName);
    }
}
