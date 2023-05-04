package de.my.tcg.game.mate.card.textparser.interpreter;

import de.my.tcg.game.mate.card.textparser.effect.CardEffect;

import java.util.List;

public interface Performer {
    List<CardEffect> getTerms();
}
