package de.my.tcg.domain.card;

import de.my.tcg.domain.CardTypes;
import de.my.tcg.domain.cardset.CardSet;
import de.my.tcg.domain.cardset.CardSetService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    private final CardRepository cardRepository;

    private final CardSetService cardSetService;

    @Autowired
    EntityManager entityManager;


    @Autowired
    public CardService(CardRepository cardRepository, CardSetService cardSetService) {
        this.cardRepository = cardRepository;
        this.cardSetService = cardSetService;

    }

    public void addCard(Card card) {
        fillWithPersistedValues(card);
        cardRepository.saveAndFlush(card);

    }

    private void fillWithPersistedValues(Card card) {
        fillWithPersistedCardSet(card);
    }

    private void fillWithPersistedCardSet(Card card) {
        CardSet cardSet = card.getSet();
        Optional<CardSet> cardSetFromDb = cardSetService.getByShortname(cardSet);
        cardSetFromDb.ifPresent(card::setSet);
    }

    public boolean existsByShortDescrption(Card card){
        Example<Card> cardExample= Example.of(card, ExampleMatcher.matchingAny());
        return  cardRepository.exists(cardExample);
    }
    public List<Card> getAllCardsFromSet(Integer cardSetId){
        return cardRepository.findByCardSet_Id(cardSetId);
    }

    public List<Card> getAllTrainerCards() {
        final Query query = entityManager.createQuery("select c from Card as c where c.supertype= :cardType");
        query.setParameter("cardType", CardTypes.TRAINER);
        return query.getResultList();

    }
}


