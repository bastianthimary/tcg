package de.my.tcg.dataimport.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import de.my.tcg.dataimport.json.builder.CostBuilder;
import de.my.tcg.dataimport.json.builder.PokeTypeBuilder;
import de.my.tcg.dataimport.json.builder.TrainerRuleToFlavorBuilder;
import de.my.tcg.domain.CardTypes;
import de.my.tcg.domain.poketype.PokeType;
import de.my.tcg.domain.cardset.CardSet;
import de.my.tcg.domain.rarity.RarityCorrector;

import static de.my.tcg.dataimport.json.CardFieldNames.*;

public class JSONCardMapper {

    public static <T> T jsonToDomainMapper(ObjectNode node, Class<T> classname) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            convertAttackToCardFormat(node);
            convertTrainerCards(node);
            convertCardSetToCardFormat(node, classname);
            convertPokeTypeToCardFormat(node, RESISTANCES);
            convertPokeTypeToCardFormat(node, WEAKNESS);
            convertRarity(node);
            removeNotUsedNodes(node);
            return mapper.readValue(node.toString(), classname);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    private static void convertRarity(ObjectNode node) {
        new RarityCorrector().checkAndCorrectFalseNodes(node);
    }


    private static void convertAttackToCardFormat(ObjectNode node) {
        JsonNode attacks = node.get(ATTACKS);
        if (attacks == null) {
            return;
        }
        for (int i = 0; i < attacks.size(); i++) {
            CostBuilder costBuilder = new CostBuilder();
            JsonNode singleAttack = attacks.get(i);
            convertCostToCardFormat(costBuilder, singleAttack);
        }
    }

    private static void convertCostToCardFormat(CostBuilder costBuilder, JsonNode singleAttack) {
        JsonNode cost = singleAttack.get(COSTS);
        if (cost != null) {
            for (int j = 0; j < cost.size(); j++) {
                costBuilder.addCostString(cost.get(0).asText());
            }
            ((ObjectNode) singleAttack).replace(COSTS, costBuilder.getCostNode());
        }
    }

    private static void convertTrainerCards(ObjectNode node) {
        JsonNode supertype = node.get(SUPERTYPE);
        if (supertype == null || !CardTypes.TRAINER.getStringValue().equals(supertype.asText())) {
            return;
        }

        TrainerRuleToFlavorBuilder trainerBuilder=new TrainerRuleToFlavorBuilder(node.get(RULES));
        node.put(FLAVOR, trainerBuilder.createFlavorNode());
        node.remove(RULES);
    }

    private static <T> void convertCardSetToCardFormat(ObjectNode node, Class<T> classname) {
        ObjectNode cardsetNode;
        if (CardSet.class.equals(classname)) {
            cardsetNode = node;
        } else {
            cardsetNode = (ObjectNode) node.get(CARDSET);
            if (cardsetNode == null) {
                return;
            }
        }
        cardsetNode.remove(LEGALITIES);
        cardsetNode.remove(PTCGO_CODE);
        cardsetNode.remove(UPDATED_AT);
    }


    private static void convertPokeTypeToCardFormat(ObjectNode node, String propertyName) {
        JsonNode resitance = node.get(propertyName);

        if (resitance == null) {
            return;
        }
        JsonNode typeString = resitance.get(0).get(TYPE);
        PokeType pokeType = PokeType.valueOf(typeString.asText());
        PokeTypeBuilder pokeTypeBuilder = new PokeTypeBuilder(pokeType);
        node.replace(propertyName, pokeTypeBuilder.pokeTypeAsJsonNode());
    }

    private static void removeNotUsedNodes(ObjectNode node) {
        node.remove(RETREAT_COST);
        node.remove(LEGALITIES);
        node.remove(NUMBER);
        node.remove(NATIONAL_POKEDEX_NUMBERS);
        node.remove(TCGPLAYER);
        node.remove(CARDMARKET);
    }

}
