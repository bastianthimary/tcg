// Generated from C:/Users/Bastian Binaris/IdeaProjects/Privat/Pokemon/tcg/src/main/resources/interpreter\AdditionalDmgParser.g4 by ANTLR 4.12.0
package de.my.tcg.grammar.parser.interpreter.additionaldmg;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AdditionalDmgParserParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface AdditionalDmgParserVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link AdditionalDmgParserParser#effectText}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEffectText(AdditionalDmgParserParser.EffectTextContext ctx);

    /**
     * Visit a parse tree produced by {@link AdditionalDmgParserParser#term}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTerm(AdditionalDmgParserParser.TermContext ctx);

    /**
     * Visit a parse tree produced by {@link AdditionalDmgParserParser#additionalDmgEffect}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAdditionalDmgEffect(AdditionalDmgParserParser.AdditionalDmgEffectContext ctx);

    /**
     * Visit a parse tree produced by {@link AdditionalDmgParserParser#dmgData}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDmgData(AdditionalDmgParserParser.DmgDataContext ctx);

    /**
     * Visit a parse tree produced by {@link AdditionalDmgParserParser#condition}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCondition(AdditionalDmgParserParser.ConditionContext ctx);

    /**
     * Visit a parse tree produced by {@link AdditionalDmgParserParser#energyNotUsed}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEnergyNotUsed(AdditionalDmgParserParser.EnergyNotUsedContext ctx);

    /**
     * Visit a parse tree produced by {@link AdditionalDmgParserParser#dmgCounter}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDmgCounter(AdditionalDmgParserParser.DmgCounterContext ctx);

    /**
     * Visit a parse tree produced by {@link AdditionalDmgParserParser#limitation}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLimitation(AdditionalDmgParserParser.LimitationContext ctx);

    /**
     * Visit a parse tree produced by {@link AdditionalDmgParserParser#energyAfter}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEnergyAfter(AdditionalDmgParserParser.EnergyAfterContext ctx);

    /**
     * Visit a parse tree produced by {@link AdditionalDmgParserParser#energyAfter_Var1}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEnergyAfter_Var1(AdditionalDmgParserParser.EnergyAfter_Var1Context ctx);

    /**
     * Visit a parse tree produced by {@link AdditionalDmgParserParser#energyAfter_Var2}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEnergyAfter_Var2(AdditionalDmgParserParser.EnergyAfter_Var2Context ctx);

    /**
     * Visit a parse tree produced by {@link AdditionalDmgParserParser#coinFlipEffect}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCoinFlipEffect(AdditionalDmgParserParser.CoinFlipEffectContext ctx);

    /**
     * Visit a parse tree produced by {@link AdditionalDmgParserParser#flipCoin}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFlipCoin(AdditionalDmgParserParser.FlipCoinContext ctx);

    /**
     * Visit a parse tree produced by {@link AdditionalDmgParserParser#conditionClass}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitConditionClass(AdditionalDmgParserParser.ConditionClassContext ctx);

    /**
     * Visit a parse tree produced by {@link AdditionalDmgParserParser#attackIfDoes}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAttackIfDoes(AdditionalDmgParserParser.AttackIfDoesContext ctx);

    /**
     * Visit a parse tree produced by {@link AdditionalDmgParserParser#attackElseDoes}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAttackElseDoes(AdditionalDmgParserParser.AttackElseDoesContext ctx);

    /**
     * Visit a parse tree produced by {@link AdditionalDmgParserParser#pokemonStatusCondition}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitPokemonStatusCondition(AdditionalDmgParserParser.PokemonStatusConditionContext ctx);
}