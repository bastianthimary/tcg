package de.my.tcg.market.booster;

import de.my.tcg.basedata.card.Card;
import de.my.tcg.basedata.card.CardService;
import de.my.tcg.basedata.cardset.CardSet;
import de.my.tcg.basedata.cardset.CardSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200/")
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
    public Set<Card> openBooster(@PathVariable("setid") long id) {
        Optional<CardSet> cardSetOptional = cardSetService.findById(id);
        if (cardSetOptional.isEmpty()) {
            return null;
        }
        CardSet cardSet = cardSetOptional.get();
        List<Card> cardsFromSet= cardService.getAllCardsFromSet(cardSet.getId());
        BoosterFillEngine boosterEngine = new BoosterFillEngine(cardsFromSet, cardSet.getName());
       Booster booster=boosterEngine.fillABooster();
    //   booster.getCards().forEach(c->c.getImages().setLarge_img(new byte[]{1}));
        return booster.getCards();
    }

}
