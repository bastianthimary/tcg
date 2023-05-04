package de.my.tcg.game.mate.card.textparser.effect.effect.executed.dmgeffect.addcondition.energynotused;

import de.my.tcg.basedata.Attack;
import de.my.tcg.basedata.poketype.PokeType;
import de.my.tcg.game.mate.EnergyTotal;
import de.my.tcg.game.mate.card.EnergyCard;
import de.my.tcg.game.mate.card.PokemonCard;
import de.my.tcg.game.mate.card.textparser.effect.condition.ConditionTerm;
import de.my.tcg.game.mate.card.textparser.effect.effect.executed.dmgeffect.addcondition.AddCondition;
import de.my.tcg.game.mate.card.textparser.effect.effect.executed.dmgeffect.addcondition.Limitation;
import lombok.Setter;

import java.util.List;

public class AddByEnergyNotUsed extends ConditionTerm implements AddCondition {
    private final Attack usedAttack;
    private final PokeType energyType;
    @Setter
    private PokemonCard targedPokemon;
    private Limitation limitation;

    public AddByEnergyNotUsed(Attack usedAttack, PokeType energyType) {
        this.usedAttack = usedAttack;
        this.energyType = energyType;
    }

    @Override
    public int determineAdditionTimes() {
        int numberOfEnergyCosts = usedAttack.getConvertedEnergyCost();
        int energyNotUsed = getTotalEnergysOfType() - numberOfEnergyCosts;
        if (limitIsReached(energyNotUsed)) {
            return limitation.getLimitTimes();
        }
        return energyNotUsed;
    }

    private boolean limitIsReached(int energyNotUsed) {
        return limitation != null && limitation.getLimitTimes() < energyNotUsed;
    }

    private int getTotalEnergysOfType() {
        EnergyTotal energyTotal = targedPokemon.getEnergyTotal();
        List<EnergyCard> allEnergy = energyTotal.getANumberOfCardOfType(EnergyTotal.ALL_CARDS, energyType);
        return allEnergy.size();

    }

    @Override
    public void addLimitation(Limitation limitation) {
        this.limitation = limitation;
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
}
