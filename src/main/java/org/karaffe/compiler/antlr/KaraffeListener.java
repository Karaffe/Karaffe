// Generated from Karaffe.g4 by ANTLR 4.5.3
package org.karaffe.compiler.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link KaraffeParser}.
 */
public interface KaraffeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(KaraffeParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(KaraffeParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(KaraffeParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(KaraffeParser.ExprContext ctx);
}