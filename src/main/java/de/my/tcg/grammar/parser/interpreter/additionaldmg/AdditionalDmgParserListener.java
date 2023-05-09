// Generated from C:/Users/Bastian Binaris/IdeaProjects/Privat/Pokemon/tcg/src/main/resources/interpreter\AdditionalDmgParser.g4 by ANTLR 4.12.0
package de.my.tcg.grammar.parser.interpreter.additionaldmg;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AdditionalDmgParserParser}.
 */
public interface AdditionalDmgParserListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link AdditionalDmgParserParser#effectText}.
     *
     * @param ctx the parse tree
     */
    void enterEffectText(AdditionalDmgParserParser.EffectTextContext ctx);

    /**
     * Exit a parse tree produced by {@link AdditionalDmgParserParser#effectText}.
     *
     * @param ctx the parse tree
     */
    void exitEffectText(AdditionalDmgParserParser.EffectTextContext ctx);

    /**
     * Enter a parse tree produced by {@link AdditionalDmgParserParser#term}.
     *
     * @param ctx the parse tree
     */
    void enterTerm(AdditionalDmgParserParser.TermContext ctx);

    /**
     * Exit a parse tree produced by {@link AdditionalDmgParserParser#term}.
     *
     * @param ctx the parse tree
     */
    void exitTerm(AdditionalDmgParserParser.TermContext ctx);

    /**
     * Enter a parse tree produced by {@link AdditionalDmgParserParser#additionalDmgEffect}.
     *
     * @param ctx the parse tree
     */
    void enterAdditionalDmgEffect(AdditionalDmgParserParser.AdditionalDmgEffectContext ctx);

    /**
     * Exit a parse tree produced by {@link AdditionalDmgParserParser#additionalDmgEffect}.
     *
     * @param ctx the parse tree
     */
    void exitAdditionalDmgEffect(AdditionalDmgParserParser.AdditionalDmgEffectContext ctx);

    /**
     * Enter a parse tree produced by {@link AdditionalDmgParserParser#dmgData}.
     *
     * @param ctx the parse tree
     */
    void enterDmgData(AdditionalDmgParserParser.DmgDataContext ctx);

    /**
     * Exit a parse tree produced by {@link AdditionalDmgParserParser#dmgData}.
     *
     * @param ctx the parse tree
     */
    void exitDmgData(AdditionalDmgParserParser.DmgDataContext ctx);

    /**
     * Enter a parse tree produced by {@link AdditionalDmgParserParser#condition}.
     *
     * @param ctx the parse tree
     */
    void enterCondition(AdditionalDmgParserParser.ConditionContext ctx);

    /**
     * Exit a parse tree produced by {@link AdditionalDmgParserParser#condition}.
     *
     * @param ctx the parse tree
     */
    void exitCondition(AdditionalDmgParserParser.ConditionContext ctx);

    /**
     * Enter a parse tree produced by {@link AdditionalDmgParserParser#energyNotUsed}.
     *
     * @param ctx the parse tree
     */
    void enterEnergyNotUsed(AdditionalDmgParserParser.EnergyNotUsedContext ctx);

    /**
     * Exit a parse tree produced by {@link AdditionalDmgParserParser#energyNotUsed}.
     *
     * @param ctx the parse tree
     */
    void exitEnergyNotUsed(AdditionalDmgParserParser.EnergyNotUsedContext ctx);

    /**
     * Enter a parse tree produced by {@link AdditionalDmgParserParser#dmgCounter}.
     *
     * @param ctx the parse tree
     */
    void enterDmgCounter(AdditionalDmgParserParser.DmgCounterContext ctx);

    /**
     * Exit a parse tree produced by {@link AdditionalDmgParserParser#dmgCounter}.
     *
     * @param ctx the parse tree
     */
    void exitDmgCounter(AdditionalDmgParserParser.DmgCounterContext ctx);

    /**
     * Enter a parse tree produced by {@link AdditionalDmgParserParser#limitation}.
     *
     * @param ctx the parse tree
     */
    void enterLimitation(AdditionalDmgParserParser.LimitationContext ctx);

    /**
     * Exit a parse tree produced by {@link AdditionalDmgParserParser#limitation}.
     *
     * @param ctx the parse tree
     */
    void exitLimitation(AdditionalDmgParserParser.LimitationContext ctx);

    /**
     * Enter a parse tree produced by {@link AdditionalDmgParserParser#energyAfter}.
     *
     * @param ctx the parse tree
     */
    void enterEnergyAfter(AdditionalDmgParserParser.EnergyAfterContext ctx);

    /**
     * Exit a parse tree produced by {@link AdditionalDmgParserParser#energyAfter}.
     *
     * @param ctx the parse tree
     */
    void exitEnergyAfter(AdditionalDmgParserParser.EnergyAfterContext ctx);

    /**
     * Enter a parse tree produced by {@link AdditionalDmgParserParser#energyAfter_Var1}.
     *
     * @param ctx the parse tree
     */
    void enterEnergyAfter_Var1(AdditionalDmgParserParser.EnergyAfter_Var1Context ctx);

    /**
     * Exit a parse tree produced by {@link AdditionalDmgParserParser#energyAfter_Var1}.
     *
     * @param ctx the parse tree
     */
    void exitEnergyAfter_Var1(AdditionalDmgParserParser.EnergyAfter_Var1Context ctx);

    /**
     * Enter a parse tree produced by {@link AdditionalDmgParserParser#energyAfter_Var2}.
     *
     * @param ctx the parse tree
     */
    void enterEnergyAfter_Var2(AdditionalDmgParserParser.EnergyAfter_Var2Context ctx);

    /**
     * Exit a parse tree produced by {@link AdditionalDmgParserParser#energyAfter_Var2}.
     *
     * @param ctx the parse tree
     */
    void exitEnergyAfter_Var2(AdditionalDmgParserParser.EnergyAfter_Var2Context ctx);

    /**
     * Enter a parse tree produced by {@link AdditionalDmgParserParser#pokemonStatusCondition}.
     *
     * @param ctx the parse tree
     */
    void enterPokemonStatusCondition(AdditionalDmgParserParser.PokemonStatusConditionContext ctx);

    /**
     * Exit a parse tree produced by {@link AdditionalDmgParserParser#pokemonStatusCondition}.
     *
     * @param ctx the parse tree
     */
    void exitPokemonStatusCondition(AdditionalDmgParserParser.PokemonStatusConditionContext ctx);
}