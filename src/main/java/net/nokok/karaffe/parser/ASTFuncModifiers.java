/* Generated By:JJTree: Do not edit this line. ASTFuncModifiers.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package net.nokok.karaffe.parser;

public class ASTFuncModifiers extends SimpleNode {

    public ASTFuncModifiers(int id) {
        super(id);
    }

    public ASTFuncModifiers(Parser p, int id) {
        super(p, id);
    }

    /** Accept the visitor. * */
    public Object jjtAccept(ParserVisitor visitor, Object data) throws net.nokok.karaffe.parser.excptn.ParserException {

        return visitor.visit(this, data);
    }
}
/* JavaCC - OriginalChecksum=c10786a0c3d77d45ea5a39bab6917e80 (do not edit this line) */
