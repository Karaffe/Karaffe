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
	 * Enter a parse tree produced by {@link KaraffeParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(KaraffeParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(KaraffeParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void enterClassDecl(KaraffeParser.ClassDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void exitClassDecl(KaraffeParser.ClassDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#classBodyBlock}.
	 * @param ctx the parse tree
	 */
	void enterClassBodyBlock(KaraffeParser.ClassBodyBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#classBodyBlock}.
	 * @param ctx the parse tree
	 */
	void exitClassBodyBlock(KaraffeParser.ClassBodyBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(KaraffeParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(KaraffeParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#className}.
	 * @param ctx the parse tree
	 */
	void enterClassName(KaraffeParser.ClassNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#className}.
	 * @param ctx the parse tree
	 */
	void exitClassName(KaraffeParser.ClassNameContext ctx);
}