package de.my.tcg.game.coin;

public class Coin {

    public static final double Half = 0.5;

    public static CoinSide flip() {
        if (Math.random() < Half) {
            return CoinSide.HEAD;
        }
        return CoinSide.TAILS;
    }

}
