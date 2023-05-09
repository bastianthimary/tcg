package de.my.tcg.game.mate.card.textparser.interpreter;

import de.my.tcg.basedata.Attack;
import de.my.tcg.basedata.poketype.PokeType;
import de.my.tcg.game.mate.FieldSide;
import de.my.tcg.game.mate.card.PokemonCard;
import de.my.tcg.game.mate.card.textparser.effect.CardEffect;
import de.my.tcg.game.mate.card.textparser.effect.effect.executed.dmgeffect.AdditionalDmgEffectTerm;
import de.my.tcg.game.mate.card.textparser.effect.effect.executed.dmgeffect.addcondition.AddCondition;
import de.my.tcg.game.mate.card.textparser.effect.effect.executed.dmgeffect.addcondition.dmgcounter.AddByDmgCounter;
import de.my.tcg.game.mate.card.textparser.effect.effect.executed.dmgeffect.addcondition.energynotused.AddByEnergyNotUsed;
import de.my.tcg.game.mate.card.textparser.effect.effect.executed.dmgeffect.addcondition.energynotused.EnergyNotUsedLimitation;
import de.my.tcg.game.mate.card.textparser.effect.effect.target.Target;
import de.my.tcg.game.mate.card.textparser.utils.CardTextUtil;
import de.my.tcg.game.mate.card.textparser.utils.NumberParser;
import de.my.tcg.grammar.parser.interpreter.additionaldmg.AdditionalDmgParserBaseVisitor;
import de.my.tcg.grammar.parser.interpreter.additionaldmg.AdditionalDmgParserLexer;
import de.my.tcg.grammar.parser.interpreter.additionaldmg.AdditionalDmgParserParser;
import lombok.Getter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AdditionalDmgAttackEffectInterpreterAndPerformer extends AdditionalDmgParserBaseVisitor<Integer> implements Performer {
    private int dmg;
    @Getter
    private final List<CardEffect> terms = new ArrayList<>();
    private CardEffect currentTerm;
    private final PokemonCard thisPokemonCard;
    private final FieldSide thisFieldSide;
    private final PokemonCard defendingPokemonCard;
    private final FieldSide opponentSide;
    private final Attack attack;

    public AdditionalDmgAttackEffectInterpreterAndPerformer(Attack attack, FieldSide thisFieldSide, FieldSide opponentSide) {
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
        AdditionalDmgParserLexer lexer = new AdditionalDmgParserLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AdditionalDmgParserParser parser = new AdditionalDmgParserParser(tokens);
        ParseTree tree = parser.effectText();
        visit(tree);
    }


    private void calculateDmg() {
        if (getAdditionalDmgTermFromTermList() != null) {
            dmg = getAdditionalDmgTermFromTermList().getDmg();
        }
    }

    private AdditionalDmgEffectTerm getAdditionalDmgTermFromTermList() {
        Optional<CardEffect> cardEffect = terms.stream().filter(
                cf -> cf.getEffectTerm() instanceof AdditionalDmgEffectTerm).findFirst();
        return cardEffect.map(effect -> (AdditionalDmgEffectTerm) effect.getEffectTerm()).orElse(null);
    }

    @Override
    public Integer visitTerm(AdditionalDmgParserParser.TermContext ctx) {
        currentTerm = new CardEffect(ctx.getText());
        visitChildren(ctx);
        terms.add(currentTerm);
        return 0;
    }

    @Override
    public Integer visitDmgData(AdditionalDmgParserParser.DmgDataContext ctx) {
        visitChildren(ctx);
        int dmg = NumberParser.parseNumberOrStringToInteger(ctx.dmg.getText());
        int additionalDmg = NumberParser.parseNumberOrStringToInteger(ctx.additionalDmg.getText());
        AdditionalDmgEffectTerm dmgEffectTerm = new AdditionalDmgEffectTerm(dmg, additionalDmg);
        currentTerm.setEffectTerm(dmgEffectTerm);

        return 0;
    }

    @Override
    public Integer visitEnergyNotUsed(AdditionalDmgParserParser.EnergyNotUsedContext ctx) {
        visitChildren(ctx);
        PokeType energyType = PokeType.valueOf(ctx.type.getText());
        PokemonCard targetPokemonCard;
        switch (Target.getTargetByName(ctx.target.getText())) {
            case THIS_POKEMON, NO_TARGET -> targetPokemonCard = thisPokemonCard;
            case DEFENDING_POKEMON -> targetPokemonCard = defendingPokemonCard;
            default -> targetPokemonCard = thisPokemonCard;
        }
        AddByEnergyNotUsed energyNotUsed = new AddByEnergyNotUsed(attack, energyType);
        energyNotUsed.setTargedPokemon(targetPokemonCard);
        currentTerm.setEffectCondition(energyNotUsed);
        return 0;
    }

    @Override
    public Integer visitDmgCounter(AdditionalDmgParserParser.DmgCounterContext ctx) {
        visitChildren(ctx);
        PokemonCard targetPokemonCard;
        switch (Target.getTargetByName(ctx.target.getText())) {
            case THIS_POKEMON, NO_TARGET -> targetPokemonCard = thisPokemonCard;
            case DEFENDING_POKEMON -> targetPokemonCard = defendingPokemonCard;
            default -> targetPokemonCard = thisPokemonCard;
        }
        AddByDmgCounter dmgByCounter = new AddByDmgCounter(targetPokemonCard);
        currentTerm.setEffectCondition(dmgByCounter);
        return 0;
    }

    @Override
    public Integer visitLimitation(AdditionalDmgParserParser.LimitationContext ctx) {
        visitChildren(ctx);
        AdditionalDmgEffectTerm additionalDmgEffectTerm = (AdditionalDmgEffectTerm) currentTerm.getEffectTerm();
        int dmgPer = additionalDmgEffectTerm.getAdditionalDmg();
        int dmgLimit;
        if (ctx.energyAfter().energyAfter_Var1() != null) {
            int counter = NumberParser.parseNumberOrStringToInteger(ctx.energyAfter().energyAfter_Var1().LimitationCounter().getText());
            dmgLimit = counter * dmgPer;
        } else if (ctx.energyAfter().energyAfter_Var2() != null) {
            dmgLimit = NumberParser.parseNumberOrStringToInteger(ctx.energyAfter().energyAfter_Var2().dmgLimit.getText());
        } else {
            dmgLimit = 0;
        }
        EnergyNotUsedLimitation limitation = new EnergyNotUsedLimitation(dmgLimit, dmgPer);
        AddCondition addCondition = (AddCondition) currentTerm.getEffectCondition();
        addCondition.addLimitation(limitation);
        return 0;
    }

}
