package de.my.tcg.game.mate.card.textparser.effect.condition;

import de.my.tcg.game.mate.card.textparser.effect.condition.condition.Condition;
import de.my.tcg.game.mate.card.textparser.effect.condition.conditiontype.ConditionType;

public abstract class ConditionTerm {
    protected ConditionType conditionType;
    protected Condition condition;

    public abstract int compliedTimes();

    public abstract void setupConditionType(String conditionTypeAsString);

    public abstract void setupCondition(String conditionAsString);
}
