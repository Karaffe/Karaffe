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
	 * Visit a parse tree produced by {@link KaraffeParser#compileUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompileUnit(KaraffeParser.CompileUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(KaraffeParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#classDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDecl(KaraffeParser.ClassDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#superOrInterfaceList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuperOrInterfaceList(KaraffeParser.SuperOrInterfaceListContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#classBodyBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBodyBlock(KaraffeParser.ClassBodyBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(KaraffeParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#className}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassName(KaraffeParser.ClassNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#fieldDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDecl(KaraffeParser.FieldDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#fieldName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldName(KaraffeParser.FieldNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#fieldType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldType(KaraffeParser.FieldTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#fieldInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldInitializer(KaraffeParser.FieldInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(KaraffeParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(KaraffeParser.ExprContext ctx);
}