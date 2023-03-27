package de.my.tcg.game.domain;

import de.my.tcg.basedata.CardTypes;
import de.my.tcg.basedata.Subtype;
import de.my.tcg.game.rules.GameValidator;
import de.my.tcg.interfaces.TCGDeck;

import java.util.HashMap;

public class DeckValidator implements GameValidator {
    public static final int DECKSIZE = 60;
    private final TCGDeck playDeck;

    public DeckValidator(TCGDeck playDeck) {
        this.playDeck = playDeck;
    }

    public boolean validate() {
        return checkDecksize() && checkMaxAppeareance() && checkBasicPokemon();
    }

    private boolean checkMaxAppeareance() {
        HashMap<String, Integer> appeareanceMap = new HashMap<>();
        playDeck.getCards().stream().filter(card -> !card.getCard().getSubtypes().contains(CardTypes.ENERGY.getStringValue())).
                forEach(card -> {
                    String name = card.getCard().getName();
                    if (appeareanceMap.containsKey(name)) {
                        Integer count = appeareanceMap.get(name);
                        appeareanceMap.put(name, count++);
                    } else {
                        appeareanceMap.put(name, 1);
                    }
                });
        return appeareanceMap.values().stream().noneMatch(i -> i > 4);
    }

    private boolean checkDecksize() {
        return playDeck.getDecksize() == DECKSIZE;
    }

    private boolean checkBasicPokemon(){
        return playDeck.getCards().stream().anyMatch(card->card.getCard().getSubtypes().contains(Subtype.BASIC));
    }
}
