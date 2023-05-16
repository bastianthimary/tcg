package de.my.tcg.game.mate.card.attack;

import de.my.tcg.TestCardFactory;
import de.my.tcg.basedata.Attack;
import de.my.tcg.basedata.cost.Cost;
import de.my.tcg.game.TestFieldSideFactory;
import de.my.tcg.game.coin.Coin;
import de.my.tcg.game.domain.PlayCard;
import de.my.tcg.game.domain.PlayDeck;
import de.my.tcg.game.mate.EnergyTotal;
import de.my.tcg.game.mate.FieldSide;
import de.my.tcg.game.mate.card.PokemonCard;
import de.my.tcg.game.mate.card.nextturn.TurnEffectState;
import de.my.tcg.game.mate.card.status.PoisonCondition;
import de.my.tcg.game.mate.card.status.SpecialCondition;
import de.my.tcg.game.mate.card.textparser.effect.effect.target.Target;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class AttackInterpreterTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/card/attack/attackinterpreter/MultiplyDmg.csv", numLinesToSkip = 1)
    void MultiplyDmg(String dmgAsString, String attackString, int dmgPer, boolean expectCoinFlip,
                     String myPokemonName, SpecialCondition myCondition, SpecialCondition defendingPokemonCondition) {
        FieldSide myFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon(myPokemonName);
        FieldSide opponentFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon("opponent");
        Attack attack = new Attack();
        attack.setText(attackString);
        attack.setDamage(dmgAsString);
        AttackInterpreter attackInterpreter = new AttackInterpreter(attack, myFieldSide, opponentFieldSide);
        attackInterpreter.performAttack();
        PokemonCard attackingPokemon = myFieldSide.getActiveMon();
        PokemonCard defendingPokemon = opponentFieldSide.getActiveMon();
        if (expectCoinFlip) {
            assertThat(defendingPokemon.getDmgCounter()).isEqualTo(Coin.headcount * dmgPer);
            Coin.headcount = 0;
        }
        assertThat(attackingPokemon.getPokemonStatusCondition().getSpecialCondition()).isEqualTo(myCondition);
        assertThat(defendingPokemon.getPokemonStatusCondition().getSpecialCondition()).isEqualTo(defendingPokemonCondition);

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/card/attack/attackinterpreter/attackWithStatusEffect.csv", numLinesToSkip = 1)
    void attackWithStatusEffect(String dmgAsString, String attackString, int dmgPer, boolean expectCoinFlipForMy,
                                String myPokemonName, SpecialCondition myCondition, boolean expectCoinFlipForDefending, SpecialCondition defendingPokemonCondition) {
        FieldSide myFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon(myPokemonName);
        FieldSide opponentFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon("opponent");
        Attack attack = new Attack();
        attack.setText(attackString);
        attack.setDamage(dmgAsString);
        AttackInterpreter attackInterpreter = new AttackInterpreter(attack, myFieldSide, opponentFieldSide);
        attackInterpreter.performAttack();

        PokemonCard attackingPokemon = myFieldSide.getActiveMon();
        PokemonCard defendingPokemon = opponentFieldSide.getActiveMon();
        assertThat(defendingPokemon.getDmgCounter()).isEqualTo(dmgPer);
        if (expectCoinFlipForMy) {
            if (Coin.headcount == 1) {
                assertThat(attackingPokemon.getPokemonStatusCondition().getSpecialCondition()).isEqualTo(myCondition);
            } else {

                assertThat(attackingPokemon.getPokemonStatusCondition().getSpecialCondition()).isEqualTo(SpecialCondition.NO_STATUS);
            }
            Coin.headcount = 0;
        } else {
            assertThat(attackingPokemon.getPokemonStatusCondition().getSpecialCondition()).isEqualTo(myCondition);
        }
        if (expectCoinFlipForDefending) {
            if (Coin.headcount == 1) {
                System.out.println("was head");
                assertThat(defendingPokemon.getPokemonStatusCondition().getSpecialCondition()).isEqualTo(defendingPokemonCondition);
            } else {
                System.out.println("was tails");
                assertThat(defendingPokemon.getPokemonStatusCondition().getSpecialCondition()).isEqualTo(SpecialCondition.NO_STATUS);
            }
            Coin.headcount = 0;
        } else {
            assertThat(defendingPokemon.getPokemonStatusCondition().getSpecialCondition()).isEqualTo(defendingPokemonCondition);
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/card/attack/attackinterpreter/attackWithPoisonEffect.csv", numLinesToSkip = 1)
    void attackWithPoisonEffect(String dmgAsString, String attackString, int dmgPer, boolean expectCoinFlipForMy,
                                String myPokemonName, PoisonCondition myCondition, boolean expectCoinFlipForDefending, PoisonCondition defendingPokemonCondition) {
        FieldSide myFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon(myPokemonName);
        FieldSide opponentFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon("opponent");
        Attack attack = new Attack();
        attack.setText(attackString);
        attack.setDamage(dmgAsString);
        AttackInterpreter attackInterpreter = new AttackInterpreter(attack, myFieldSide, opponentFieldSide);
        attackInterpreter.performAttack();

        PokemonCard attackingPokemon = myFieldSide.getActiveMon();
        PokemonCard defendingPokemon = opponentFieldSide.getActiveMon();
        assertThat(defendingPokemon.getDmgCounter()).isEqualTo(dmgPer);
        if (expectCoinFlipForMy) {
            if (Coin.headcount == 1) {
                assertThat(attackingPokemon.getPokemonStatusCondition().getPoisonConditionState()).isEqualTo(myCondition);
            } else {

                assertThat(attackingPokemon.getPokemonStatusCondition().getPoisonConditionState()).isEqualTo(PoisonCondition.NO_STATUS);
            }
            Coin.headcount = 0;
        } else {
            assertThat(attackingPokemon.getPokemonStatusCondition().getPoisonConditionState()).isEqualTo(myCondition);
        }
        if (expectCoinFlipForDefending) {
            if (Coin.headcount == 1) {
                System.out.println("was head");
                assertThat(defendingPokemon.getPokemonStatusCondition().getPoisonConditionState()).isEqualTo(defendingPokemonCondition);
            } else {
                System.out.println("was tails");
                assertThat(defendingPokemon.getPokemonStatusCondition().getPoisonConditionState()).isEqualTo(PoisonCondition.NO_STATUS);
            }
            Coin.headcount = 0;
        } else {
            assertThat(defendingPokemon.getPokemonStatusCondition().getPoisonConditionState()).isEqualTo(defendingPokemonCondition);
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/card/attack/attackinterpreter/hurtEffect.csv", numLinesToSkip = 1)
    void hurtEffect(String dmgAsString, String attackString, int dmgTo, int hurtDmg, boolean expectCoinFlipForMy, String myPokemonName) {
        FieldSide myFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon(myPokemonName);
        FieldSide opponentFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon("opponent");
        Attack attack = new Attack();
        attack.setText(attackString);
        attack.setDamage(dmgAsString);
        AttackInterpreter attackInterpreter = new AttackInterpreter(attack, myFieldSide, opponentFieldSide);
        attackInterpreter.performAttack();

        PokemonCard attackingPokemon = myFieldSide.getActiveMon();
        PokemonCard defendingPokemon = opponentFieldSide.getActiveMon();
        assertThat(defendingPokemon.getDmgCounter()).isEqualTo(dmgTo);
        if (expectCoinFlipForMy) {
            if (Coin.headcount == 1) {
                System.out.println("was head");
                assertThat(attackingPokemon.getDmgCounter()).isZero();
            } else {
                System.out.println("was tails");
                assertThat(attackingPokemon.getDmgCounter()).isEqualTo(hurtDmg);
            }
            Coin.headcount = 0;
        } else {
            assertThat(attackingPokemon.getDmgCounter()).isEqualTo(hurtDmg);
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/card/attack/attackinterpreter/benchDmgEffect.csv", numLinesToSkip = 1)
    void benchDmgEffect(String dmgAsString, String attackString, int dmgTo, int hurtDmg, String myPokemonName, int benchDmg, Target target) {
        FieldSide myFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon(myPokemonName);
        FieldSide opponentFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon("opponent");

        List<PlayCard> myBenchMons = TestCardFactory.createANumberOfPokemonPlayCards(5);
        myBenchMons.forEach(myFieldSide::playBenchMonFromHand);
        List<PlayCard> opponentBenchMons = TestCardFactory.createANumberOfPokemonPlayCards(5);
        opponentBenchMons.forEach(opponentFieldSide::playBenchMonFromHand);
        Attack attack = new Attack();
        attack.setText(attackString);
        attack.setDamage(dmgAsString);

        AttackInterpreter attackInterpreter = new AttackInterpreter(attack, myFieldSide, opponentFieldSide);
        attackInterpreter.performAttack();

        PokemonCard attackingPokemon = myFieldSide.getActiveMon();
        PokemonCard defendingPokemon = opponentFieldSide.getActiveMon();
        assertThat(defendingPokemon.getDmgCounter()).isEqualTo(dmgTo);
        assertThat(attackingPokemon.getDmgCounter()).isEqualTo(hurtDmg);
        if (target.equals(Target.MY_BENCH)) {
            myFieldSide.getBenchMons().forEach(pokemonCard -> assertThat(pokemonCard.getDmgCounter()).isEqualTo(benchDmg));
            opponentFieldSide.getBenchMons().forEach(pokemonCard -> assertThat(pokemonCard.getDmgCounter()).isZero());
        } else if (target.equals(Target.BOTH_PLAYERS_BENCH)) {
            myFieldSide.getBenchMons().forEach(pokemonCard -> assertThat(pokemonCard.getDmgCounter()).isEqualTo(benchDmg));
            opponentFieldSide.getBenchMons().forEach(pokemonCard -> assertThat(pokemonCard.getDmgCounter()).isEqualTo(benchDmg));
        }


    }

    @ParameterizedTest
    @CsvFileSource(resources = "/card/attack/attackinterpreter/additionalDmgByEnergy.csv", numLinesToSkip = 1)
    void additionalDmgByEnergy(String dmgAsString, String attackString, int expectedDmg, String energyCardsAsString,
                               String costtype, int costqty, String myPokemonName) {


        FieldSide myFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon(myPokemonName);
        FieldSide opponentFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon("opponent");
        PokemonCard myPokemon = myFieldSide.getActiveMon();
        EnergyTotal energyTotal = myPokemon.getEnergyTotal();
        TestCardFactory.convertStringToEnergyCardList(energyCardsAsString).
                forEach(energyTotal::addEnergyCard);
        Attack attack = new Attack();
        attack.setText(attackString);
        attack.setDamage(dmgAsString);
        Cost cost1 = new Cost(costtype, costqty);
        attack.setCost(Set.of(cost1));
        attack.setConvertedEnergyCost(costqty);
        AttackInterpreter attackInterpreter = new AttackInterpreter(attack, myFieldSide, opponentFieldSide);
        attackInterpreter.performAttack();

        PokemonCard defendingPokemon = opponentFieldSide.getActiveMon();
        assertThat(defendingPokemon.getDmgCounter()).isEqualTo(expectedDmg);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/card/attack/attackinterpreter/additionalDmgByDmgCounter.csv", numLinesToSkip = 1)
    void additionalDmgByDmgCounter(String dmgAsString, String attackString, int expectedDmg, int dmgOnDefendingMon) {


        FieldSide myFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon("myPokemonName");
        FieldSide opponentFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon("opponent");
        PokemonCard opponentMon = opponentFieldSide.getActiveMon();
        opponentMon.doSimpleDmg(dmgOnDefendingMon);
        Attack attack = new Attack();
        attack.setText(attackString);
        attack.setDamage(dmgAsString);

        AttackInterpreter attackInterpreter = new AttackInterpreter(attack, myFieldSide, opponentFieldSide);
        attackInterpreter.performAttack();

        PokemonCard defendingPokemon = opponentFieldSide.getActiveMon();
        assertThat(defendingPokemon.getDmgCounter()).isEqualTo(expectedDmg);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/card/attack/attackinterpreter/discardEnergy.csv", numLinesToSkip = 1)
    void discardEnergy(String attackString, String energyCardsAsString, int energyBefore, int energyAfter, String myPokemonName) {

        FieldSide myFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon(myPokemonName);
        FieldSide opponentFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon("opponent");
        Attack attack = new Attack();
        attack.setText(attackString);
        attack.setDamage("20");
        PokemonCard attackingPokemon = myFieldSide.getActiveMon();
        EnergyTotal energyTotal = attackingPokemon.getEnergyTotal();
        TestCardFactory.convertStringToEnergyCardList(energyCardsAsString).
                forEach(energyTotal::addEnergyCard);
        assertThat(attackingPokemon.getEnergyTotal().getTotalEnergy()).isEqualTo(energyBefore);
        AttackInterpreter attackInterpreter = new AttackInterpreter(attack, myFieldSide, opponentFieldSide);
        attackInterpreter.performAttack();
        assertThat(attackingPokemon.getEnergyTotal().getTotalEnergy()).isEqualTo(energyAfter);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/card/attack/attackinterpreter/attackPreventDmgNextTurnEffect.csv", numLinesToSkip = 1, delimiter = ';')
    void attackPreventDmgNextTurnEffect(String dmgAsString, String attackString, int dmgPer, boolean expectCoinFlipForMy,
                                        String myPokemonName, TurnEffectState myNextTurnState) {
        FieldSide myFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon(myPokemonName);
        FieldSide opponentFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon("opponent");
        Attack attack = new Attack();
        attack.setText(attackString);
        attack.setDamage(dmgAsString);
        AttackInterpreter attackInterpreter = new AttackInterpreter(attack, myFieldSide, opponentFieldSide);
        attackInterpreter.performAttack();

        PokemonCard attackingPokemon = myFieldSide.getActiveMon();
        PokemonCard defendingPokemon = opponentFieldSide.getActiveMon();
        assertThat(defendingPokemon.getDmgCounter()).isEqualTo(dmgPer);
        if (expectCoinFlipForMy) {
            if (Coin.headcount == 1) {
                System.out.println("was head");
                assertThat(attackingPokemon.getNextTurnEffects().getTurnEffect().getTurnEffectState()).isEqualTo(myNextTurnState);
            } else {
                System.out.println("was tails");

                assertThat(attackingPokemon.getNextTurnEffects().getTurnEffect()).isNull();
            }
            Coin.headcount = 0;
        } else {
            assertThat(attackingPokemon.getNextTurnEffects().getTurnEffect().getTurnEffectState()).isEqualTo(myNextTurnState);
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/card/attack/attackinterpreter/attackPreventRetreatNextTurnEffect.csv", numLinesToSkip = 1, delimiter = ';')
    void attackPreventRetreatNextTurnEffect(String dmgAsString, String attackString, int dmgPer,
                                            String myPokemonName, TurnEffectState myNextTurnState) {
        FieldSide myFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon(myPokemonName);
        FieldSide opponentFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon("opponent");
        Attack attack = new Attack();
        attack.setText(attackString);
        attack.setDamage(dmgAsString);
        AttackInterpreter attackInterpreter = new AttackInterpreter(attack, myFieldSide, opponentFieldSide);
        attackInterpreter.performAttack();

        PokemonCard attackingPokemon = myFieldSide.getActiveMon();
        PokemonCard defendingPokemon = opponentFieldSide.getActiveMon();
        assertThat(defendingPokemon.getDmgCounter()).isEqualTo(dmgPer);
        assertThat(defendingPokemon.getNextTurnEffects().getTurnEffect().getTurnEffectState()).isEqualTo(myNextTurnState);

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/card/attack/attackinterpreter/DoNothing.csv", numLinesToSkip = 1)
    void DoNothing(String dmgAsString, String attackString, int dmg,
                   String myPokemonName) {
        FieldSide myFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon(myPokemonName);
        FieldSide opponentFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon("opponent");
        Attack attack = new Attack();
        attack.setText(attackString);
        attack.setDamage(dmgAsString);
        AttackInterpreter attackInterpreter = new AttackInterpreter(attack, myFieldSide, opponentFieldSide);
        attackInterpreter.performAttack();

        PokemonCard defendingPokemon = opponentFieldSide.getActiveMon();
        if (Coin.headcount == 0) {
            System.out.println("was Tails");
            assertThat(defendingPokemon.getDmgCounter()).isZero();
        } else {
            System.out.println("was Head");
            assertThat(defendingPokemon.getDmgCounter()).isEqualTo(dmg);
        }
        Coin.headcount = 0;

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/card/attack/attackinterpreter/ifElseDmg.csv", numLinesToSkip = 1)
    void ifElseDmg(String dmgAsString, String attackString, int ifDmg, int elsedmg,
                   String myPokemonName) {
        FieldSide myFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon(myPokemonName);
        FieldSide opponentFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon("opponent");
        Attack attack = new Attack();
        attack.setText(attackString);
        attack.setDamage(dmgAsString);
        AttackInterpreter attackInterpreter = new AttackInterpreter(attack, myFieldSide, opponentFieldSide);
        attackInterpreter.performAttack();

        PokemonCard defendingPokemon = opponentFieldSide.getActiveMon();
        if (Coin.headcount == 0) {
            System.out.println("was Tails");
            assertThat(defendingPokemon.getDmgCounter()).isEqualTo(elsedmg);
        } else {
            System.out.println("was Head");
            assertThat(defendingPokemon.getDmgCounter()).isEqualTo(ifDmg);
        }
        Coin.headcount = 0;

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/card/attack/attackinterpreter/drawCards.csv", numLinesToSkip = 1, delimiterString = ";")
    void drawCards(String attackString, boolean coinFlip, int numberOfCards) {
        FieldSide myFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon("MyMon");
        FieldSide opponentFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon("opponent");
        var player = myFieldSide.getPlayer();
        var playCards = TestCardFactory.createANumberOfTrainerPlayCards(10);
        PlayDeck deck = new PlayDeck();
        playCards.forEach(deck::addCard);
        player.setPlaydeck(deck);
        Attack attack = new Attack();
        attack.setText(attackString);
        attack.setDamage("20");
        AttackInterpreter attackInterpreter = new AttackInterpreter(attack, myFieldSide, opponentFieldSide);
        attackInterpreter.performAttack();
        PokemonCard defendingPokemon = opponentFieldSide.getActiveMon();
        if (coinFlip) {
            if (Coin.headcount == 0) {
                System.out.println("was Tails");
                assertThat(myFieldSide.getPlayer().getHandCards()).isEmpty();
            } else {
                System.out.println("was Head");
                assertThat(myFieldSide.getPlayer().getHandCards()).hasSize(numberOfCards);
            }
        } else {
            assertThat(myFieldSide.getPlayer().getHandCards()).hasSize(numberOfCards);
        }
        assertThat(defendingPokemon.getDmgCounter()).isEqualTo(20);
        Coin.headcount = 0;
    }
}