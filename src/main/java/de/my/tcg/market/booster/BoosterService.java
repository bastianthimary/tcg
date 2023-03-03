package de.my.tcg.market.booster;

import de.my.tcg.domain.card.Card;
import de.my.tcg.domain.cardset.CardSet;
import de.my.tcg.domain.cardset.CardSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class BoosterService {
    private final CardSetService cardSetService;


    @Autowired
    public BoosterService(CardSetService cardSetService) {
        this.cardSetService = cardSetService;
    }

    public Set<Card> getAllCardsFromSet(String setName) {
        Optional<CardSet> cardSetOptional = cardSetService.getBySetName(setName);
        if (cardSetOptional.isEmpty()) {
            return new HashSet<>();
        }
        return cardSetOptional.get().getCardsInSet();
    }


}
