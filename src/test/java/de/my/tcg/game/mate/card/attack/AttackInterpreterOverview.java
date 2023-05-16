package de.my.tcg.game.mate.card.attack;

import de.my.tcg.TestCardFactory;
import de.my.tcg.basedata.Attack;
import de.my.tcg.game.TestFieldSideFactory;
import de.my.tcg.game.domain.PlayDeck;
import de.my.tcg.game.mate.EnergyTotal;
import de.my.tcg.game.mate.FieldSide;
import de.my.tcg.game.mate.card.PokemonCard;
import de.my.tcg.game.mate.card.textparser.effect.effect.BasicEffectTerm;
import de.my.tcg.game.mate.card.textparser.effect.effect.executed.EffectTerm;
import de.my.tcg.game.mate.card.textparser.effect.effect.executed.dmgeffect.DmgEffectTerm;
import de.my.tcg.game.mate.card.textparser.utils.CardTextUtil;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.fail;

public class AttackInterpreterOverview {

    //select c."name",a.id, a."name",a."text" ,a.damage  from card c join card_attacks ca on c.id =ca.card_id join attack a on ca.attacks_id =a.id
    //where a.id <2404
    // @ParameterizedTest
    @CsvFileSource(resources = "/card/attack/attackinterpreter/overview.csv", numLinesToSkip = 1, delimiter = ';')
    public void overview(String pokemonname, int id, String attackname, String text, String damage) {
        PokemonCard attackingPokemon = null;
        try {
            if (text != null) {
                FieldSide myFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon(pokemonname);
                FieldSide opponentFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon("opponent");
                var player = myFieldSide.getPlayer();
                var playCards = TestCardFactory.createANumberOfTrainerPlayCards(10);
                PlayDeck deck = new PlayDeck();
                playCards.forEach(deck::addCard);
                player.setPlaydeck(deck);
                Attack attack = new Attack();
                attack.setText(text);
                attack.setDamage(damage);
                attack.setConvertedEnergyCost(1);

                // AttackEffectInterpreterAndPerformer dmgInterpreter = new AttackEffectInterpreterAndPerformer(attack, myFieldSide, opponentFieldSide);
                AttackInterpreter attackInterpreter = new AttackInterpreter(attack, myFieldSide, opponentFieldSide);

                String energyCardsAsString = "[Fire;Water;Lightning;Psychic;Fighting;Darkness;Fairy;Dragon;Metal]";
                attackingPokemon = myFieldSide.getActiveMon();
                EnergyTotal energyTotal = attackingPokemon.getEnergyTotal();
                TestCardFactory.convertStringToEnergyCardList(energyCardsAsString).
                        forEach(energyTotal::addEnergyCard);
                TestCardFactory.convertStringToEnergyCardList(energyCardsAsString).
                        forEach(energyTotal::addEnergyCard);
                attackInterpreter.performAttack();
                if (!text.isEmpty() && attackInterpreter.getPerformer().getTerms().stream().filter(t -> testTermIsValid(t.getEffectTerm())
                ).toList().size() == 0) {
                    throw new RuntimeException();
                }

            }
        } catch (Exception e) {
            writeToAnalyseFile(CardTextUtil.normalizeString(text, attackingPokemon));
            fail();
        }
    }

    private void writeToAnalyseFile(String s) {
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter("line.txt", StandardCharsets.UTF_8, true));
            writer.append(' ');
            writer.append(s);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean testTermIsValid(EffectTerm effectTerm) {
        if (effectTerm == null) {
            return false;
        }
        if (effectTerm instanceof BasicEffectTerm) {
            return ((BasicEffectTerm) effectTerm).getExecutedEffect() != null;
        } else return effectTerm instanceof DmgEffectTerm;

    }

    public static void main(String[] args) throws IOException {
        readLineTxt();
    }

    private static void readLineTxt() throws IOException {
        HashMap<String, Integer> map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader("line.txt", StandardCharsets.UTF_8));
        reader.lines().forEach(line -> addToMap(line, map));
        writeToCsv(map);
    }

    private static void addToMap(String line, HashMap<String, Integer> map) {
        if (map.containsKey(line)) {
            Integer replace = map.get(line);
            int newValue = replace + 1;
            map.put(line, newValue);
        } else {
            map.put(line, 1);
        }
    }

    private static void writeToCsv(HashMap<String, Integer> map) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("lines.csv", StandardCharsets.UTF_8));
        map.forEach((k, v) -> {
            try {
                writer.append(k);
                writer.append("|");
                writer.append(Integer.toString(v));
                writer.newLine();
            } catch (IOException e) {

            }
        });
        writer.close();
    }
}
