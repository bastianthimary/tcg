// Generated from C:/Users/Bastian Binaris/IdeaProjects/Privat/Pokemon/tcg/src/main/resources/interpreter\EffectTextParser.g4 by ANTLR 4.12.0
package de.my.tcg.grammar.parser.interpreter;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EffectTextParserParser}.
 */
public interface EffectTextParserListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link EffectTextParserParser#effectText}.
     *
     * @param ctx the parse tree
     */
    void enterEffectText(EffectTextParserParser.EffectTextContext ctx);

    /**
     * Exit a parse tree produced by {@link EffectTextParserParser#effectText}.
     *
     * @param ctx the parse tree
     */
    void exitEffectText(EffectTextParserParser.EffectTextContext ctx);

    /**
     * Enter a parse tree produced by {@link EffectTextParserParser#term}.
     *
     * @param ctx the parse tree
     */
    void enterTerm(EffectTextParserParser.TermContext ctx);

    /**
     * Exit a parse tree produced by {@link EffectTextParserParser#term}.
     *
     * @param ctx the parse tree
     */
    void exitTerm(EffectTextParserParser.TermContext ctx);

    /**
     * Enter a parse tree produced by {@link EffectTextParserParser#conditionTerm}.
     *
     * @param ctx the parse tree
     */
    void enterConditionTerm(EffectTextParserParser.ConditionTermContext ctx);

    /**
     * Exit a parse tree produced by {@link EffectTextParserParser#conditionTerm}.
     *
     * @param ctx the parse tree
     */
    void exitConditionTerm(EffectTextParserParser.ConditionTermContext ctx);

    /**
     * Enter a parse tree produced by {@link EffectTextParserParser#effectTerm}.
     *
     * @param ctx the parse tree
     */
    void enterEffectTerm(EffectTextParserParser.EffectTermContext ctx);

    /**
     * Exit a parse tree produced by {@link EffectTextParserParser#effectTerm}.
     *
     * @param ctx the parse tree
     */
    void exitEffectTerm(EffectTextParserParser.EffectTermContext ctx);

    /**
     * Enter a parse tree produced by {@link EffectTextParserParser#condition}.
     *
     * @param ctx the parse tree
     */
    void enterCondition(EffectTextParserParser.ConditionContext ctx);

    /**
     * Exit a parse tree produced by {@link EffectTextParserParser#condition}.
     *
     * @param ctx the parse tree
     */
    void exitCondition(EffectTextParserParser.ConditionContext ctx);

    /**
     * Enter a parse tree produced by {@link EffectTextParserParser#flipCoin}.
     *
     * @param ctx the parse tree
     */
    void enterFlipCoin(EffectTextParserParser.FlipCoinContext ctx);

    /**
     * Exit a parse tree produced by {@link EffectTextParserParser#flipCoin}.
     *
     * @param ctx the parse tree
     */
    void exitFlipCoin(EffectTextParserParser.FlipCoinContext ctx);

    /**
     * Enter a parse tree produced by {@link EffectTextParserParser#conditionClass}.
     *
     * @param ctx the parse tree
     */
    void enterConditionClass(EffectTextParserParser.ConditionClassContext ctx);

    /**
     * Exit a parse tree produced by {@link EffectTextParserParser#conditionClass}.
     *
     * @param ctx the parse tree
     */
    void exitConditionClass(EffectTextParserParser.ConditionClassContext ctx);

    /**
     * Enter a parse tree produced by {@link EffectTextParserParser#conditionTypes}.
     *
     * @param ctx the parse tree
     */
    void enterConditionTypes(EffectTextParserParser.ConditionTypesContext ctx);

    /**
     * Exit a parse tree produced by {@link EffectTextParserParser#conditionTypes}.
     *
     * @param ctx the parse tree
     */
    void exitConditionTypes(EffectTextParserParser.ConditionTypesContext ctx);

    /**
     * Enter a parse tree produced by {@link EffectTextParserParser#dmgEffect}.
     *
     * @param ctx the parse tree
     */
    void enterDmgEffect(EffectTextParserParser.DmgEffectContext ctx);

    /**
     * Exit a parse tree produced by {@link EffectTextParserParser#dmgEffect}.
     *
     * @param ctx the parse tree
     */
    void exitDmgEffect(EffectTextParserParser.DmgEffectContext ctx);

    /**
     * Enter a parse tree produced by {@link EffectTextParserParser#multipleDmgEffect}.
     *
     * @param ctx the parse tree
     */
    void enterMultipleDmgEffect(EffectTextParserParser.MultipleDmgEffectContext ctx);

    /**
     * Exit a parse tree produced by {@link EffectTextParserParser#multipleDmgEffect}.
     *
     * @param ctx the parse tree
     */
    void exitMultipleDmgEffect(EffectTextParserParser.MultipleDmgEffectContext ctx);

    /**
     * Enter a parse tree produced by {@link EffectTextParserParser#basicEffect}.
     *
     * @param ctx the parse tree
     */
    void enterBasicEffect(EffectTextParserParser.BasicEffectContext ctx);

    /**
     * Exit a parse tree produced by {@link EffectTextParserParser#basicEffect}.
     *
     * @param ctx the parse tree
     */
    void exitBasicEffect(EffectTextParserParser.BasicEffectContext ctx);

    /**
     * Enter a parse tree produced by {@link EffectTextParserParser#target}.
     *
     * @param ctx the parse tree
     */
    void enterTarget(EffectTextParserParser.TargetContext ctx);

    /**
     * Exit a parse tree produced by {@link EffectTextParserParser#target}.
     *
     * @param ctx the parse tree
     */
    void exitTarget(EffectTextParserParser.TargetContext ctx);

    /**
     * Enter a parse tree produced by {@link EffectTextParserParser#varPokemonName}.
     *
     * @param ctx the parse tree
     */
    void enterVarPokemonName(EffectTextParserParser.VarPokemonNameContext ctx);

    /**
     * Exit a parse tree produced by {@link EffectTextParserParser#varPokemonName}.
     *
     * @param ctx the parse tree
     */
    void exitVarPokemonName(EffectTextParserParser.VarPokemonNameContext ctx);

    /**
     * Enter a parse tree produced by {@link EffectTextParserParser#defendingPokemon}.
     *
     * @param ctx the parse tree
     */
    void enterDefendingPokemon(EffectTextParserParser.DefendingPokemonContext ctx);

    /**
     * Exit a parse tree produced by {@link EffectTextParserParser#defendingPokemon}.
     *
     * @param ctx the parse tree
     */
    void exitDefendingPokemon(EffectTextParserParser.DefendingPokemonContext ctx);

    /**
     * Enter a parse tree produced by {@link EffectTextParserParser#executedEffect}.
     *
     * @param ctx the parse tree
     */
    void enterExecutedEffect(EffectTextParserParser.ExecutedEffectContext ctx);

    /**
     * Exit a parse tree produced by {@link EffectTextParserParser#executedEffect}.
     *
     * @param ctx the parse tree
     */
    void exitExecutedEffect(EffectTextParserParser.ExecutedEffectContext ctx);

    /**
     * Enter a parse tree produced by {@link EffectTextParserParser#hurtEffect}.
     *
     * @param ctx the parse tree
     */
    void enterHurtEffect(EffectTextParserParser.HurtEffectContext ctx);

    /**
     * Exit a parse tree produced by {@link EffectTextParserParser#hurtEffect}.
     *
     * @param ctx the parse tree
     */
    void exitHurtEffect(EffectTextParserParser.HurtEffectContext ctx);

    /**
     * Enter a parse tree produced by {@link EffectTextParserParser#statusEffect}.
     *
     * @param ctx the parse tree
     */
    void enterStatusEffect(EffectTextParserParser.StatusEffectContext ctx);

    /**
     * Exit a parse tree produced by {@link EffectTextParserParser#statusEffect}.
     *
     * @param ctx the parse tree
     */
    void exitStatusEffect(EffectTextParserParser.StatusEffectContext ctx);

    /**
     * Enter a parse tree produced by {@link EffectTextParserParser#statusCondition}.
     *
     * @param ctx the parse tree
     */
    void enterStatusCondition(EffectTextParserParser.StatusConditionContext ctx);

    /**
     * Exit a parse tree produced by {@link EffectTextParserParser#statusCondition}.
     *
     * @param ctx the parse tree
     */
    void exitStatusCondition(EffectTextParserParser.StatusConditionContext ctx);

    /**
     * Enter a parse tree produced by {@link EffectTextParserParser#discardEnergy}.
     *
     * @param ctx the parse tree
     */
    void enterDiscardEnergy(EffectTextParserParser.DiscardEnergyContext ctx);

    /**
     * Exit a parse tree produced by {@link EffectTextParserParser#discardEnergy}.
     *
     * @param ctx the parse tree
     */
    void exitDiscardEnergy(EffectTextParserParser.DiscardEnergyContext ctx);
}