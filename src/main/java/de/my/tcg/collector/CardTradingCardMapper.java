package de.my.tcg.collector;

import de.my.tcg.basedata.card.Card;
import de.my.tcg.basedata.poketype.PokeType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;

@Mapper
public interface CardTradingCardMapper {

    @Mapping(target = "type", source = "types", qualifiedByName = "mapTypesToType")
    TradingCard cardToTradingCard(Card card);

    Card tradingCardToCard(TradingCard card);

    @Named("mapTypesToType")
    default PokeType mapTypesToType(Set<String> types) {
        if (types == null || types.isEmpty()) {
            return null;
        }
        return PokeType.valueOf(types.stream().toList().get(0));
    }
}
