package de.my.tcg.game.mate.card.attack;

import de.my.tcg.basedata.Attack;
import de.my.tcg.game.mate.card.MonIsDefeatedException;
import de.my.tcg.game.mate.card.NoLegalActionException;
import de.my.tcg.game.mate.card.PokemonCard;

import static de.my.tcg.game.mate.card.NoLegalActionException.*;

public class AttackChecker {
    private AttackChecker() {
    }

    public static void checkPerformablility(PokemonCard activeMon, Attack performAttack) throws NoLegalActionException, MonIsDefeatedException {
        if (!activeMon.getAttacks().contains(performAttack)) {
            throw new NoLegalActionException(POKEMON_DO_NOT_KNOW_ATTACK);
        } else if (!activeMon.getEnergyTotal().couldAttackBeUsed(performAttack)) {
            throw new NoLegalActionException(POKEMON_HAVE_TO_LOW_ENERGY_FOR_ATTACK);
        } else if (activeMon.getPokemonStatusCondition().statusAllowsAttack()) {
            throw new NoLegalActionException(POKEMON_CAN_NOT_ATTACK_DUE_TO_STATUS_CONDITION);
        }
    }
}
