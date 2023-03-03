package de.my.tcg.market.booster;

import de.my.tcg.domain.card.Card;
import de.my.tcg.domain.card.CardService;
import de.my.tcg.domain.cardset.CardSet;
import de.my.tcg.domain.cardset.CardSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/booster")
public class BoosterController {
    private final CardSetService cardSetService;
    private final CardService cardService;

    @Autowired
    public BoosterController(CardSetService cardSetService, CardService cardService) {
        this.cardSetService = cardSetService;
        this.cardService = cardService;
    }

    @GetMapping("/open/{setid}")
    public Booster openBooster(@PathVariable("setid") long id) {
        Optional<CardSet> cardSetOptional = cardSetService.findById(id);
        if (cardSetOptional.isEmpty()) {
            return null;
        }
        CardSet cardSet = cardSetOptional.get();
        List<Card> cardsFromSet= cardService.getAllCardsFromSet(cardSet.getId());
        BoosterFillEngine boosterEngine = new BoosterFillEngine(cardsFromSet, cardSet.getName());
        return boosterEngine.fillABooster();
    }

}
