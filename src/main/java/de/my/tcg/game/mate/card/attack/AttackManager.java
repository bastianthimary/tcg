package de.my.tcg.game.mate.card.attack;

import de.my.tcg.basedata.Attack;
import de.my.tcg.game.domain.Player;
import de.my.tcg.game.mate.FieldSide;
import de.my.tcg.game.mate.card.MonIsDefeatedException;
import de.my.tcg.game.mate.card.NoLegalActionException;
import de.my.tcg.game.mate.card.PokemonCard;
import lombok.Setter;

public class AttackManager {
    private FieldSide playMate;
    @Setter
    private Player opponent;
    private PokemonCard activeMon;

    public AttackManager(FieldSide playMate) {
        this.playMate = playMate;
        activeMon = playMate.getActiveMon();
    }

    public void performAttack(Attack performAttack) throws NoLegalActionException, MonIsDefeatedException {

        AttackChecker.checkPerformablility(activeMon, performAttack);

        new AttackInterpreter().interpretAndPerformAttack(performAttack, playMate, opponent.getPlayMate());

    }
}
