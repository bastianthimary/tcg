// Generated from C:/Users/Bastian Binaris/IdeaProjects/Privat/Pokemon/tcg/src/main/resources/interpreter\EffectTextParser.g4 by ANTLR 4.12.0
package de.my.tcg.grammar.parser.interpreter;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link EffectTextParserParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface EffectTextParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link EffectTextParserParser#target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTarget(EffectTextParserParser.TargetContext ctx);
	/**
	 * Visit a parse tree produced by {@link EffectTextParserParser#benchTarget}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBenchTarget(EffectTextParserParser.BenchTargetContext ctx);
	/**
	 * Visit a parse tree produced by {@link EffectTextParserParser#statusCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatusCondition(EffectTextParserParser.StatusConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EffectTextParserParser#conditionTypes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionTypes(EffectTextParserParser.ConditionTypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link EffectTextParserParser#effectText}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEffectText(EffectTextParserParser.EffectTextContext ctx);
	/**
	 * Visit a parse tree produced by {@link EffectTextParserParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(EffectTextParserParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link EffectTextParserParser#conditionTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionTerm(EffectTextParserParser.ConditionTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link EffectTextParserParser#effectTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEffectTerm(EffectTextParserParser.EffectTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link EffectTextParserParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(EffectTextParserParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EffectTextParserParser#flipCoin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlipCoin(EffectTextParserParser.FlipCoinContext ctx);
	/**
	 * Visit a parse tree produced by {@link EffectTextParserParser#conditionClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionClass(EffectTextParserParser.ConditionClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link EffectTextParserParser#dmgEffect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDmgEffect(EffectTextParserParser.DmgEffectContext ctx);
	/**
	 * Visit a parse tree produced by {@link EffectTextParserParser#multipleDmgEffect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultipleDmgEffect(EffectTextParserParser.MultipleDmgEffectContext ctx);
	/**
	 * Visit a parse tree produced by {@link EffectTextParserParser#doNothing}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoNothing(EffectTextParserParser.DoNothingContext ctx);
	/**
	 * Visit a parse tree produced by {@link EffectTextParserParser#basicEffect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicEffect(EffectTextParserParser.BasicEffectContext ctx);
	/**
	 * Visit a parse tree produced by {@link EffectTextParserParser#executedEffect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecutedEffect(EffectTextParserParser.ExecutedEffectContext ctx);
	/**
	 * Visit a parse tree produced by {@link EffectTextParserParser#hurtEffect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHurtEffect(EffectTextParserParser.HurtEffectContext ctx);
	/**
	 * Visit a parse tree produced by {@link EffectTextParserParser#statusEffect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatusEffect(EffectTextParserParser.StatusEffectContext ctx);
	/**
	 * Visit a parse tree produced by {@link EffectTextParserParser#discardEnergy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiscardEnergy(EffectTextParserParser.DiscardEnergyContext ctx);
	/**
	 * Visit a parse tree produced by {@link EffectTextParserParser#benchDmgEffect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBenchDmgEffect(EffectTextParserParser.BenchDmgEffectContext ctx);
	/**
	 * Visit a parse tree produced by {@link EffectTextParserParser#prevent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrevent(EffectTextParserParser.PreventContext ctx);
	/**
	 * Visit a parse tree produced by {@link EffectTextParserParser#preventAllDmg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreventAllDmg(EffectTextParserParser.PreventAllDmgContext ctx);
	/**
	 * Visit a parse tree produced by {@link EffectTextParserParser#preventEffectAndDmg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreventEffectAndDmg(EffectTextParserParser.PreventEffectAndDmgContext ctx);
	/**
	 * Visit a parse tree produced by {@link EffectTextParserParser#preventDmgReduction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreventDmgReduction(EffectTextParserParser.PreventDmgReductionContext ctx);

	/**
	 * Visit a parse tree produced by {@link EffectTextParserParser#preventRetreat}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreventRetreat(EffectTextParserParser.PreventRetreatContext ctx);

	/**
	 * Visit a parse tree produced by {@link EffectTextParserParser#draw}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDraw(EffectTextParserParser.DrawContext ctx);
}