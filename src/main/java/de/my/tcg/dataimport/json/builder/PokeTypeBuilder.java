package de.my.tcg.dataimport.json.builder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.my.tcg.basedata.poketype.PokeType;

public class PokeTypeBuilder extends AbstractJsonBuilder {
    PokeType pokeType;

    public PokeTypeBuilder(PokeType pokeType) {
        this.pokeType = pokeType;
    }

    private String pokeTypeAsJsonString() {
        return surroundWithQuoteStrings(pokeType.toString());
    }
    public JsonNode pokeTypeAsJsonNode() {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node;
        try {
            node = mapper.readTree(pokeTypeAsJsonString());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return node;
    }

}
