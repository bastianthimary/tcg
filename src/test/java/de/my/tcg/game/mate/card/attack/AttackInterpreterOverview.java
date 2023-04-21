package de.my.tcg.game.mate.card.attack;

import de.my.tcg.TestCardFactory;
import de.my.tcg.basedata.Attack;
import de.my.tcg.game.TestFieldSideFactory;
import de.my.tcg.game.mate.EnergyTotal;
import de.my.tcg.game.mate.FieldSide;
import de.my.tcg.game.mate.card.PokemonCard;
import de.my.tcg.game.mate.card.textparser.AttackEffectInterpreterAndPerformer;
import de.my.tcg.game.mate.card.textparser.effect.effect.BasicEffectTerm;
import de.my.tcg.game.mate.card.textparser.effect.effect.executed.EffectTerm;
import de.my.tcg.game.mate.card.textparser.effect.effect.executed.dmgeffect.DmgEffectTerm;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.fail;

public class AttackInterpreterOverview {
    //  @ParameterizedTest
    @CsvFileSource(resources = "/card/attack/attackinterpreter/overview.csv", delimiter = ';')
    public void overview(String pokemonname, int id, String attackname, String text) {
        if (text != null) {
            FieldSide myFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon(pokemonname);
            FieldSide opponentFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon("opponent");
            Attack attack = new Attack();
            attack.setText(text);
            attack.setDamage("20");
            AttackEffectInterpreterAndPerformer dmgInterpreter = new AttackEffectInterpreterAndPerformer(attack, myFieldSide, opponentFieldSide);
            String energyCardsAsString = "[Fire;Fire;Fire;Fire;Fire]";
            PokemonCard attackingPokemon = myFieldSide.getActiveMon();
            EnergyTotal energyTotal = attackingPokemon.getEnergyTotal();
            TestCardFactory.convertStringToEnergyCardList(energyCardsAsString).
                    forEach(energyTotal::addEnergyCard);
            dmgInterpreter.interpretAndPerformAttack();
            if (dmgInterpreter.getTerms().stream().filter(t -> testTermIsValid(t.getEffectTerm())
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
