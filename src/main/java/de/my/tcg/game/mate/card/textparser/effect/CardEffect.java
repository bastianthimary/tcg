package de.my.tcg.game.mate.card.textparser.effect;

import de.my.tcg.game.mate.card.textparser.Term;
import de.my.tcg.game.mate.card.textparser.effect.condition.ConditionTerm;
import de.my.tcg.game.mate.card.textparser.effect.effect.executed.EffectTerm;
import lombok.Getter;
import lombok.Setter;

public class CardEffect extends Term {
    @Getter
    @Setter
    private ConditionTerm effectCondition;
    @Getter
    @Setter
    private EffectTerm effectTerm;

    public CardEffect(String termText) {
        super(termText);
    }

    public void runEffect() {
        if (effectCondition != null) {
            effectTerm.runEffect(effectCondition.compliedTimes());
        } else {
            effectTerm.runEffect(1);
        }

    }
}
