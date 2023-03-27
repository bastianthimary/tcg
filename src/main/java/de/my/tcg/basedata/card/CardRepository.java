package de.my.tcg.basedata.card;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    @Query("select c from Card c where c.cardSet.id = ?1")
    List<Card> findByCardSet_Id(Integer id);

    boolean existsByShortDescription(String shortDescription);


}
