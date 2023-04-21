package de.my.tcg.game.mate.card.textparser.effect.condition.flipcoin;

import de.my.tcg.game.coin.CoinSide;
import de.my.tcg.game.mate.card.textparser.effect.condition.conditiontype.ConditionType;
import lombok.Getter;

public class CoinConditionType implements ConditionType {
    @Getter
    private final CoinSide coinSide;

    public CoinConditionType(CoinSide coinSide) {
        this.coinSide = coinSide;
    }
}
