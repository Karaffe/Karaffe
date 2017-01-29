// Generated from Karaffe.g4 by ANTLR 4.5.3
package org.karaffe.compiler.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link KaraffeParser}.
 */
public interface KaraffeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#compileUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompileUnit(KaraffeParser.CompileUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#compileUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompileUnit(KaraffeParser.CompileUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#topLevel}.
	 * @param ctx the parse tree
	 */
	void enterTopLevel(KaraffeParser.TopLevelContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#topLevel}.
	 * @param ctx the parse tree
	 */
	void exitTopLevel(KaraffeParser.TopLevelContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(KaraffeParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(KaraffeParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#assertStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssertStmt(KaraffeParser.AssertStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#assertStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssertStmt(KaraffeParser.AssertStmtContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(KaraffeParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(KaraffeParser.LiteralContext ctx);
}