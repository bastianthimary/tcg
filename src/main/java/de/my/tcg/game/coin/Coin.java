package de.my.tcg.game.coin;

public class Coin {

    public static CoinSide flip(){
        if(Math.random()<0.5){
            return CoinSide.HEAD;
        }
        return CoinSide.TAILS;
    }

}
