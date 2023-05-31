package de.my.tcg.mapper;

import de.my.tcg.basedata.card.Card;
import de.my.tcg.basedata.poketype.PokeType;
import de.my.tcg.game.domain.PlayCard;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;

@Mapper
public interface CardPlayCardMapper {
    @Mapping(target = "pokeType", source = "types", qualifiedByName = "mapTypesToPokeType")
    PlayCard cardToPlayCard(Card card);

    Card playCardToCard(PlayCard card);

    @Named("mapTypesToPokeType")
    default PokeType mapTypesToPokeType(Set<String> types) {
        if (types == null || types.isEmpty()) {
            return null;
        }
        return PokeType.valueOf(types.stream().toList().get(0));
    }
}
