package de.my.tcg.dataimport.json.builder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.my.tcg.basedata.cost.Cost;
import de.my.tcg.basedata.poketype.PokeType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static de.my.tcg.dataimport.json.CardFieldNames.QUANTITY;
import static de.my.tcg.dataimport.json.CardFieldNames.TYPE;

public class CostBuilder extends AbstractJsonBuilder {
    HashMap<PokeType, Integer> costsByType = new HashMap<>();
    Set<Cost> allCosts = new HashSet<>();

    public Set<Cost> getCost() {

        costsByType.keySet().forEach(cot -> allCosts.add(new Cost(cot, costsByType.get(cot))));
        return allCosts;
    }

    public void addCostString(String costString) {
        PokeType type = PokeType.valueOf(costString);
        if (costsByType.containsKey(type)) {
            costsByType.replace(type, costsByType.get(type) + 1);
        } else {
            costsByType.put(type, 1);
        }
    }

    public JsonNode getCostNode() {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node;
        String costAsJsonString=costAsJson();
        try {
            node = mapper.readTree(costAsJsonString);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return node;
    }

    private String costAsJson() {
        Set<Cost> costs = getCost();
        StringBuilder buildString = new StringBuilder("[{");
        for (Iterator<Cost> it = costs.iterator(); it.hasNext(); ) {
            Cost cost = it.next();

            buildString.append(surroundWithQuoteStrings(TYPE)+ ":").append(surroundWithQuoteStrings(cost.getType()+"")).append(",").
                    append(surroundWithQuoteStrings(QUANTITY)).append(":").append(cost.getQuantity());
            if (it.hasNext()) {
                buildString.append("},{");
            }
        }
        buildString.append("}]");

        return buildString.toString();
    }


}
