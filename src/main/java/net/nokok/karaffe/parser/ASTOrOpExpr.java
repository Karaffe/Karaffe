/* Generated By:JJTree: Do not edit this line. ASTOrOpExpr.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package net.nokok.karaffe.parser;

public
class ASTOrOpExpr extends SimpleNode {
  public ASTOrOpExpr(int id) {
    super(id);
  }

  public ASTOrOpExpr(KaraffeParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(KaraffeParserVisitor visitor, Object data) throws net.nokok.karaffe.parser.excptn.KaraffeParserException {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=a97f56f278ba14925bb36c306c3e80b6 (do not edit this line) */
