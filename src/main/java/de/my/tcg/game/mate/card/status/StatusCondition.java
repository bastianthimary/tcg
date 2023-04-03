package de.my.tcg.game.mate.card.status;

import de.my.tcg.game.coin.Coin;
import de.my.tcg.game.coin.CoinSide;
import de.my.tcg.game.mate.card.MonIsDefeatedException;
import de.my.tcg.game.mate.card.PokemonCard;
import lombok.Getter;
import lombok.Setter;

public class StatusCondition {
    private static final int FIRE_DMG = 20;
    private static final int CONFUSE_DMG = 20;
    private final PokemonCard pokemonCard;
    @Getter
    @Setter
    private PoisonCondition poisonConditionState;
    @Getter
    @Setter
    private FireCondition fireConditionState;
    @Getter
    @Setter
    private SpecialCondition specialCondition;


    public StatusCondition(PokemonCard pokemonCard) {
        this.pokemonCard = pokemonCard;
        healAllStates();
    }

    public void healAllStates() {
        poisonConditionState = PoisonCondition.NO_STATUS;
        fireConditionState = FireCondition.NO_STATUS;
        specialCondition = SpecialCondition.NO_STATUS;
    }

    public void turnEnds() throws MonIsDefeatedException {
        doPoisionDmg();
        doFireDmg();
        checkWakeUp();
        checkParalyse();
    }

    private void doPoisionDmg() throws MonIsDefeatedException {
        pokemonCard.doSimpleDmg(poisonConditionState.dmg);
    }

    private void doFireDmg() throws MonIsDefeatedException {
        if (FireCondition.SINGLE.equals(fireConditionState)) {
            pokemonCard.doSimpleDmg(FIRE_DMG);
            if (CoinSide.HEAD.equals(Coin.flip())) {
                fireConditionState = FireCondition.NO_STATUS;
            }
        }

    }

    private void checkWakeUp() {
        if (SpecialCondition.SLEEP.equals(specialCondition)) {
            if (CoinSide.HEAD.equals(Coin.flip())) {
                specialCondition = SpecialCondition.NO_STATUS;
            }
        }
    }

    private void checkParalyse() {
        if (SpecialCondition.PARALYSED.equals(specialCondition)) {
            specialCondition = SpecialCondition.NO_STATUS;
        }
    }

    public boolean statusAllowsAttack() throws MonIsDefeatedException {
        if (SpecialCondition.PARALYSED.equals(specialCondition) || SpecialCondition.SLEEP.equals(specialCondition)) {
            return false;
        } else if (SpecialCondition.CONFUSED.equals(specialCondition)) {
            if(CoinSide.HEAD.equals(Coin.flip())){
                return true;
            }
            pokemonCard.doSimpleDmg(CONFUSE_DMG);
            return false;
        }
        return true;
    }

    public boolean statusAllowsRetreat() {
        return !SpecialCondition.PARALYSED.equals(specialCondition) && !SpecialCondition.SLEEP.equals(specialCondition);
    }

}
