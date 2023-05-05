package de.my.tcg.game.mate.card.attack;

import de.my.tcg.TestCardFactory;
import de.my.tcg.basedata.Attack;
import de.my.tcg.game.TestFieldSideFactory;
import de.my.tcg.game.mate.EnergyTotal;
import de.my.tcg.game.mate.FieldSide;
import de.my.tcg.game.mate.card.PokemonCard;
import de.my.tcg.game.mate.card.textparser.effect.effect.BasicEffectTerm;
import de.my.tcg.game.mate.card.textparser.effect.effect.executed.EffectTerm;
import de.my.tcg.game.mate.card.textparser.effect.effect.executed.dmgeffect.DmgEffectTerm;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.fail;

public class AttackInterpreterOverview {

    //select c."name",a.id, a."name",a."text" ,a.damage  from card c join card_attacks ca on c.id =ca.card_id join attack a on ca.attacks_id =a.id
    //where a.id <2404
    // @ParameterizedTest
    @CsvFileSource(resources = "/card/attack/attackinterpreter/overview.csv", numLinesToSkip = 1, delimiter = ';')
    public void overview(String pokemonname, int id, String attackname, String text, String damage) {
        if (text != null) {
            FieldSide myFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon(pokemonname);
            FieldSide opponentFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon("opponent");
            Attack attack = new Attack();
            attack.setText(text);
            attack.setDamage(damage);
            attack.setConvertedEnergyCost(1);
            // AttackEffectInterpreterAndPerformer dmgInterpreter = new AttackEffectInterpreterAndPerformer(attack, myFieldSide, opponentFieldSide);
            AttackInterpreter attackInterpreter = new AttackInterpreter(attack, myFieldSide, opponentFieldSide);

            String energyCardsAsString = "[Fire;Water;Lightning;Psychic;Fighting;Darkness;Fairy;Dragon;Metal]";
            PokemonCard attackingPokemon = myFieldSide.getActiveMon();
            EnergyTotal energyTotal = attackingPokemon.getEnergyTotal();
            TestCardFactory.convertStringToEnergyCardList(energyCardsAsString).
                    forEach(energyTotal::addEnergyCard);
            TestCardFactory.convertStringToEnergyCardList(energyCardsAsString).
                    forEach(energyTotal::addEnergyCard);
            attackInterpreter.performAttack();
            if (!text.isEmpty() && attackInterpreter.getPerformer().getTerms().stream().filter(t -> testTermIsValid(t.getEffectTerm())
            ).toList().size() == 0) {
                fail();
            }
            System.out.println();
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
}
