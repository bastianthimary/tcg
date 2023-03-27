package de.my.tcg.basedata.cardset;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardSetRepository extends JpaRepository<CardSet,Long> {
    @Query("select c from CardSet c where c.name = ?1")
    Optional<CardSet> getByName(String name);
    @Query("select c from CardSet c where c.shortname = ?1")
    Optional<CardSet> findByShortname(String shortname);

}
