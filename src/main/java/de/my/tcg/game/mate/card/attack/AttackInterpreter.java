package de.my.tcg.game.mate.card.attack;

import de.my.tcg.basedata.Attack;
import de.my.tcg.game.mate.FieldSide;
import de.my.tcg.game.mate.card.MonIsDefeatedException;
import de.my.tcg.game.mate.card.textparser.interpreter.AdditionalDmgAttackEffectInterpreterAndPerformer;
import de.my.tcg.game.mate.card.textparser.interpreter.AttackEffectInterpreterAndPerformer;

public class AttackInterpreter {
    private final Attack attack;
    private final FieldSide yourSide;
    private final FieldSide opponentSide;


    public AttackInterpreter(Attack attack, FieldSide yourSide, FieldSide opponentSide) {
        this.attack = attack;
        this.yourSide = yourSide;
        this.opponentSide = opponentSide;
    }

    public void performAttack() throws MonIsDefeatedException {
        String attackText = attack.getText();
        if (attackText.isBlank()) {
            int dmg = Integer.parseInt(attack.getDamage());
            opponentSide.getActiveMon().doSimpleDmg(dmg);
        } else {
            String dmgAsString = attack.getDamage();
            if (dmgAsString.contains("/+")) {
                AdditionalDmgAttackEffectInterpreterAndPerformer additionalDmgAttackEffectInterpreterAndPerformer = new AdditionalDmgAttackEffectInterpreterAndPerformer(attack, yourSide, opponentSide);
                additionalDmgAttackEffectInterpreterAndPerformer.interpretAndPerformAttack();
            } else {
                AttackEffectInterpreterAndPerformer dmgInterpreter = new AttackEffectInterpreterAndPerformer(attack, yourSide, opponentSide);
                dmgInterpreter.interpretAndPerformAttack();
            }
        }
    }
}
