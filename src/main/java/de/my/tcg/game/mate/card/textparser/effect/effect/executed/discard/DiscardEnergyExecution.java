package de.my.tcg.game.mate.card.textparser.effect.effect.executed.discard;

import de.my.tcg.basedata.poketype.PokeType;
import de.my.tcg.game.mate.FieldSide;
import de.my.tcg.game.mate.card.EnergyCard;
import de.my.tcg.game.mate.card.FieldUtils;
import de.my.tcg.game.mate.card.PokemonCard;
import de.my.tcg.game.mate.card.textparser.effect.effect.executed.ExecutedEffect;

import java.util.List;

public class DiscardEnergyExecution implements ExecutedEffect {
    private final PokeType typeOfDiscardion;
    private final int numberOfCards;
    private final FieldSide fieldSide;

    public DiscardEnergyExecution(PokeType typeOfDiscardion, int numberOfCards, FieldSide fieldSide) {
        this.typeOfDiscardion = typeOfDiscardion;
        this.numberOfCards = numberOfCards;
        this.fieldSide = fieldSide;
    }

    @Override
    public void executeEffect(PokemonCard thisPokemonCard) {
        List<EnergyCard> energyCardList = thisPokemonCard.getEnergyTotal().getANumberOfCardOfType(numberOfCards, typeOfDiscardion);
        FieldUtils.discardEnergyFromPokemon(energyCardList, thisPokemonCard, fieldSide);
    }
}