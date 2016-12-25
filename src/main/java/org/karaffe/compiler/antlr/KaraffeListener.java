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
	 * Enter a parse tree produced by {@link KaraffeParser#superOrInterfaceList}.
	 * @param ctx the parse tree
	 */
	void enterSuperOrInterfaceList(KaraffeParser.SuperOrInterfaceListContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#superOrInterfaceList}.
	 * @param ctx the parse tree
	 */
	void exitSuperOrInterfaceList(KaraffeParser.SuperOrInterfaceListContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void enterFieldDecl(KaraffeParser.FieldDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void exitFieldDecl(KaraffeParser.FieldDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void enterFieldName(KaraffeParser.FieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void exitFieldName(KaraffeParser.FieldNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#fieldType}.
	 * @param ctx the parse tree
	 */
	void enterFieldType(KaraffeParser.FieldTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#fieldType}.
	 * @param ctx the parse tree
	 */
	void exitFieldType(KaraffeParser.FieldTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#fieldInitializer}.
	 * @param ctx the parse tree
	 */
	void enterFieldInitializer(KaraffeParser.FieldInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#fieldInitializer}.
	 * @param ctx the parse tree
	 */
	void exitFieldInitializer(KaraffeParser.FieldInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(KaraffeParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(KaraffeParser.TypeContext ctx);
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