package de.my.tcg.basedata.rarity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import de.my.tcg.dataimport.json.builder.AbstractJsonBuilder;

import java.util.HashMap;
import java.util.Map;

import static de.my.tcg.dataimport.json.CardFieldNames.RARITY;

public class RarityCorrector extends AbstractJsonBuilder {
    final Map<String, Rarity> wrongCandidates;

    public RarityCorrector() {
        wrongCandidates = new HashMap<>();
        fillMapWithCandidates();
    }

    private void fillMapWithCandidates() {
        wrongCandidates.put("\"V\"", Rarity.RARE_HOLO_V);
        wrongCandidates.put("\"VM\"", Rarity.RARE_HOLO_VMAX);
        wrongCandidates.put("\"Classic Collection\"", Rarity.RARE_HOLO);
        wrongCandidates.put("\"Radiant Rare\"", Rarity.RARE_SHINIY);

    }

    public void checkAndCorrectFalseNodes(ObjectNode node) {
        JsonNode rarenode = node.get(RARITY);

        if (rarenode != null && wrongCandidates.containsKey(rarenode.toString())) {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode correctnode;
            try {
                correctnode = mapper.readTree(surroundWithQuoteStrings(wrongCandidates.get(rarenode.toString()).getStringValue()));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            node.replace(RARITY, correctnode);
        }
    }
}
