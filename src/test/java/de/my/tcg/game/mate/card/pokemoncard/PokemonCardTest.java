package de.my.tcg.game.mate.card.pokemoncard;

import de.my.tcg.TestCardFactory;
import de.my.tcg.basedata.Attack;
import de.my.tcg.basedata.CardTypes;
import de.my.tcg.basedata.card.Card;
import de.my.tcg.basedata.poketype.PokeType;
import de.my.tcg.game.mate.card.MonIsDefeatedException;
import de.my.tcg.game.mate.card.PokemonCard;
import de.my.tcg.game.mate.card.status.FireCondition;
import de.my.tcg.mapper.CardPlayCardMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mapstruct.factory.Mappers;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class PokemonCardTest {
    private final CardPlayCardMapper cardPlayCardMapper = Mappers.getMapper(CardPlayCardMapper.class);

    @ParameterizedTest
    @CsvFileSource(resources = "/card/pokemoncard/pokemoncard/doDmgAccordingToType.csv", numLinesToSkip = 1)
    void doDmgAccordingToType(String hp, PokeType resistance,
                              PokeType weakness, int originDmg, PokeType takeDmgByType,
                              int expectedDmg, boolean survive) {
        Card baseCard = new Card();
        baseCard.setHp(hp);
        baseCard.setResistances(resistance);
        baseCard.setWeaknesses(weakness);
        baseCard.setConvertedRetreatCost(0);
        PokemonCard pokemonCard = new PokemonCard(cardPlayCardMapper.cardToPlayCard(baseCard));
        try {
            pokemonCard.doDmgAccordingToType(originDmg, takeDmgByType);
            assertThat(survive).isTrue();
        } catch (MonIsDefeatedException e) {
            assertThat(survive).isFalse();
        }
        assertThat(pokemonCard.getDmgCounter()).isEqualTo(expectedDmg);
    }


    @Test
    void evolvePokemon() throws MonIsDefeatedException {
        Card card = new Card();
        card.setSupertype(CardTypes.POKEMON);
        card.setName("Base");
        card.setHp("90");
        card.setWeaknesses(PokeType.Water);
        card.setTypes(Set.of(PokeType.Water.getTypeName()));
        card.setResistances(PokeType.Fire);
        card.setConvertedRetreatCost(1);

        Attack baseAttack = new Attack();
        baseAttack.setName("BaseAttack");
        card.setAttacks(Set.of(baseAttack));

        PokemonCard pokemonCard = new PokemonCard(cardPlayCardMapper.cardToPlayCard(card));
        pokemonCard.doSimpleDmg(20);
        pokemonCard.getPokemonStatusCondition().setFireConditionState(FireCondition.SINGLE);
        pokemonCard.getEnergyTotal().addEnergyCard(TestCardFactory.createEnergyCard(PokeType.Fire));

        Card card2 = new Card();
        card2.setSupertype(CardTypes.POKEMON);
        card2.setName("Evolution");
        card2.setHp("100");
        card2.setEvolvesFrom("Base");
        card2.setTypes(Set.of(PokeType.Fire.getTypeName()));
        card2.setWeaknesses(PokeType.Fire);
        card2.setConvertedRetreatCost(2);

        Attack evoAttack = new Attack();
        evoAttack.setName("EvoAttack");
        card2.setAttacks(Set.of(evoAttack));

        pokemonCard.evolvePokemon(cardPlayCardMapper.cardToPlayCard(card2));

        assertThat(pokemonCard.getName()).isEqualTo("Evolution");
        assertThat(pokemonCard.getHp()).isEqualTo(100);
        assertThat(pokemonCard.getMyPokeType()).isEqualTo(PokeType.Fire);
        assertThat(pokemonCard.getWeakness()).contains(PokeType.Fire);
        assertThat(pokemonCard.getResistance()).isEmpty();
        assertThat(pokemonCard.getRetreatCosts()).isEqualTo(2);

        assertThat(pokemonCard.getDmgCounter()).isEqualTo(20);
        assertThat(pokemonCard.getPokemonStatusCondition().getFireConditionState()).isEqualTo(FireCondition.NO_STATUS);
        assertThat(pokemonCard.getEnergyTotal().getTotalEnergy()).isEqualTo(1);

        assertThat(pokemonCard.getAttacks()).hasSize(1);
        assertThat(pokemonCard.getAttacks().get(0).getName()).isEqualTo("EvoAttack");

        assertThat(pokemonCard.getPreEvolution()).hasSize(1);

    }

}