// Generated from C:/Users/Bastian Binaris/IdeaProjects/Privat/Pokemon/tcg/src/main/resources/interpreter\MultiplyDmgParser.g4 by ANTLR 4.12.0
package interpreter;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MultiplyDmgParserParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface MultiplyDmgParserVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link MultiplyDmgParserParser#doDmgPerTime}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDoDmgPerTime(MultiplyDmgParserParser.DoDmgPerTimeContext ctx);

    /**
     * Visit a parse tree produced by {@link MultiplyDmgParserParser#flip_coin}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFlip_coin(MultiplyDmgParserParser.Flip_coinContext ctx);

    /**
     * Visit a parse tree produced by {@link MultiplyDmgParserParser#dmg_condition}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDmg_condition(MultiplyDmgParserParser.Dmg_conditionContext ctx);
}