package de.my.tcg.game.mate.card.textparser.effect.effect.executed.bench;

import de.my.tcg.game.mate.card.PokemonCard;
import de.my.tcg.game.mate.card.textparser.effect.effect.executed.ExecutedEffect;

public class BenchDmgExecutedEffect implements ExecutedEffect {
    private final int dmg;

    public BenchDmgExecutedEffect(int dmg) {
        this.dmg = dmg;
    }

    @Override
    public void executeEffect(PokemonCard thisPokemonCard) {
        thisPokemonCard.doSimpleDmg(dmg);
    }
}
