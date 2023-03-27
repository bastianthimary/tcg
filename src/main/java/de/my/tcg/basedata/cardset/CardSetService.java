package de.my.tcg.basedata.cardset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardSetService {
    private final CardSetRepository cardSetRepository;

    @Autowired
    public CardSetService(CardSetRepository cardSetRepository) {
        this.cardSetRepository = cardSetRepository;
    }
    public void addCardSet(CardSet cardSet) {
        cardSetRepository.saveAndFlush(cardSet);
    }

    public Optional<CardSet> findById(long id){
        return cardSetRepository.findById(id);
    }
    public Optional<CardSet> getByShortname(CardSet cardSet) {
        return cardSetRepository.findByShortname(cardSet.getShortname());
    }

    public List<CardSet> getAllCardSets(){
        return cardSetRepository.findAll();
    }

    public Optional<CardSet> getBySetName(String setName){
        return cardSetRepository.getByName(setName);
    }




}
