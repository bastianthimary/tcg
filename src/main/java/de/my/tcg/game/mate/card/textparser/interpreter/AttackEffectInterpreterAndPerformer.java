package de.my.tcg.game.mate.card.textparser.interpreter;

import de.my.tcg.basedata.Attack;
import de.my.tcg.basedata.poketype.PokeType;
import de.my.tcg.game.mate.FieldSide;
import de.my.tcg.game.mate.card.PokemonCard;
import de.my.tcg.game.mate.card.status.Status;
import de.my.tcg.game.mate.card.status.StatusConditionTextParser;
import de.my.tcg.game.mate.card.textparser.effect.CardEffect;
import de.my.tcg.game.mate.card.textparser.effect.condition.ConditionTerm;
import de.my.tcg.game.mate.card.textparser.effect.condition.condition.FlipCoinTerm;
import de.my.tcg.game.mate.card.textparser.effect.effect.BasicEffectTerm;
import de.my.tcg.game.mate.card.textparser.effect.effect.executed.bench.BenchDmgExecutedEffect;
import de.my.tcg.game.mate.card.textparser.effect.effect.executed.discard.DiscardEnergyExecution;
import de.my.tcg.game.mate.card.textparser.effect.effect.executed.dmgeffect.MultipleDmgEffectTerm;
import de.my.tcg.game.mate.card.textparser.effect.effect.executed.hurt.HurtExecutedEffect;
import de.my.tcg.game.mate.card.textparser.effect.effect.executed.statuscondition.StatusConditionExecutedEffect;
import de.my.tcg.game.mate.card.textparser.effect.effect.target.MultipleEffectTarget;
import de.my.tcg.game.mate.card.textparser.effect.effect.target.SingleEffectTarget;
import de.my.tcg.game.mate.card.textparser.effect.effect.target.Target;
import de.my.tcg.game.mate.card.textparser.utils.CardTextUtil;
import de.my.tcg.game.mate.card.textparser.utils.NumberParser;
import de.my.tcg.grammar.parser.interpreter.EffectTextParserBaseVisitor;
import de.my.tcg.grammar.parser.interpreter.EffectTextParserLexer;
import de.my.tcg.grammar.parser.interpreter.EffectTextParserParser;
import lombok.Getter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AttackEffectInterpreterAndPerformer extends EffectTextParserBaseVisitor<Integer> implements Performer {
    private int dmg;
    @Getter
    private final List<CardEffect> terms = new ArrayList<>();
    private CardEffect currentTerm;
    private final PokemonCard thisPokemonCard;
    private final FieldSide thisFieldSide;
    private final PokemonCard defendingPokemonCard;
    private final FieldSide opponentSide;
    private final Attack attack;

    public AttackEffectInterpreterAndPerformer(Attack attack, FieldSide thisFieldSide, FieldSide opponentSide) {
        this.thisPokemonCard = thisFieldSide.getActiveMon();
        this.thisFieldSide = thisFieldSide;
        this.defendingPokemonCard = opponentSide.getActiveMon();
        this.opponentSide = opponentSide;
        this.attack = attack;
    }

    public void interpretAndPerformAttack() {
        parseTextAndPerformEffect();
        terms.forEach(CardEffect::runEffect);
        doDmg();
    }

    private void doDmg() {
        calculateDmg();
        opponentSide.getActiveMon().doAttackDmg(dmg);
    }

    private void parseTextAndPerformEffect() {
        String normalizedString = CardTextUtil.normalizeString(attack.getText(), thisPokemonCard);
        CharStream inputStream = CharStreams.fromString(normalizedString);
        EffectTextParserLexer lexer = new EffectTextParserLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        EffectTextParserParser parser = new EffectTextParserParser(tokens);
        ParseTree tree = parser.effectText();
        visit(tree);
    }

    private void calculateDmg() {
        String dmgAsString = attack.getDamage();
        if (dmgAsString.contains(CardTextUtil.PLUS_SYMBOL)) {
            throw new IllegalArgumentException();
        } else if (dmgAsString.contains(CardTextUtil.MULTIPLY_SYMBOL)) {
            MultipleDmgEffectTerm multipleDmgEffectTerm = getMultipleDmgEffectTermFromTermList();
            if (multipleDmgEffectTerm != null) {
                dmg = multipleDmgEffectTerm.getDmg();
            }
        } else {
            if (!attack.getDamage().isEmpty()) {
                dmg = NumberParser.parseNumberOrStringToInteger(attack.getDamage());
            }
        }
    }

    private MultipleDmgEffectTerm getMultipleDmgEffectTermFromTermList() {
        Optional<CardEffect> cardEffect = terms.stream().filter(
                cf -> cf.getEffectTerm() instanceof MultipleDmgEffectTerm).findFirst();
        return cardEffect.map(effect -> (MultipleDmgEffectTerm) effect.getEffectTerm()).orElse(null);
    }


    @Override
    public Integer visitTerm(EffectTextParserParser.TermContext ctx) {
        currentTerm = new CardEffect(ctx.getText());
        visitChildren(ctx);
        terms.add(currentTerm);
        return 0;
    }

    @Override
    public Integer visitFlipCoin(EffectTextParserParser.FlipCoinContext ctx) {

        FlipCoinTerm flipCoinTerm = new FlipCoinTerm();
        flipCoinTerm.setupCondition(ctx.times.getText());
        currentTerm.setEffectCondition(flipCoinTerm);
        visitChildren(ctx);
        return 0;
    }


    @Override
    public Integer visitConditionTypes(EffectTextParserParser.ConditionTypesContext ctx) {
        visitChildren(ctx);
        ConditionTerm conditionTerm = currentTerm.getEffectCondition();
        conditionTerm.setupConditionType(ctx.getText());
        return 0;
    }

    @Override
    public Integer visitMultipleDmgEffect(EffectTextParserParser.MultipleDmgEffectContext ctx) {
        MultipleDmgEffectTerm multipleDmgEffectTerm = new MultipleDmgEffectTerm();
        multipleDmgEffectTerm.setDmgPerString(ctx.dmgPer.getText());
        currentTerm.setEffectTerm(multipleDmgEffectTerm);
        visitChildren(ctx);
        return visitChildren(ctx);
    }

    @Override
    public Integer visitTarget(EffectTextParserParser.TargetContext ctx) {
        visitChildren(ctx);
        BasicEffectTerm effectTerm = (BasicEffectTerm) currentTerm.getEffectTerm();
        PokemonCard pokemonCard;
        switch (Target.getTargetByName(ctx.getText())) {
            case THIS_POKEMON, NO_TARGET -> pokemonCard = thisPokemonCard;
            case DEFENDING_POKEMON -> pokemonCard = defendingPokemonCard;
            default -> pokemonCard = thisPokemonCard;
        }
        effectTerm.setEffectTarget(new SingleEffectTarget(pokemonCard));
        return 0;
    }

    @Override
    public Integer visitBasicEffect(EffectTextParserParser.BasicEffectContext ctx) {
        currentTerm.setEffectTerm(new BasicEffectTerm());
        return visitChildren(ctx);
    }

    @Override
    public Integer visitStatusCondition(EffectTextParserParser.StatusConditionContext ctx) {
        Status status = StatusConditionTextParser.parseStatusFromString(ctx.getText().toUpperCase());
        BasicEffectTerm basicEffectTerm = (BasicEffectTerm) currentTerm.getEffectTerm();
        basicEffectTerm.setExecutedEffect(new StatusConditionExecutedEffect(status));
        return visitChildren(ctx);
    }

    @Override
    public Integer visitHurtEffect(EffectTextParserParser.HurtEffectContext ctx) {
        int dmg = NumberParser.parseNumberOrStringToInteger(ctx.dmg.getText());
        BasicEffectTerm basicEffectTerm = (BasicEffectTerm) currentTerm.getEffectTerm();
        basicEffectTerm.setExecutedEffect(new HurtExecutedEffect(dmg));
        return visitChildren(ctx);
    }

    @Override
    public Integer visitDiscardEnergy(EffectTextParserParser.DiscardEnergyContext ctx) {
        int numberOfCards = NumberParser.parseNumberOrStringToInteger(ctx.numberOfCards.getText());
        PokeType typeOfDiscardion;
        if (numberOfCards == NumberParser.ALL) {
            typeOfDiscardion = PokeType.All;
        } else {
            typeOfDiscardion = PokeType.valueOf(ctx.PokeType().getText());
        }

        BasicEffectTerm basicEffectTerm = (BasicEffectTerm) currentTerm.getEffectTerm();
        FieldSide fieldSide;
        switch (Target.getTargetByName(ctx.target().getText())) {
            case THIS_POKEMON, NO_TARGET -> fieldSide = thisFieldSide;
            case DEFENDING_POKEMON -> fieldSide = opponentSide;
            default -> fieldSide = thisFieldSide;
        }
        basicEffectTerm.setExecutedEffect(new DiscardEnergyExecution(typeOfDiscardion, numberOfCards, fieldSide));
        return visitChildren(ctx);
    }

    @Override
    public Integer visitBenchDmgEffect(EffectTextParserParser.BenchDmgEffectContext ctx) {
        visitChildren(ctx);
        List<PokemonCard> benchMons = new ArrayList<>();
        String benchTargetAsString = ctx.benchTarget().getText();
        if (!benchTargetAsString.isEmpty()) {
            Target target = Target.getTargetByName(benchTargetAsString);
            if (target == Target.BOTH_PLAYERS_BENCH) {
                addBothBenches(benchMons);
            } else if (target == Target.MY_BENCH) {
                addMyBench(benchMons);
            }
        }
        BasicEffectTerm basicEffectTerm = (BasicEffectTerm) currentTerm.getEffectTerm();
        int dmg = NumberParser.parseNumberOrStringToInteger(ctx.dmg.getText());
        basicEffectTerm.setExecutedEffect(new BenchDmgExecutedEffect(dmg));
        basicEffectTerm.setEffectTarget(new MultipleEffectTarget(benchMons));
        return 0;
    }

    private void addMyBench(List<PokemonCard> benchMons) {
        benchMons.addAll(thisFieldSide.getBenchMons());
    }

    private void addBothBenches(List<PokemonCard> benchMons) {
        benchMons.addAll(thisFieldSide.getBenchMons());
        benchMons.addAll(opponentSide.getBenchMons());
    }
}
