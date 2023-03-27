package de.my.tcg.dataimport;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import de.my.tcg.dataimport.json.JSONCardMapper;
import de.my.tcg.basedata.*;
import de.my.tcg.basedata.card.Card;
import de.my.tcg.basedata.cost.Cost;
import de.my.tcg.dataimport.json.builder.CostBuilder;
import de.my.tcg.basedata.poketype.PokeType;
import de.my.tcg.basedata.rarity.Rarity;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JSONCardMapperTest {


    @Test
    public void jsonToCardMapper() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\"id\":\"gym2-2\",\"name\":\"Blaine's Charizard\",\"supertype\":\"Pokémon\",\"subtypes\":[\"Stage 2\"],\"level\":\"50\",\"hp\":\"100\",\"types\":[\"Fire\"],\"evolvesFrom\":\"Blaine's Charmeleon\"," +
                "\"attacks\":[{\"name\":\"Roaring Flames\",\"cost\":[\"Fire\"],\"convertedEnergyCost\":1,\"damage\":\"20+\"," +
                "\"text\":\"Discard all Fire Energy cards attached to Blaine's Charizard. If all Energy cards attached to Blaine's Charizard provide 2 Fire Energy, discard all of them. This attack does 20 damage plus 20 more damage for each Fire Energy discarded in this way.\"}," +
                "{\"name\":\"Flame Jet\",\"cost\":[\"Fire\",\"Fire\"],\"convertedEnergyCost\":2,\"damage\":\"\"," +
                "\"text\":\"Flip a coin. If heads, choose 1 of your opponent's Pokémon. This attack does 40 damage to that Pokémon. Don't apply Weakness and Resistance for this attack. (Any other effects that would happen after applying Weakness and Resistance still happen.)\"}]," +
                "\"weaknesses\":[{\"type\":\"Water\",\"value\":\"×2\"}],\"resistances\":[{\"type\":\"Fighting\",\"value\":\"-30\"}],\"retreatCost\":[\"Colorless\",\"Colorless\",\"Colorless\"],\"convertedRetreatCost\":3," +
                "\"set\":{\"id\":\"gym2\",\"name\":\"Gym Challenge\",\"series\":\"Gym\",\"printedTotal\":132,\"total\":132,\"legalities\":{\"unlimited\":\"Legal\"},\"ptcgoCode\":\"G2\",\"releaseDate\":\"2000/10/16\",\"updatedAt\":\"2022/10/10 15:12:00\"," +
                "\"images\":{\"symbol\":\"https://images.pokemontcg.io/gym2/symbol.png\",\"logo\":\"https://images.pokemontcg.io/gym2/logo.png\"}},\"number\":\"2\",\"artist\":\"Ken Sugimori\",\"rarity\":\"Rare Holo\",\"nationalPokedexNumbers\":[6]," +
                "\"legalities\":{\"unlimited\":\"Legal\"},\"images\":{\"small\":\"https://images.pokemontcg.io/gym2/2.png\",\"large\":\"https://images.pokemontcg.io/gym2/2_hires.png\"}," +
                "\"tcgplayer\":{\"url\":\"https://prices.pokemontcg.io/tcgplayer/gym2-2\",\"updatedAt\":\"2023/02/12\",\"prices\":{\"1stEditionHolofoil\":{\"low\":699.99,\"mid\":790.0,\"high\":1200.0,\"market\":800.99},\n" +
                "\"unlimitedHolofoil\":{\"low\":183.25,\"mid\":199.95,\"high\":265.0,\"market\":241.12}}}," +
                "\"cardmarket\":{\"url\":\"https://prices.pokemontcg.io/cardmarket/gym2-2\",\"updatedAt\":\"2023/02/12\",\"prices\":{\"averageSellPrice\":189.42,\"lowPrice\":39.9,\"trendPrice\":180.31,\"reverseHoloTrend\":159.26,\"lowPriceExPlus\":84.0," +
                "\"avg1\":179.45,\"avg7\":205.25,\"avg30\":164.47,\"reverseHoloAvg1\":130.0,\"reverseHoloAvg7\":120.47,\"reverseHoloAvg30\":130.94}}}";
        ObjectNode node = mapper.readValue(json, ObjectNode.class);

        Card card = JSONCardMapper.jsonToDomainMapper(node, Card.class);

        assertThat(card.getName()).isEqualTo("Blaine's Charizard");
        assertThat(card.getHp()).isEqualTo("100");
        assertThat(card.getRarity()).isEqualTo(Rarity.RARE_HOLO);
        assertThat(card.getResistances()).isEqualTo(PokeType.Fighting);

    }

    @Test
    public void testCostConvertion() throws JsonProcessingException {
        String costInputString = "Fire";
        CostBuilder costBuilder = new CostBuilder();
        ObjectMapper mapper = new ObjectMapper();
        costBuilder.addCostString(costInputString);
        String costNodeString = costBuilder.getCostNode().toString().
                replace("[", "").replace("]", "");
        Cost cost = mapper.readValue(costNodeString, Cost.class);
        assertThat(cost.getQuantity()).isEqualTo(1);
        assertThat(cost.getType()).isEqualTo(PokeType.Fire);
    }

    @Test
    public void testAttackConvertion() throws JsonProcessingException {

        String attackInputString = "{\"name\":\"Flame Jet\",\"cost\":[{\"type\":\"Fire\",\"quantity\":2}],\"convertedEnergyCost\":2,\"damage\":\"\"," +
                "\"text\":\"Flip a coin. If heads, choose 1 of your opponent's Pokémon. This attack does 40 damage to that Pokémon. " +
                "Don't apply Weakness and Resistance for this attack. (Any other effects that would happen after applying Weakness and Resistance still happen.)\"}";
        ObjectMapper mapper = new ObjectMapper();
        Attack attack = mapper.readValue(attackInputString, Attack.class);
        assertThat(attack.getConvertedEnergyCost()).isEqualTo(2);
        assertThat(attack.getName()).isEqualTo("Flame Jet");
        assertThat(attack.getCost().size()).isEqualTo(1);

    }

    @Test
    public void TestTrainerCardMapping() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = "{" +
                "            \"id\": \"base1-70\"," +
                "            \"name\": \"Clefairy Doll\"," +
                "            \"supertype\": \"Trainer\"," +
                "            \"hp\": \"10\"," +
                "            \"rules\": [" +
                "                \"This is a Ruletext, which should Saved in Flavor Text\"" +
                "            ]," +
                "            \"set\": {" +
                "                \"id\": \"base1\"," +
                "                \"name\": \"Base\"," +
                "                \"series\": \"Base\"," +
                "                \"printedTotal\": 102," +
                "                \"total\": 102," +
                "                \"legalities\": {" +
                "                    \"unlimited\": \"Legal\"" +
                "                }," +
                "                \"ptcgoCode\": \"BS\"," +
                "                \"releaseDate\": \"1999/01/09\"," +
                "                \"updatedAt\": \"2022/10/10 15:12:00\"," +
                "                \"images\": {" +
                "                    \"symbol\": \"https://images.pokemontcg.io/base1/symbol.png\"," +
                "                    \"logo\": \"https://images.pokemontcg.io/base1/logo.png\"" +
                "                }" +
                "            }," +
                "            \"number\": \"70\"," +
                "            \"artist\": \"Keiji Kinebuchi\"," +
                "            \"rarity\": \"Rare\"," +
                "            \"legalities\": {" +
                "                \"unlimited\": \"Legal\"" +
                "            }," +
                "            \"images\": {" +
                "                \"small\": \"https://images.pokemontcg.io/base1/70.png\"," +
                "                \"large\": \"https://images.pokemontcg.io/base1/70_hires.png\"" +
                "            }," +
                "            \"tcgplayer\": {" +
                "                \"url\": \"https://prices.pokemontcg.io/tcgplayer/base1-70\"," +
                "                \"updatedAt\": \"2023/02/25\"," +
                "                \"prices\": {" +
                "                    \"normal\": {" +
                "                        \"low\": 1.49," +
                "                        \"mid\": 3.25," +
                "                        \"high\": 19.99," +
                "                        \"market\": 4.12," +
                "                        \"directLow\": 1.5" +
                "                    }" +
                "                }" +
                "            }," +
                "            \"cardmarket\": {" +
                "                \"url\": \"https://prices.pokemontcg.io/cardmarket/base1-70\"," +
                "                \"updatedAt\": \"2023/02/25\"," +
                "                \"prices\": {" +
                "                    \"averageSellPrice\": 5.55," +
                "                    \"lowPrice\": 0.25," +
                "                    \"trendPrice\": 5.44," +
                "                    \"reverseHoloTrend\": 0.02," +
                "                    \"lowPriceExPlus\": 2.99," +
                "                    \"avg1\": 5.0," +
                "                    \"avg7\": 4.7," +
                "                    \"avg30\": 5.34," +
                "                    \"reverseHoloAvg1\": 0.88," +
                "                    \"reverseHoloAvg7\": 2.33," +
                "                    \"reverseHoloAvg30\": 2.33" +
                "                }" +
                "            }" +
                "        }";
        ObjectNode node = mapper.readValue(json, ObjectNode.class);

        Card card = JSONCardMapper.jsonToDomainMapper(node, Card.class);

        assertThat(card.getName()).isEqualTo("Clefairy Doll");
        assertThat(card.getHp()).isEqualTo("10");
        assertThat(card.getRarity()).isEqualTo(Rarity.RARE);
        assertThat(card.getFlavorText()).isEqualTo("This is a Ruletext, which should Saved in Flavor Text");
    }

    @Test
    public void TestRarityConvertionMapping() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\"id\":\"cel25-6\",\"name\":\"Flying Pikachu V\",\"supertype\":\"Pokémon\",\"subtypes\":[\"Basic\",\"V\"],\"hp\":\"190\",\"types\":[\"Lightning\"],\"evolvesTo\":[\"Raichu\"],\"rules\":[\"V rule: When your Pokémon V is Knocked Out, your opponent takes 2 Prize cards.\"],\"attacks\":[{\"cost\":[\"Lightning\"],\"name\":\"Thunder Shock\",\"damage\":\"20\",\"text\":\"Flip a coin. If heads, your opponent's Active Pokémon is now Paralyzed.\",\"convertedEnergyCost\":1},{\"cost\":[\"Colorless\",\"Colorless\",\"Colorless\"],\"name\":\"Fly\",\"damage\":\"120\",\"text\":\"Flip a coin. If tails, this attack does nothing. If heads, during your opponent's next turn, prevent all damage from and effects of attacks done to this Pokémon.\",\"convertedEnergyCost\":3}],\"weaknesses\":[{\"type\":\"Lightning\",\"value\":\"×2\"}],\"resistances\":[{\"type\":\"Fighting\",\"value\":\"-30\"}],\"set\":{\"id\":\"cel25\",\"name\":\"Celebrations\",\"series\":\"Sword & Shield\",\"printedTotal\":25,\"total\":25,\"legalities\":{\"unlimited\":\"Legal\",\"standard\":\"Legal\",\"expanded\":\"Legal\"},\"ptcgoCode\":\"CEL\",\"releaseDate\":\"2021/10/08\",\"updatedAt\":\"2022/10/11 21:39:00\",\"images\":{\"symbol\":\"https://images.pokemontcg.io/cel25/symbol.png\",\"logo\":\"https://images.pokemontcg.io/cel25/logo.png\"}},\"number\":\"6\",\"artist\":\"aky CG Works\",\"rarity\":\"V\",\"nationalPokedexNumbers\":[25],\"legalities\":{\"unlimited\":\"Legal\",\"standard\":\"Legal\",\"expanded\":\"Legal\"},\"regulationMark\":\"E\",\"images\":{\"small\":\"https://images.pokemontcg.io/cel25/6.png\",\"large\":\"https://images.pokemontcg.io/cel25/6_hires.png\"},\"tcgplayer\":{\"url\":\"https://prices.pokemontcg.io/tcgplayer/cel25-6\",\"updatedAt\":\"2023/02/25\",\"prices\":{\"holofoil\":{\"low\":0.5,\"mid\":1.2,\"high\":7.24,\"market\":0.91}}},\"cardmarket\":{\"url\":\"https://prices.pokemontcg.io/cardmarket/cel25-6\",\"updatedAt\":\"2023/02/25\",\"prices\":{\"averageSellPrice\":1.0,\"lowPrice\":0.18,\"trendPrice\":0.98,\"reverseHoloTrend\":0.0,\"lowPriceExPlus\":0.4,\"avg1\":1.01,\"avg7\":1.01,\"avg30\":0.99}}}";
        ObjectNode node = mapper.readValue(json, ObjectNode.class);

        Card card = JSONCardMapper.jsonToDomainMapper(node, Card.class);

        assertThat(card.getRarity()).isEqualTo(Rarity.RARE_HOLO_V);
    }
}