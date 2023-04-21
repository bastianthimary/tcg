package de.my.tcg.game.mate.card.textparser.effect.condition.condition;

import de.my.tcg.game.coin.CoinFlipper;
import de.my.tcg.game.coin.CoinSide;
import de.my.tcg.game.mate.card.textparser.effect.condition.ConditionTerm;
import de.my.tcg.game.mate.card.textparser.effect.condition.flipcoin.CoinConditionType;
import de.my.tcg.game.mate.card.textparser.utils.NumberParser;

public class FlipCoinTerm extends ConditionTerm {

    private static final String HEADS = "heads";
    private static final String TAILS = "tails";

    @Override
    public int compliedTimes() {
        return switch (((CoinConditionType) conditionType).getCoinSide()) {
            case HEAD -> ((CoinFlipper) condition).getHeadCounter();
            case TAILS -> ((CoinFlipper) condition).getTailCounter();
        };
    }

    @Override
    public void setupConditionType(String conditionTypeAsString) {
        CoinSide coinSide;
        if (HEADS.equals(conditionTypeAsString)) {
            coinSide = CoinSide.HEAD;
        } else {
            coinSide = CoinSide.TAILS;
        }
        conditionType = new CoinConditionType(coinSide);
    }

    @Override
    public void setupCondition(String conditionAsString) {
        int coinFlips = NumberParser.parseNumberOrStringToInteger(conditionAsString);
        condition = new CoinFlipper();
        ((CoinFlipper) condition).flipCoinMultiplyTimes(coinFlips);
    }
}
