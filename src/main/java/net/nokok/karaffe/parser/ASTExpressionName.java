/* Generated By:JJTree: Do not edit this line. ASTExpressionName.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package net.nokok.karaffe.parser;

public class ASTExpressionName extends SimpleNode {

    public ASTExpressionName(int id) {
        super(id);
    }

    public ASTExpressionName(Parser p, int id) {
        super(p, id);
    }

    /** Accept the visitor. * */
    public Object jjtAccept(ParserVisitor visitor, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {

        return visitor.visit(this, data);
    }
}
/* JavaCC - OriginalChecksum=da6620d36acea068944cce60dd12ecba (do not edit this line) */
