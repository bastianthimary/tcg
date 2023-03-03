package de.my.tcg.dataimport.json.builder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TrainerRuleToFlavorBuilder extends AbstractJsonBuilder {
    StringBuilder stringBuilder;

    public TrainerRuleToFlavorBuilder(JsonNode arrayNode) {
        stringBuilder = new StringBuilder();
        arrayNode.forEach(node -> stringBuilder.append(node.asText()));
    }

    public JsonNode createFlavorNode(){

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node;
        try {
            node = mapper.readTree(surroundWithQuoteStrings(stringBuilder.toString()));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return node;
    }


}
