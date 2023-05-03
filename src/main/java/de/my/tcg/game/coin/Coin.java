package de.my.tcg.game.coin;

public class Coin {
    private Coin() {
    }

    public static final double Half = 0.5;
    public static int headcount;
    public static int flipcount;

    public static CoinSide flip() {
        flipcount++;
        if (Math.random() < Half) {
            headcount++;
            return CoinSide.HEAD;
        }
        return CoinSide.TAILS;
    }

}
