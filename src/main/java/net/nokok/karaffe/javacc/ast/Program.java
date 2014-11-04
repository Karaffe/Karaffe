package net.nokok.karaffe.javacc.ast;

public class Program implements ASTNode {

    @Override
    public Object accept(ASTVisitor visitor) {
        return visitor.onProgram(this);
    }

    @Override
    public String nodeIdentifier() {
        return "Program";
    }

    @Override
    public String toString() {
        return "Program";
    }

}
