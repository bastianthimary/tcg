package de.my.tcg.game.mate.card.attack;

import de.my.tcg.basedata.Attack;
import de.my.tcg.game.mate.FieldSide;
import de.my.tcg.game.mate.card.MonIsDefeatedException;
import de.my.tcg.game.mate.card.textparser.interpreter.AdditionalDmgAttackEffectInterpreterAndPerformer;
import de.my.tcg.game.mate.card.textparser.interpreter.AttackEffectInterpreterAndPerformer;
import de.my.tcg.game.mate.card.textparser.interpreter.Performer;
import de.my.tcg.game.mate.card.textparser.utils.CardTextUtil;
import lombok.Getter;

public class AttackInterpreter {
    private final Attack attack;
    private final FieldSide thisFieldSide;
    private final FieldSide opponentSide;
    @Getter
    private Performer performer;


    public AttackInterpreter(Attack attack, FieldSide thisFieldSide, FieldSide opponentSide) {
        this.attack = attack;
        this.thisFieldSide = thisFieldSide;
        this.opponentSide = opponentSide;
    }

    public void performAttack() throws MonIsDefeatedException {
        String attackText = attack.getText();
        if (attackText.isBlank()) {
            int dmg = Integer.parseInt(attack.getDamage());
            opponentSide.getActiveMon().doDmgAccordingToType(dmg, thisFieldSide.getActiveMon().getMyPokeType());
        } else {
            String dmgAsString = attack.getDamage();
            if (dmgAsString.contains(CardTextUtil.PLUS_SYMBOL)) {
                AdditionalDmgAttackEffectInterpreterAndPerformer additionalDmgAttackEffectInterpreterAndPerformer = new AdditionalDmgAttackEffectInterpreterAndPerformer(attack, thisFieldSide, opponentSide);
                additionalDmgAttackEffectInterpreterAndPerformer.interpretAndPerformAttack();
                performer = additionalDmgAttackEffectInterpreterAndPerformer;
            } else {
                AttackEffectInterpreterAndPerformer dmgInterpreter = new AttackEffectInterpreterAndPerformer(attack, thisFieldSide, opponentSide);
                dmgInterpreter.interpretAndPerformAttack();
                performer = dmgInterpreter;
            }
        }
    }
}
