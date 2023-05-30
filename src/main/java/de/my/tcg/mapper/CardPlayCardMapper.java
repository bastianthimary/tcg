package de.my.tcg.mapper;

import de.my.tcg.basedata.card.Card;
import de.my.tcg.game.domain.PlayCard;
import org.mapstruct.Mapper;

@Mapper
public interface CardPlayCardMapper {
    PlayCard cardToPlayCard(Card card);

    Card playCardToCard(PlayCard card);
}
