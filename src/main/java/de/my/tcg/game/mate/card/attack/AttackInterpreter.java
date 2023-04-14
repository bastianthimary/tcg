package de.my.tcg.game.mate.card.attack;

import de.my.tcg.basedata.Attack;
import de.my.tcg.game.mate.FieldSide;
import de.my.tcg.game.mate.card.textparser.MultiplyDmgInterpreter;

public class AttackInterpreter {
    private Attack performAttack;
    private FieldSide yourSide;
    private FieldSide opponentSide;


    public void interpretAndPerformAttack(Attack performAttack, FieldSide yourSide, FieldSide opponentSide) {
        String dmgAsString = performAttack.getDamage();
        String attackText = performAttack.getText();


    }

    public int stringToActualDmg(String dmgAsString, String attackText) {
        if (dmgAsString.isBlank()) {
            return 0;
        }
        if (dmgAsString.contains("/+")) {
            return interpretPlusDmg(dmgAsString, attackText);
        } else if (dmgAsString.contains("×")) {
            return interpretMuliplyDmg(dmgAsString, attackText);
        }
        return Integer.parseInt(dmgAsString);
    }

    private int interpretMuliplyDmg(String dmgAsString, String attackText) {
        MultiplyDmgInterpreter dmgInterpreter = new MultiplyDmgInterpreter();
        return dmgInterpreter.parse(attackText);
    }

    private int interpretPlusDmg(String dmgAsString, String attackText) {

        return 0;
    }
}
