package de.my.tcg.game.mate.card.textparser.interpreter;

import de.my.tcg.basedata.Attack;
import de.my.tcg.game.mate.FieldSide;
import de.my.tcg.game.mate.card.PokemonCard;
import de.my.tcg.game.mate.card.textparser.effect.CardEffect;
import de.my.tcg.game.mate.card.textparser.effect.effect.executed.dmgeffect.AdditionalDmgEffectTerm;
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

public class AdditionalDmgAttackEffectInterpreterAndPerformer extends AdditionalDmgParserBaseVisitor<Integer> {
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
        opponentSide.getActiveMon().doSimpleDmg(dmg);
    }

    private void parseTextAndPerformEffect() {
        String normalizedString = normalizeString(attack.getText());
        CharStream inputStream = CharStreams.fromString(normalizedString);
        AdditionalDmgParserLexer lexer = new AdditionalDmgParserLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AdditionalDmgParserParser parser = new AdditionalDmgParserParser(tokens);
        ParseTree tree = parser.effectText();
        visit(tree);
    }

    private String normalizeString(String parseString) {
        if (parseString.contains(thisPokemonCard.getName())) {
            return parseString.replace(thisPokemonCard.getName(), "this Pokemon");
        }
        return parseString;
    }

    private void calculateDmg() {
        String dmgAsString = attack.getDamage();
        if (dmgAsString.contains("/+")) {
            dmg = getAdditionalDmgTermFromTermList().getDmg();
        } else {

        }
    }

    private AdditionalDmgEffectTerm getAdditionalDmgTermFromTermList() {
        Optional<CardEffect> cardEffect = terms.stream().filter(
                cf -> cf.getEffectTerm() instanceof AdditionalDmgEffectTerm).findFirst();
        return (AdditionalDmgEffectTerm) cardEffect.get().getEffectTerm();
    }
}
