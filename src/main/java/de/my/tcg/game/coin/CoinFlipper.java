package de.my.tcg.game.coin;

import lombok.Getter;

public class CoinFlipper {
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
