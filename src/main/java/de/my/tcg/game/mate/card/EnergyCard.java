package de.my.tcg.game.mate.card;

import de.my.tcg.basedata.CardTypes;
import de.my.tcg.basedata.poketype.PokeType;
import de.my.tcg.game.domain.PlayCard;
import lombok.Getter;

public class EnergyCard extends FieldCard {
    @Getter
    private PokeType pokeType;

    public EnergyCard(PlayCard playCard) {
        if (!CardTypes.ENERGY.equals(playCard.getCard().getSupertype())) {
            throw new IllegalArgumentException();
        }
        currentCard = playCard;
        pokeType = getTypeFromName(currentCard.getCard().getName());
    }

    private PokeType getTypeFromName(String name) {
        return PokeType.valueOf(name.replace("Energy", "").replace("Double", "").trim());
    }
}
