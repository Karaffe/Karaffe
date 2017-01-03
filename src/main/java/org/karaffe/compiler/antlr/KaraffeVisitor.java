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
	 * Visit a parse tree produced by {@link KaraffeParser#packageDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageDecl(KaraffeParser.PackageDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#packagePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackagePath(KaraffeParser.PackagePathContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#importDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDecl(KaraffeParser.ImportDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#importPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportPath(KaraffeParser.ImportPathContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#interfaceDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceDecl(KaraffeParser.InterfaceDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#interfaceModifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceModifiers(KaraffeParser.InterfaceModifiersContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#interfaceModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceModifier(KaraffeParser.InterfaceModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#interfaceBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceBody(KaraffeParser.InterfaceBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#classDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDecl(KaraffeParser.ClassDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#classModifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassModifiers(KaraffeParser.ClassModifiersContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#classModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassModifier(KaraffeParser.ClassModifierContext ctx);
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
	 * Visit a parse tree produced by {@link KaraffeParser#fieldModifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldModifiers(KaraffeParser.FieldModifiersContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#ctorDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtorDecl(KaraffeParser.CtorDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#ctorBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtorBody(KaraffeParser.CtorBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#funcDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDecl(KaraffeParser.FuncDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#funcModifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncModifiers(KaraffeParser.FuncModifiersContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#fieldName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldName(KaraffeParser.FieldNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#methodName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodName(KaraffeParser.MethodNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#methodVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodVar(KaraffeParser.MethodVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#methodVarRet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodVarRet(KaraffeParser.MethodVarRetContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(KaraffeParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#parameterSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterSet(KaraffeParser.ParameterSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#parameterName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterName(KaraffeParser.ParameterNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#parameterType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterType(KaraffeParser.ParameterTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#returnType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnType(KaraffeParser.ReturnTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#methodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodBody(KaraffeParser.MethodBodyContext ctx);
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
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#prefixExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixExpr(KaraffeParser.PrefixExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#binaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpr(KaraffeParser.BinaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#assignExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpr(KaraffeParser.AssignExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#assignHead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignHead(KaraffeParser.AssignHeadContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTarget(KaraffeParser.TargetContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#condExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondExpr(KaraffeParser.CondExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#castExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastExpr(KaraffeParser.CastExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#postfixExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpr(KaraffeParser.PostfixExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpr(KaraffeParser.PrimaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#identifierExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierExpr(KaraffeParser.IdentifierExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#literalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpr(KaraffeParser.LiteralExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#superExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuperExpr(KaraffeParser.SuperExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#superCtorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuperCtorExpr(KaraffeParser.SuperCtorExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#superMethodExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuperMethodExpr(KaraffeParser.SuperMethodExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#thisExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisExpr(KaraffeParser.ThisExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#lambdaExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaExpr(KaraffeParser.LambdaExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#lambdaHead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaHead(KaraffeParser.LambdaHeadContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#lambdaParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaParameters(KaraffeParser.LambdaParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#lambdaParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaParameter(KaraffeParser.LambdaParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#varName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarName(KaraffeParser.VarNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#lambdaBodyBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaBodyBlock(KaraffeParser.LambdaBodyBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#implicitNewExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplicitNewExpr(KaraffeParser.ImplicitNewExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#wildCardExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildCardExpr(KaraffeParser.WildCardExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#lambdaBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaBody(KaraffeParser.LambdaBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#intLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLiteral(KaraffeParser.IntLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#floatingPointLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatingPointLiteral(KaraffeParser.FloatingPointLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#booleanLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(KaraffeParser.BooleanLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#stringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(KaraffeParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#rawStringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRawStringLiteral(KaraffeParser.RawStringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#tupleLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTupleLiteral(KaraffeParser.TupleLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#mapLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapLiteral(KaraffeParser.MapLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#mapLiteralBodyList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapLiteralBodyList(KaraffeParser.MapLiteralBodyListContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#mapLiteralBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapLiteralBody(KaraffeParser.MapLiteralBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#mapKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapKey(KaraffeParser.MapKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#mapValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapValue(KaraffeParser.MapValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#listLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListLiteral(KaraffeParser.ListLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#nilLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNilLiteral(KaraffeParser.NilLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprList(KaraffeParser.ExprListContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp(KaraffeParser.OpContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#prefixOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixOp(KaraffeParser.PrefixOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#infixOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfixOp(KaraffeParser.InfixOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#postfixOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixOp(KaraffeParser.PostfixOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link KaraffeParser#modifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifier(KaraffeParser.ModifierContext ctx);
}