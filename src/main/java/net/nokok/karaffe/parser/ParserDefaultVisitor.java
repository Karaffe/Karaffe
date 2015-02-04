/* Generated By:JavaCC: Do not edit this line. ParserDefaultVisitor.java Version 6.0_1 */
package net.nokok.karaffe.parser;

public class ParserDefaultVisitor implements ParserVisitor {

    public Object defaultVisit(SimpleNode node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        node.childrenAccept(this, data);
        return data;
    }

    public Object visit(SimpleNode node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTCompileUnit node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTPackageDecl node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTImportStmt node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTSimpleImport node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTStarImport node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTAliasImport node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTImportAfter node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTURLImport node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTTypeName node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTStatement node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTFuncAlias node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTFunctionName node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTPrivateImportStmt node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTPrivateImportBlock node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTAnnotation node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTClassDecl node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTClassModifiers node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTTypeParameters node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTTypeParameter node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTTypeBound node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTType node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTClassType node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTFuncType node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTAdditionalBound node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTSuperType node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTInterfaces node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTInterfaceType node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTClassBody node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTClassCtorDecl node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTCtorModifiers node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTFormalParameters node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTFormalParameter node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTLastFormalParamter node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTVarargs node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTVariableModifier node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTCtorBody node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTExplicitCtorInvocation node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTBlockStmts node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTBlockStmt node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTLocalValDecl node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTVariableInitializer node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTFieldDecl node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTFieldModifiers node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTFieldInitializer node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTFuncDecl node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTFuncModifiers node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTParenFormalParams node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTReturnType node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTFuncBody node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTAlgebraicDataTypeDecl node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTAlgebraicDataTypeBody node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTAlgebraicDataCtorBinding node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTInterfaceDecl node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTInterfaceModifier node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTExtendsInterfaces node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTInterfaceBody node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTInterfaceMember node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTConstantDecl node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTInterfaceMethodDecl node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTTypeAliasDecl node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTTypeAliasModifier node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTEnumDecl node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTEnumModifier node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTEnumName node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTEnumMembers node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTExpression node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTAssignmentExpr node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTAssignmentOp node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTLeftHandSide node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTBackwardPipelineExpr node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTPipelineExpr node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTExprNode node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTBoolOr node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTBoolAnd node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTEqualTo node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTNotEqualTo node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTLessThan node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTGreaterThan node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTLessThanEqTo node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTGreaterThanEqTo node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTClosedRange node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTHalfOpenRange node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTAdd node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTSub node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTSafeAdd node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTSafeSub node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTMul node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTDiv node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTRem node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTSafeMul node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTSafeDiv node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTSafeRem node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTUAdd node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTUSub node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTUBang node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTListDisplay node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTDictionaryDisplay node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTDictionaryPair node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTTupleDisplay node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTIfExpr node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTIfBody node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTSwitchExpr node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTSwitchCase node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTSwitchCond node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTSwitchGuard node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTCaseBody node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTWhileLoopExpr node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTWhileBody node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTMethodInvocation node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTParenArguments node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTMethodName node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTExpressionName node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTArguments node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTArgument node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTFunctionLiteral node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTFuncLiteralArg node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTFuncLiteralBody node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTIdentifierTypeBindings node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTIdentifierTypeBinding node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTAmbiguousName node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTDecimalIntLiteral node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTHexIntLiteral node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTOctIntLiteral node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTBinaryIntLiteral node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTFloatLiteral node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTDecimalFPLiteral node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTHexadecimalFPLiteral node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTBoolLiteral node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTCharLiteral node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTStringLiteral node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTUndefinedLiteral node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTNullLiteral node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTPublicModifier node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTProtectedModifier node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTPrivateModifier node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTAbstractModifier node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTStaticModifier node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTFinalModifier node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTSealedModifier node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTVarModifier node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTOverrideModifier node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTAutoModifier node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTIdentifier node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTThis node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }

    public Object visit(ASTSelf node, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {
        return defaultVisit(node, data);
    }
}
/* JavaCC - OriginalChecksum=cedc43b3b1839dc649122a44cefa6678 (do not edit this line) */
