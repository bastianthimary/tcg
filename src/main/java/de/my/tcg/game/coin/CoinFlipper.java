package de.my.tcg.game.coin;

import de.my.tcg.game.mate.card.textparser.effect.condition.condition.Condition;
import lombok.Getter;

public class CoinFlipper implements Condition {
    @Getter
    private int headCounter;
    @Getter
    private int flipCounter;
    @Getter
    private int tailCounter;

    public void flipCoinMultiplyTimes(int times) {
        for (int i = 0; i < times; i++) {
            flipCounter++;
            CoinSide side = Coin.flip();
            if (CoinSide.HEAD.equals(side)) {
                headCounter++;
            } else {
                tailCounter++;
            }
        }
    }

}
