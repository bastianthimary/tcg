package de.my.tcg.game.mate.card.textparser.effect.effect.executed.dmgeffect.addcondition.dmgcounter;

import de.my.tcg.game.mate.card.PokemonCard;
import de.my.tcg.game.mate.card.textparser.effect.condition.ConditionTerm;
import de.my.tcg.game.mate.card.textparser.effect.effect.executed.dmgeffect.addcondition.AddCondition;
import de.my.tcg.game.mate.card.textparser.effect.effect.executed.dmgeffect.addcondition.Limitation;

public class AddByDmgCounter extends ConditionTerm implements AddCondition {

    private PokemonCard targedPokemon;

    public AddByDmgCounter(PokemonCard targedPokemon) {
        this.targedPokemon = targedPokemon;
    }

    @Override
    public int compliedTimes() {
        return determineAdditionTimes();
    }

    @Override
    public void setupConditionType(String conditionTypeAsString) {
        // Not Needed by Add-Conditions
    }

    @Override
    public void setupCondition(String conditionAsString) {
        // Not Needed by Add-Conditions
    }

    @Override
    public int determineAdditionTimes() {
        return targedPokemon.getDmgCounter() / 10;
    }

    @Override
    public void addLimitation(Limitation limitation) {
        // Not Needed by Add-Conditions
    }
}
