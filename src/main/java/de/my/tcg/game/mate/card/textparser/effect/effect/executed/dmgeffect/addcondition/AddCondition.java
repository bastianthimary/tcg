package de.my.tcg.game.mate.card.textparser.effect.effect.executed.dmgeffect.addcondition;

public interface AddCondition {
    int determineAdditionTimes();

    void addLimitation(Limitation limitation);
}
