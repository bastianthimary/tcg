package de.my.tcg.game.mate.card.textparser.effect.condition;

public abstract class ConditionTerm {
 protected ConditionType conditionType;
 protected Condition condition;

 public abstract int compliedTimes();

 public abstract void setupConditionType(String conditionTypeAsString);

 public abstract void setupCondition(String conditionAsString);
}
