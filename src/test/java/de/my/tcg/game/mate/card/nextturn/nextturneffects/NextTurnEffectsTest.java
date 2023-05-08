package de.my.tcg.game.mate.card.nextturn.nextturneffects;

import de.my.tcg.TestCardFactory;
import de.my.tcg.basedata.Attack;
import de.my.tcg.basedata.cost.Cost;
import de.my.tcg.game.TestFieldSideFactory;
import de.my.tcg.game.coin.Coin;
import de.my.tcg.game.domain.PlayCard;
import de.my.tcg.game.mate.EnergyTotal;
import de.my.tcg.game.mate.FieldSide;
import de.my.tcg.game.mate.card.PokemonCard;
import de.my.tcg.game.mate.card.attack.AttackInterpreter;
import de.my.tcg.game.mate.card.nextturn.TurnEffect;
import de.my.tcg.game.mate.card.nextturn.TurnEffectState;
import de.my.tcg.game.mate.card.status.SpecialCondition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;
import java.util.Set;

import static de.my.tcg.basedata.poketype.PokeType.Water;
import static org.assertj.core.api.Assertions.assertThat;

class NextTurnEffectsTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/card/nextturn/nextturneffects/nextTurnEffects.csv", numLinesToSkip = 1)
    void nextTurnEffects(TurnEffectState effectState, int reduction, boolean multiplyDmg, boolean statusEffect, boolean hurtEffect, boolean benchDmg, boolean additionalDmg, boolean discard) {
        FieldSide myFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon("myPokemonName");
        FieldSide opponentFieldSide = setupOpponentMon(effectState, reduction);
        runMultiplyAttack(myFieldSide, opponentFieldSide);
        if (multiplyDmg) {
            checkMultiplyDmg(myFieldSide, opponentFieldSide);
        } else {
            checkNoMuliplyDmg(myFieldSide, opponentFieldSide);
        }

        opponentFieldSide = setupOpponentMon(effectState, reduction);
        runStatusAttack(myFieldSide, opponentFieldSide);
        if (statusEffect) {
            checkStatusEffect(opponentFieldSide);
        } else {
            checkNoStatusEffect(opponentFieldSide);
        }

        opponentFieldSide = setupOpponentMon(effectState, reduction);
        runHurtAttack(myFieldSide, opponentFieldSide);
        //Hier wird der Dmg am Gegner geprüft
        if (hurtEffect) {
            checkHurtEffect(myFieldSide, opponentFieldSide);
        } else {
            checkNoHurtEffect(myFieldSide, opponentFieldSide, reduction);
        }

        opponentFieldSide = setupOpponentMon(effectState, reduction);
        runBenchDmgEffect(myFieldSide, opponentFieldSide);
        if (benchDmg) {
            checkBenchDmg(myFieldSide, opponentFieldSide);
        } else {
            checkNoBenchDmg(myFieldSide, opponentFieldSide, reduction);
        }

        opponentFieldSide = setupOpponentMon(effectState, reduction);
        runAdditionalDmg(myFieldSide, opponentFieldSide);
        if (additionalDmg) {
            checkAdditionalDmg(myFieldSide, opponentFieldSide);
        } else {
            checkNoAdditionalDmg(myFieldSide, opponentFieldSide, reduction);
        }

    }


    private void runMultiplyAttack(FieldSide myFieldSide, FieldSide opponentFieldSide) {

        Attack attack = new Attack();
        attack.setText("Flip 6 coins. This attack does 30 damage times the number of heads.");
        attack.setDamage("30×");
        AttackInterpreter attackInterpreter = new AttackInterpreter(attack, myFieldSide, opponentFieldSide);
        attackInterpreter.performAttack();
    }

    private static FieldSide setupOpponentMon(TurnEffectState effectState, int reduction) {
        FieldSide opponentFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon("opponent");
        if (effectState != TurnEffectState.DMG_REDUCTION) {
            opponentFieldSide.getActiveMon().getNextTurnEffects().setTurnEffect(new TurnEffect(effectState));
        } else {
            opponentFieldSide.getActiveMon().getNextTurnEffects().setTurnEffect(new TurnEffect(reduction));
        }
        return opponentFieldSide;
    }

    private static void checkMultiplyDmg(FieldSide myFieldSide, FieldSide opponentFieldSide) {
        PokemonCard attackingPokemon = myFieldSide.getActiveMon();
        PokemonCard defendingPokemon = opponentFieldSide.getActiveMon();
        assertThat(defendingPokemon.getDmgCounter()).isEqualTo(Coin.headcount * 30);
        Coin.headcount = 0;
    }

    private void checkNoMuliplyDmg(FieldSide myFieldSide, FieldSide opponentFieldSide) {
        PokemonCard defendingPokemon = opponentFieldSide.getActiveMon();
        if (TurnEffectState.DMG_REDUCTION.equals(opponentFieldSide.getActiveMon().getNextTurnEffects().getTurnEffect().getTurnEffectState())) {
            int dmg = defendingPokemon.getDmgCounter();
            if (dmg > 0) {
                assertThat(dmg).isLessThan(Coin.headcount * 30);
            }
        } else {
            int dmg = defendingPokemon.getDmgCounter();
            assertThat(dmg).isZero();
        }
        Coin.headcount = 0;
    }

    private void runStatusAttack(FieldSide myFieldSide, FieldSide opponentFieldSide) {
        Attack attack = new Attack();
        attack.setText("The Defending Pokémon is now Asleep");
        attack.setDamage("50");
        AttackInterpreter attackInterpreter = new AttackInterpreter(attack, myFieldSide, opponentFieldSide);
        attackInterpreter.performAttack();
    }

    private void checkStatusEffect(FieldSide opponentFieldSide) {
        PokemonCard defendingPokemon = opponentFieldSide.getActiveMon();
        assertThat(defendingPokemon.getPokemonStatusCondition().getSpecialCondition()).isEqualTo(SpecialCondition.ASLEEP);
    }

    private void checkNoStatusEffect(FieldSide opponentFieldSide) {
        PokemonCard defendingPokemon = opponentFieldSide.getActiveMon();
        assertThat(defendingPokemon.getPokemonStatusCondition().getSpecialCondition()).isEqualTo(SpecialCondition.NO_STATUS);

    }

    private void runHurtAttack(FieldSide myFieldSide, FieldSide opponentFieldSide) {
        Attack attack = new Attack();
        attack.setText("This Pokemon does 40 damage to itself");
        attack.setDamage("60");
        AttackInterpreter attackInterpreter = new AttackInterpreter(attack, myFieldSide, opponentFieldSide);
        attackInterpreter.performAttack();
    }

    private void checkHurtEffect(FieldSide myFieldSide, FieldSide opponentFieldSide) {
        PokemonCard attackingPokemon = myFieldSide.getActiveMon();
        PokemonCard defendingPokemon = opponentFieldSide.getActiveMon();
        assertThat(attackingPokemon.getDmgCounter()).isEqualTo(40);
        assertThat(defendingPokemon.getDmgCounter()).isEqualTo(60);
    }

    private void checkNoHurtEffect(FieldSide myFieldSide, FieldSide opponentFieldSide, int reduction) {
        PokemonCard attackingPokemon = myFieldSide.getActiveMon();
        assertThat(attackingPokemon.getDmgCounter()).isEqualTo(40);
        PokemonCard defendingPokemon = opponentFieldSide.getActiveMon();
        if (TurnEffectState.DMG_REDUCTION.equals(defendingPokemon.getNextTurnEffects().getTurnEffect().getTurnEffectState())) {
            assertThat(defendingPokemon.getDmgCounter()).isEqualTo(60 - reduction);
        } else {
            assertThat(defendingPokemon.getDmgCounter()).isZero();
        }
    }

    private void runBenchDmgEffect(FieldSide myFieldSide, FieldSide opponentFieldSide) {
        List<PlayCard> myBenchMons = TestCardFactory.createANumberOfPokemonPlayCards(5);
        myBenchMons.forEach(myFieldSide::playBenchMonFromHand);
        List<PlayCard> opponentBenchMons = TestCardFactory.createANumberOfPokemonPlayCards(5);
        opponentBenchMons.forEach(opponentFieldSide::playBenchMonFromHand);
        Attack attack = new Attack();
        attack.setText("Does 20 damage to each Pokémon on each player's Bench. (Don't apply Weakness and Resistance for Benched Pokémon.)");
        attack.setDamage("80");
        AttackInterpreter attackInterpreter = new AttackInterpreter(attack, myFieldSide, opponentFieldSide);
        attackInterpreter.performAttack();
    }

    private void checkBenchDmg(FieldSide myFieldSide, FieldSide opponentFieldSide) {
        myFieldSide.getBenchMons().forEach(pokemonCard -> assertThat(pokemonCard.getDmgCounter()).isEqualTo(20));
        opponentFieldSide.getBenchMons().forEach(pokemonCard -> assertThat(pokemonCard.getDmgCounter()).isEqualTo(20));
        PokemonCard defendingPokemon = opponentFieldSide.getActiveMon();
        assertThat(defendingPokemon.getDmgCounter()).isEqualTo(80);
    }

    private void checkNoBenchDmg(FieldSide myFieldSide, FieldSide opponentFieldSide, int reduction) {
        myFieldSide.getBenchMons().forEach(pokemonCard -> assertThat(pokemonCard.getDmgCounter()).isEqualTo(20));
        opponentFieldSide.getBenchMons().forEach(pokemonCard -> assertThat(pokemonCard.getDmgCounter()).isEqualTo(20));
        PokemonCard defendingPokemon = opponentFieldSide.getActiveMon();
        if (TurnEffectState.DMG_REDUCTION.equals(defendingPokemon.getNextTurnEffects().getTurnEffect().getTurnEffectState())) {
            assertThat(defendingPokemon.getDmgCounter()).isEqualTo(80 - reduction);
        } else {
            assertThat(defendingPokemon.getDmgCounter()).isZero();
        }
    }

    private void runAdditionalDmg(FieldSide myFieldSide, FieldSide opponentFieldSide) {
        PokemonCard myPokemon = myFieldSide.getActiveMon();
        EnergyTotal energyTotal = myPokemon.getEnergyTotal();
        TestCardFactory.convertStringToEnergyCardList("[Water;Water;Water;Water;Water]").
                forEach(energyTotal::addEnergyCard);
        Attack attack = new Attack();
        attack.setText("Does 40 damage plus 10 more damage for each Water Energy attached to This Pokemon but not used to pay for this attack's Energy cost. You can't add more than 20 damage in this way.");
        attack.setDamage("40+");
        Cost cost1 = new Cost(Water, 3);
        attack.setCost(Set.of(cost1));
        attack.setConvertedEnergyCost(3);
        AttackInterpreter attackInterpreter = new AttackInterpreter(attack, myFieldSide, opponentFieldSide);
        attackInterpreter.performAttack();
    }

    private void checkAdditionalDmg(FieldSide myFieldSide, FieldSide opponentFieldSide) {
        PokemonCard defendingPokemon = opponentFieldSide.getActiveMon();
        assertThat(defendingPokemon.getDmgCounter()).isEqualTo(60);
    }

    private void checkNoAdditionalDmg(FieldSide myFieldSide, FieldSide opponentFieldSide, int reduction) {
        PokemonCard defendingPokemon = opponentFieldSide.getActiveMon();
        if (TurnEffectState.DMG_REDUCTION.equals(defendingPokemon.getNextTurnEffects().getTurnEffect().getTurnEffectState())) {
            assertThat(defendingPokemon.getDmgCounter()).isEqualTo(60 - reduction);
        } else {
            assertThat(defendingPokemon.getDmgCounter()).isZero();
        }
    }

    private void runDiscard(FieldSide myFieldSide, FieldSide opponentFieldSide) {
        PokemonCard attackingPokemon = myFieldSide.getActiveMon();
        EnergyTotal energyTotal = attackingPokemon.getEnergyTotal();
        TestCardFactory.convertStringToEnergyCardList("[Fire;Fire;Fire;Fire]").
                forEach(energyTotal::addEnergyCard);
    }

    private void checkDiscardlDmg(FieldSide myFieldSide, FieldSide opponentFieldSide) {
        PokemonCard defendingPokemon = opponentFieldSide.getActiveMon();
        assertThat(defendingPokemon.getDmgCounter()).isEqualTo(60);
        PokemonCard attackingPokemon = myFieldSide.getActiveMon();

        assertThat(attackingPokemon.getEnergyTotal().getTotalEnergy()).isEqualTo(2);
    }

    private void checkNoDiscardDmg(FieldSide myFieldSide, FieldSide opponentFieldSide, int reduction) {
        PokemonCard defendingPokemon = opponentFieldSide.getActiveMon();
        if (TurnEffectState.DMG_REDUCTION.equals(defendingPokemon.getNextTurnEffects().getTurnEffect().getTurnEffectState())) {
            assertThat(defendingPokemon.getDmgCounter()).isEqualTo(60 - reduction);
        } else {
            assertThat(defendingPokemon.getDmgCounter()).isZero();
        }
        PokemonCard attackingPokemon = myFieldSide.getActiveMon();
        EnergyTotal energyTotal = attackingPokemon.getEnergyTotal();

        assertThat(attackingPokemon.getEnergyTotal().getTotalEnergy()).isEqualTo(2);
    }
}