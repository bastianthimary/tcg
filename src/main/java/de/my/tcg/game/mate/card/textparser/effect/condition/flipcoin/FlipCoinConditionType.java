package de.my.tcg.game.mate.card.textparser.effect.condition.flipcoin;

import de.my.tcg.game.coin.CoinSide;
import de.my.tcg.game.mate.card.textparser.effect.condition.ConditionType;
import lombok.Getter;

public class FlipCoinConditionType implements ConditionType {
    @Getter
    private CoinSide coinSide;
    @Getter
    private int numberOfFlips = 1;

    public FlipCoinConditionType(CoinSide coinSide) {
        new FlipCoinConditionType(coinSide, 1);
    }

    public FlipCoinConditionType(CoinSide coinSide, int numberOfFlips) {
        this.coinSide = coinSide;
        this.numberOfFlips = numberOfFlips;
    }
}
