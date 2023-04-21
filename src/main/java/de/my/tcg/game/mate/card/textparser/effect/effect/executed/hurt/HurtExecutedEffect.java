package de.my.tcg.game.mate.card.textparser.effect.effect.executed.hurt;

import de.my.tcg.game.mate.card.PokemonCard;
import de.my.tcg.game.mate.card.textparser.effect.effect.executed.ExecutedEffect;

public class HurtExecutedEffect implements ExecutedEffect {
    private final int dmg;

    public HurtExecutedEffect(int dmg) {
        this.dmg = dmg;
    }

    @Override
    public void executeEffect(PokemonCard thisPokemonCard) {
        thisPokemonCard.doSimpleDmg(dmg);
    }
}
