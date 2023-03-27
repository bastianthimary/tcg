package de.my.tcg.game.rules;

import de.my.tcg.collector.TradingDeck;
import de.my.tcg.game.domain.DeckValidator;
import de.my.tcg.game.domain.PlayCard;
import de.my.tcg.game.domain.PlayDeck;
import de.my.tcg.game.rules.exception.ExceptionMessage;
import de.my.tcg.game.rules.exception.GameException;

public class TradingDeckToPlayDeckConverter {
   public static PlayDeck convertTradingToPlayDeck(TradingDeck tradingDeck){
        PlayDeck playDeck = new PlayDeck();
        if(!new DeckValidator(tradingDeck).validate()){
            throw  new GameException(ExceptionMessage.DECK_IS_NOT_VALID);
        }
        tradingDeck.getCards().forEach(tcgCard ->
                playDeck.addCard(new PlayCard(tcgCard.getCard())));
        return playDeck;
    }
}
