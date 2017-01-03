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
	 * Enter a parse tree produced by {@link KaraffeParser#packageDecl}.
	 * @param ctx the parse tree
	 */
	void enterPackageDecl(KaraffeParser.PackageDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#packageDecl}.
	 * @param ctx the parse tree
	 */
	void exitPackageDecl(KaraffeParser.PackageDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#packagePath}.
	 * @param ctx the parse tree
	 */
	void enterPackagePath(KaraffeParser.PackagePathContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#packagePath}.
	 * @param ctx the parse tree
	 */
	void exitPackagePath(KaraffeParser.PackagePathContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#importDecl}.
	 * @param ctx the parse tree
	 */
	void enterImportDecl(KaraffeParser.ImportDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#importDecl}.
	 * @param ctx the parse tree
	 */
	void exitImportDecl(KaraffeParser.ImportDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#importPath}.
	 * @param ctx the parse tree
	 */
	void enterImportPath(KaraffeParser.ImportPathContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#importPath}.
	 * @param ctx the parse tree
	 */
	void exitImportPath(KaraffeParser.ImportPathContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#interfaceDecl}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceDecl(KaraffeParser.InterfaceDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#interfaceDecl}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceDecl(KaraffeParser.InterfaceDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#interfaceModifiers}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceModifiers(KaraffeParser.InterfaceModifiersContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#interfaceModifiers}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceModifiers(KaraffeParser.InterfaceModifiersContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#interfaceModifier}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceModifier(KaraffeParser.InterfaceModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#interfaceModifier}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceModifier(KaraffeParser.InterfaceModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBody(KaraffeParser.InterfaceBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBody(KaraffeParser.InterfaceBodyContext ctx);
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
	 * Enter a parse tree produced by {@link KaraffeParser#classModifiers}.
	 * @param ctx the parse tree
	 */
	void enterClassModifiers(KaraffeParser.ClassModifiersContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#classModifiers}.
	 * @param ctx the parse tree
	 */
	void exitClassModifiers(KaraffeParser.ClassModifiersContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#classModifier}.
	 * @param ctx the parse tree
	 */
	void enterClassModifier(KaraffeParser.ClassModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#classModifier}.
	 * @param ctx the parse tree
	 */
	void exitClassModifier(KaraffeParser.ClassModifierContext ctx);
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
	 * Enter a parse tree produced by {@link KaraffeParser#fieldModifiers}.
	 * @param ctx the parse tree
	 */
	void enterFieldModifiers(KaraffeParser.FieldModifiersContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#fieldModifiers}.
	 * @param ctx the parse tree
	 */
	void exitFieldModifiers(KaraffeParser.FieldModifiersContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#ctorDecl}.
	 * @param ctx the parse tree
	 */
	void enterCtorDecl(KaraffeParser.CtorDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#ctorDecl}.
	 * @param ctx the parse tree
	 */
	void exitCtorDecl(KaraffeParser.CtorDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#ctorBody}.
	 * @param ctx the parse tree
	 */
	void enterCtorBody(KaraffeParser.CtorBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#ctorBody}.
	 * @param ctx the parse tree
	 */
	void exitCtorBody(KaraffeParser.CtorBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#funcDecl}.
	 * @param ctx the parse tree
	 */
	void enterFuncDecl(KaraffeParser.FuncDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#funcDecl}.
	 * @param ctx the parse tree
	 */
	void exitFuncDecl(KaraffeParser.FuncDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#funcModifiers}.
	 * @param ctx the parse tree
	 */
	void enterFuncModifiers(KaraffeParser.FuncModifiersContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#funcModifiers}.
	 * @param ctx the parse tree
	 */
	void exitFuncModifiers(KaraffeParser.FuncModifiersContext ctx);
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
	 * Enter a parse tree produced by {@link KaraffeParser#methodName}.
	 * @param ctx the parse tree
	 */
	void enterMethodName(KaraffeParser.MethodNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#methodName}.
	 * @param ctx the parse tree
	 */
	void exitMethodName(KaraffeParser.MethodNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#methodVar}.
	 * @param ctx the parse tree
	 */
	void enterMethodVar(KaraffeParser.MethodVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#methodVar}.
	 * @param ctx the parse tree
	 */
	void exitMethodVar(KaraffeParser.MethodVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#methodVarRet}.
	 * @param ctx the parse tree
	 */
	void enterMethodVarRet(KaraffeParser.MethodVarRetContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#methodVarRet}.
	 * @param ctx the parse tree
	 */
	void exitMethodVarRet(KaraffeParser.MethodVarRetContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(KaraffeParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(KaraffeParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#parameterSet}.
	 * @param ctx the parse tree
	 */
	void enterParameterSet(KaraffeParser.ParameterSetContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#parameterSet}.
	 * @param ctx the parse tree
	 */
	void exitParameterSet(KaraffeParser.ParameterSetContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#parameterName}.
	 * @param ctx the parse tree
	 */
	void enterParameterName(KaraffeParser.ParameterNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#parameterName}.
	 * @param ctx the parse tree
	 */
	void exitParameterName(KaraffeParser.ParameterNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#parameterType}.
	 * @param ctx the parse tree
	 */
	void enterParameterType(KaraffeParser.ParameterTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#parameterType}.
	 * @param ctx the parse tree
	 */
	void exitParameterType(KaraffeParser.ParameterTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#returnType}.
	 * @param ctx the parse tree
	 */
	void enterReturnType(KaraffeParser.ReturnTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#returnType}.
	 * @param ctx the parse tree
	 */
	void exitReturnType(KaraffeParser.ReturnTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(KaraffeParser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(KaraffeParser.MethodBodyContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#prefixExpr}.
	 * @param ctx the parse tree
	 */
	void enterPrefixExpr(KaraffeParser.PrefixExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#prefixExpr}.
	 * @param ctx the parse tree
	 */
	void exitPrefixExpr(KaraffeParser.PrefixExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#binaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpr(KaraffeParser.BinaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#binaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpr(KaraffeParser.BinaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#assignExpr}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpr(KaraffeParser.AssignExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#assignExpr}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpr(KaraffeParser.AssignExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#assignHead}.
	 * @param ctx the parse tree
	 */
	void enterAssignHead(KaraffeParser.AssignHeadContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#assignHead}.
	 * @param ctx the parse tree
	 */
	void exitAssignHead(KaraffeParser.AssignHeadContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#target}.
	 * @param ctx the parse tree
	 */
	void enterTarget(KaraffeParser.TargetContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#target}.
	 * @param ctx the parse tree
	 */
	void exitTarget(KaraffeParser.TargetContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#condExpr}.
	 * @param ctx the parse tree
	 */
	void enterCondExpr(KaraffeParser.CondExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#condExpr}.
	 * @param ctx the parse tree
	 */
	void exitCondExpr(KaraffeParser.CondExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#castExpr}.
	 * @param ctx the parse tree
	 */
	void enterCastExpr(KaraffeParser.CastExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#castExpr}.
	 * @param ctx the parse tree
	 */
	void exitCastExpr(KaraffeParser.CastExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#postfixExpr}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpr(KaraffeParser.PostfixExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#postfixExpr}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpr(KaraffeParser.PostfixExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpr(KaraffeParser.PrimaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpr(KaraffeParser.PrimaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#identifierExpr}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpr(KaraffeParser.IdentifierExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#identifierExpr}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpr(KaraffeParser.IdentifierExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#literalExpr}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpr(KaraffeParser.LiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#literalExpr}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpr(KaraffeParser.LiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#superExpr}.
	 * @param ctx the parse tree
	 */
	void enterSuperExpr(KaraffeParser.SuperExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#superExpr}.
	 * @param ctx the parse tree
	 */
	void exitSuperExpr(KaraffeParser.SuperExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#superCtorExpr}.
	 * @param ctx the parse tree
	 */
	void enterSuperCtorExpr(KaraffeParser.SuperCtorExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#superCtorExpr}.
	 * @param ctx the parse tree
	 */
	void exitSuperCtorExpr(KaraffeParser.SuperCtorExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#superMethodExpr}.
	 * @param ctx the parse tree
	 */
	void enterSuperMethodExpr(KaraffeParser.SuperMethodExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#superMethodExpr}.
	 * @param ctx the parse tree
	 */
	void exitSuperMethodExpr(KaraffeParser.SuperMethodExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#thisExpr}.
	 * @param ctx the parse tree
	 */
	void enterThisExpr(KaraffeParser.ThisExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#thisExpr}.
	 * @param ctx the parse tree
	 */
	void exitThisExpr(KaraffeParser.ThisExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#lambdaExpr}.
	 * @param ctx the parse tree
	 */
	void enterLambdaExpr(KaraffeParser.LambdaExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#lambdaExpr}.
	 * @param ctx the parse tree
	 */
	void exitLambdaExpr(KaraffeParser.LambdaExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#lambdaHead}.
	 * @param ctx the parse tree
	 */
	void enterLambdaHead(KaraffeParser.LambdaHeadContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#lambdaHead}.
	 * @param ctx the parse tree
	 */
	void exitLambdaHead(KaraffeParser.LambdaHeadContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#lambdaParameters}.
	 * @param ctx the parse tree
	 */
	void enterLambdaParameters(KaraffeParser.LambdaParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#lambdaParameters}.
	 * @param ctx the parse tree
	 */
	void exitLambdaParameters(KaraffeParser.LambdaParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#lambdaParameter}.
	 * @param ctx the parse tree
	 */
	void enterLambdaParameter(KaraffeParser.LambdaParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#lambdaParameter}.
	 * @param ctx the parse tree
	 */
	void exitLambdaParameter(KaraffeParser.LambdaParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#varName}.
	 * @param ctx the parse tree
	 */
	void enterVarName(KaraffeParser.VarNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#varName}.
	 * @param ctx the parse tree
	 */
	void exitVarName(KaraffeParser.VarNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#lambdaBodyBlock}.
	 * @param ctx the parse tree
	 */
	void enterLambdaBodyBlock(KaraffeParser.LambdaBodyBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#lambdaBodyBlock}.
	 * @param ctx the parse tree
	 */
	void exitLambdaBodyBlock(KaraffeParser.LambdaBodyBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#implicitNewExpr}.
	 * @param ctx the parse tree
	 */
	void enterImplicitNewExpr(KaraffeParser.ImplicitNewExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#implicitNewExpr}.
	 * @param ctx the parse tree
	 */
	void exitImplicitNewExpr(KaraffeParser.ImplicitNewExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#wildCardExpr}.
	 * @param ctx the parse tree
	 */
	void enterWildCardExpr(KaraffeParser.WildCardExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#wildCardExpr}.
	 * @param ctx the parse tree
	 */
	void exitWildCardExpr(KaraffeParser.WildCardExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#lambdaBody}.
	 * @param ctx the parse tree
	 */
	void enterLambdaBody(KaraffeParser.LambdaBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#lambdaBody}.
	 * @param ctx the parse tree
	 */
	void exitLambdaBody(KaraffeParser.LambdaBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#intLiteral}.
	 * @param ctx the parse tree
	 */
	void enterIntLiteral(KaraffeParser.IntLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#intLiteral}.
	 * @param ctx the parse tree
	 */
	void exitIntLiteral(KaraffeParser.IntLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#floatingPointLiteral}.
	 * @param ctx the parse tree
	 */
	void enterFloatingPointLiteral(KaraffeParser.FloatingPointLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#floatingPointLiteral}.
	 * @param ctx the parse tree
	 */
	void exitFloatingPointLiteral(KaraffeParser.FloatingPointLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(KaraffeParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(KaraffeParser.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(KaraffeParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(KaraffeParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#rawStringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterRawStringLiteral(KaraffeParser.RawStringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#rawStringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitRawStringLiteral(KaraffeParser.RawStringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#tupleLiteral}.
	 * @param ctx the parse tree
	 */
	void enterTupleLiteral(KaraffeParser.TupleLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#tupleLiteral}.
	 * @param ctx the parse tree
	 */
	void exitTupleLiteral(KaraffeParser.TupleLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#mapLiteral}.
	 * @param ctx the parse tree
	 */
	void enterMapLiteral(KaraffeParser.MapLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#mapLiteral}.
	 * @param ctx the parse tree
	 */
	void exitMapLiteral(KaraffeParser.MapLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#mapLiteralBodyList}.
	 * @param ctx the parse tree
	 */
	void enterMapLiteralBodyList(KaraffeParser.MapLiteralBodyListContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#mapLiteralBodyList}.
	 * @param ctx the parse tree
	 */
	void exitMapLiteralBodyList(KaraffeParser.MapLiteralBodyListContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#mapLiteralBody}.
	 * @param ctx the parse tree
	 */
	void enterMapLiteralBody(KaraffeParser.MapLiteralBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#mapLiteralBody}.
	 * @param ctx the parse tree
	 */
	void exitMapLiteralBody(KaraffeParser.MapLiteralBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#mapKey}.
	 * @param ctx the parse tree
	 */
	void enterMapKey(KaraffeParser.MapKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#mapKey}.
	 * @param ctx the parse tree
	 */
	void exitMapKey(KaraffeParser.MapKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#mapValue}.
	 * @param ctx the parse tree
	 */
	void enterMapValue(KaraffeParser.MapValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#mapValue}.
	 * @param ctx the parse tree
	 */
	void exitMapValue(KaraffeParser.MapValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#listLiteral}.
	 * @param ctx the parse tree
	 */
	void enterListLiteral(KaraffeParser.ListLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#listLiteral}.
	 * @param ctx the parse tree
	 */
	void exitListLiteral(KaraffeParser.ListLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#nilLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNilLiteral(KaraffeParser.NilLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#nilLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNilLiteral(KaraffeParser.NilLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(KaraffeParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(KaraffeParser.ExprListContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(KaraffeParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(KaraffeParser.OpContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#prefixOp}.
	 * @param ctx the parse tree
	 */
	void enterPrefixOp(KaraffeParser.PrefixOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#prefixOp}.
	 * @param ctx the parse tree
	 */
	void exitPrefixOp(KaraffeParser.PrefixOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#infixOp}.
	 * @param ctx the parse tree
	 */
	void enterInfixOp(KaraffeParser.InfixOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#infixOp}.
	 * @param ctx the parse tree
	 */
	void exitInfixOp(KaraffeParser.InfixOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#postfixOp}.
	 * @param ctx the parse tree
	 */
	void enterPostfixOp(KaraffeParser.PostfixOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#postfixOp}.
	 * @param ctx the parse tree
	 */
	void exitPostfixOp(KaraffeParser.PostfixOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link KaraffeParser#modifier}.
	 * @param ctx the parse tree
	 */
	void enterModifier(KaraffeParser.ModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link KaraffeParser#modifier}.
	 * @param ctx the parse tree
	 */
	void exitModifier(KaraffeParser.ModifierContext ctx);
}