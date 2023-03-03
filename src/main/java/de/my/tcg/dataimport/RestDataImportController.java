package de.my.tcg.dataimport;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import de.my.tcg.dataimport.json.JSONCardMapper;
import de.my.tcg.domain.card.Card;
import de.my.tcg.domain.card.CardService;
import de.my.tcg.domain.cardset.CardSet;
import de.my.tcg.domain.cardset.CardSetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HexFormat;
import java.util.List;

@RestController
@Slf4j
public class RestDataImportController {

    private final CardService cardService;
    private final CardSetService cardSetService;



    @Autowired
    public RestDataImportController(CardService cardService, CardSetService cardSetService) {
        this.cardService = cardService;
        this.cardSetService = cardSetService;
    }

    @GetMapping(value = "/SimpleCard")
    public String getSimpleCard() {
        String url = "https://api.pokemontcg.io/v2/cards";
        return getCardsFromApiAndSave(url);
    }

    private String getCardsFromApiAndSave(String url) {
        String json = excecuteGetRequest(url);
        ObjectMapper mapper = new ObjectMapper();
        try {
            ObjectNode node = mapper.readValue(json, ObjectNode.class);
            ArrayNode arrayNode = (ArrayNode) node.get("data");
            for (JsonNode jsonNode : arrayNode) {
                Card card = JSONCardMapper.jsonToDomainMapper((ObjectNode) jsonNode, Card.class);
                if(!cardService.existsByShortDescrption(card)){
                    log.info("save: " + card.toString());
                    cardService.addCard(card);
                }
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return json;
    }

    private String excecuteGetRequest(String url) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, generateHttpEnity(), String.class);
        return response.getBody();
    }

    @GetMapping(value = "/CardSets")
    public String getAllCardSets() {
        String url = "https://api.pokemontcg.io/v2/sets";

        return getSetsFromApiAndSave(url);

    }

    private String getSetsFromApiAndSave(String url) {
        String json = excecuteGetRequest(url);
        ObjectMapper mapper = new ObjectMapper();
        try {
            ObjectNode node = mapper.readValue(json, ObjectNode.class);
            ArrayNode arrayNode = (ArrayNode) node.get("data");
            for (JsonNode jsonNode : arrayNode) {
                CardSet cardSet = JSONCardMapper.jsonToDomainMapper((ObjectNode) jsonNode, CardSet.class);
                log.info("save: " + cardSet.toString());
                cardSetService.addCardSet(cardSet);
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return json;
    }


    @GetMapping(value = "/CardsFromCardSets")
    public String getCardsFromAllCardSets() {
        List<CardSet> allCardSets = cardSetService.getAllCardSets();
        allCardSets.stream().filter(cardSet -> cardSet.getId()>146).
                forEach(cs -> getCardsFromApiAndSave("https://api.pokemontcg.io/v2/cards?q=set.id:" + cs.getShortname()));
        return "All Cards Saved";
    }



    private byte[] loadImageFromUrl(String url) {
        RestTemplate restTemplate = new RestTemplate();
        byte[] img;
        try {
            img=restTemplate.getForObject(url, byte[].class);
        }catch (HttpClientErrorException e){
            img= HexFormat.of().parseHex("");
        }
       return img;
    }


    private HttpEntity<Object> generateHttpEnity() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-api-key", "cef73fc1-efa6-45ba-9424-315fab43fd5a");
        return new HttpEntity<>(headers);
    }


}
