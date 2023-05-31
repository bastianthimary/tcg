package de.my.tcg.collector;

import de.my.tcg.game.domain.PlayCard;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PlayCardToTradingCardMapper {

    TradingCard playCardToTradingCard(PlayCard playCard);

    PlayCard tradingCardToPlayCard(TradingCard tradingCard);

    List<TradingCard> playCardsToTradingCards(List<PlayCard> playCards);

    List<PlayCard> tradingCardsToPlayCards(List<TradingCard> tradingCards);

}
