package de.my.tcg.game.mate.card.textparser;

import de.my.tcg.basedata.Attack;
import de.my.tcg.game.mate.FieldSide;
import de.my.tcg.game.mate.card.PokemonCard;
import de.my.tcg.game.mate.card.status.SpecialCondition;
import de.my.tcg.game.mate.card.textparser.effect.*;
import de.my.tcg.game.mate.card.textparser.effect.condition.ConditionTerm;
import de.my.tcg.game.mate.card.textparser.effect.condition.flipcoin.FlipCoinTerm;
import de.my.tcg.grammar.parser.interpreter.EffectTextParserBaseVisitor;
import de.my.tcg.grammar.parser.interpreter.EffectTextParserLexer;
import de.my.tcg.grammar.parser.interpreter.EffectTextParserParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AttackEffectInterpreterAndPerformer extends EffectTextParserBaseVisitor<Integer> {
    private int times;
    private int dmgPer;
    private int dmg;
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
        opponentSide.getActiveMon().doSimpleDmg(dmg);
    }

    private void parseTextAndPerformEffect() {
        String normalizedString = normalizeString(attack.getText());
        CharStream inputStream = CharStreams.fromString(normalizedString);
        EffectTextParserLexer lexer = new EffectTextParserLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        EffectTextParserParser parser = new EffectTextParserParser(tokens);
        ParseTree tree = parser.effectText();
        visit(tree);
    }

    private void calculateDmg() {
        String dmgAsString = attack.getDamage();
        if (dmgAsString.contains("/+")) {

        } else if (dmgAsString.contains("×")) {
            dmg = getMultipleDmgEffectTermFromTermList().getDmg();
        } else {
            dmg = Integer.parseInt(attack.getDamage());
        }
    }

    private MultipleDmgEffectTerm getMultipleDmgEffectTermFromTermList() {
        Optional<CardEffect> cardEffect = terms.stream().filter(
                cf -> cf.getEffectTerm() instanceof MultipleDmgEffectTerm).findFirst();
        return (MultipleDmgEffectTerm) cardEffect.get().getEffectTerm();
    }


    private String normalizeString(String parseString) {
        if (parseString.contains(thisPokemonCard.getName())) {
            return parseString.replace(thisPokemonCard.getName(), "this Pokemon");
        }
        return parseString;
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
        BasicEffectTerm effectTerm = (BasicEffectTerm) currentTerm.getEffectTerm();
        PokemonCard pokemonCard;
        switch (Target.getTargetByName(ctx.getText())) {
            case THIS_POKEMON, NO_TARGET -> pokemonCard = thisPokemonCard;
            case DEFENDING_POKEMON -> pokemonCard = defendingPokemonCard;
            default -> pokemonCard = thisPokemonCard;
        }
        effectTerm.setEffectTarget(new EffectTarget(pokemonCard));
        return visitChildren(ctx);
    }

    @Override
    public Integer visitBasicEffect(EffectTextParserParser.BasicEffectContext ctx) {
        currentTerm.setEffectTerm(new BasicEffectTerm());
        return visitChildren(ctx);
    }

    @Override
    public Integer visitStatusCondition(EffectTextParserParser.StatusConditionContext ctx) {
        SpecialCondition condition = SpecialCondition.valueOf(ctx.getText().toUpperCase());
        BasicEffectTerm basicEffectTerm = (BasicEffectTerm) currentTerm.getEffectTerm();
        basicEffectTerm.setExecutedEffect(new SpecialConditionExecutedEffect(condition));
        return visitChildren(ctx);
    }
}
