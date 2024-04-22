package consumerApi.consumer.service;

import consumerApi.consumer.Controller.PokemonApiConsumer;
import consumerApi.consumer.model.Pokemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class PokemonApiConsumerService {

    private final Logger log = LoggerFactory.getLogger(PokemonApiConsumer.class);
    private String baseUrl = "https://pokeapi.co/api/v2/";
    private final RestTemplate restTemplate;

    private PokemonApiConsumerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private HttpHeaders buildAuthToken(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", "Bearer " + token);
        return headers;
    }

    public  ResponseEntity<String> usePokemonEndpoint(String token, String pokemonName) {
        String uri = baseUrl + "pokemon/" + pokemonName.toLowerCase();
        HttpEntity<Map<String, String>> requestEntity = new HttpEntity("");
        ResponseEntity<String> response = restTemplate.exchange(
                uri, HttpMethod.GET, requestEntity , String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            log.info("Successfully user creation: {}", response.getBody().toString());
            return  response;
        }
        log.error("Error in user creation - httpStatus was: {}", response.getStatusCode());
        throw new RuntimeException("Error");
    }

}