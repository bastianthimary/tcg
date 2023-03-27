package de.my.tcg.basedata.images;

import de.my.tcg.basedata.card.Card;
import de.my.tcg.basedata.card.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImagesService {
    private final ImagesRepository imagesRepository;
  private final CardService cardService;


    @Autowired
    public ImagesService(ImagesRepository imagesRepository, CardService cardService) {
        this.imagesRepository = imagesRepository;
        this.cardService = cardService;
    }

    public List<Images> getAllImages() {
        return imagesRepository.findAll();
    }

    public List<Images> getAllNotEmptyImages(int v1, int v2) {
        return imagesRepository.getAllNotEmptyImages(v1, v2);
    }

    public List<Images> getNotEmptyImagesFromTrainerCards() {

        List<Card> trainerCards=cardService.getAllTrainerCards();
        List<Images> images= new ArrayList<>();
        trainerCards.stream().filter(card -> card.getImages().getLarge_img()!=null).forEach( card->images.add(card.getImages()));

        return images;
    }


}
