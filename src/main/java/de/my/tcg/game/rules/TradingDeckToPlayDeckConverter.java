package de.my.tcg.game.rules;

import de.my.tcg.collector.PlayCardToTradingCardMapper;
import de.my.tcg.collector.TradingDeck;
import de.my.tcg.game.domain.DeckValidator;
import de.my.tcg.game.domain.PlayDeck;
import de.my.tcg.game.rules.exception.ExceptionMessage;
import de.my.tcg.game.rules.exception.GameException;
import org.mapstruct.factory.Mappers;

public class TradingDeckToPlayDeckConverter {
    private TradingDeckToPlayDeckConverter() {
    }

    public static PlayDeck convertTradingToPlayDeck(TradingDeck tradingDeck) {
        PlayCardToTradingCardMapper playCardToTradingCardMapper = Mappers.getMapper(PlayCardToTradingCardMapper.class);
        PlayDeck playDeck = new PlayDeck();
        if (!new DeckValidator(tradingDeck).validate()) {
            throw new GameException(ExceptionMessage.DECK_IS_NOT_VALID);
        }
        tradingDeck.getCards().forEach(tradingCard ->
                playDeck.addCard(playCardToTradingCardMapper.tradingCardToPlayCard(tradingCard)));
        return playDeck;
    }
}
