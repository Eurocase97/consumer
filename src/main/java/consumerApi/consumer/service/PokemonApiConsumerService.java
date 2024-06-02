package consumerApi.consumer.service;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import consumerApi.consumer.Controller.PokemonApiConsumer;
import consumerApi.consumer.model.Abilities;
import consumerApi.consumer.model.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class PokemonApiConsumerService {

    private final Logger log = LoggerFactory.getLogger(PokemonApiConsumer.class);
    private String baseUrl = "https://pokeapi.co/api/v2/";
    private final RestTemplate restTemplate;

    private PokemonApiConsumerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
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
/*Still do not work*/
    public  String getAbilities(String token, String pokemonName) throws JsonProcessingException {
        String uri = baseUrl + "pokemon/" + pokemonName.toLowerCase();
        HttpEntity<Map<String, String>> requestEntity = new HttpEntity("");
        ResponseEntity<String> response = restTemplate.exchange(
                uri, HttpMethod.GET, requestEntity , String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            log.info("Successfully user creation: {}", response.getBody().toString());

            ObjectMapper objectMapper = new ObjectMapper();
           // objectMapper.readValue(response.getBody().toString(), objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Abilities.class));
            objectMapper.readValue(response.getBody().toString(), new TypeReference<List<Abilities>>(){});

            return  response.toString();
        }

        log.error("Error in user creation - httpStatus was: {}", response.getStatusCode());
        throw new RuntimeException("Error");
    }

    public   ResponseEntity<String>  getRandomWoman(String token) throws JsonProcessingException {
        String uri = "https://randomuser.me/api/?gender=female";
        HttpEntity<Map<String, String>> requestEntity = new HttpEntity("");
        ResponseEntity<String> response = restTemplate.exchange(
                uri, HttpMethod.GET, requestEntity , String.class);

        if (response.getStatusCode().is2xxSuccessful()) {

            ObjectMapper objectMapper = new ObjectMapper();
            Results results= objectMapper.readValue(response.getBody(), Results.class);

            if(results.getId() == null){
                log.info("no funciona");
            }
            return response;
        }
        log.error("Error in user creation - httpStatus was: {}", response.getStatusCode());
        throw new RuntimeException("Error");
    }
}