/* Generated By:JJTree: Do not edit this line. ASTHalfOpenRange.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package net.nokok.karaffe.parser;

public class ASTHalfOpenRange extends SimpleNode {

    public ASTHalfOpenRange(int id) {
        super(id);
    }

    public ASTHalfOpenRange(Parser p, int id) {
        super(p, id);
    }

    /** Accept the visitor. * */
    public Object jjtAccept(ParserVisitor visitor, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {

        return visitor.visit(this, data);
    }
}
/* JavaCC - OriginalChecksum=edeb0428a7d26921ac2c776814b27226 (do not edit this line) */
