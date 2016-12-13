// Generated from Karaffe.g4 by ANTLR 4.5.3
package org.karaffe.compiler.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link KaraffeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface KaraffeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(KaraffeParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(KaraffeParser.ExprContext ctx);
}