/**
 * Karaffe Programming Language
 */
package karaffe.compiler.tree.classdecls;

import karaffe.compiler.tree.AST;
import karaffe.compiler.tree.AbstractNode;
import karaffe.compiler.visitor.Visitor;

public class SuperTypeOrInterfaces extends AbstractNode {

    private final AST t;

        this.t = (AST) t;
    public SuperTypeOrInterfaces(Object t) {
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.extendsOrImplements(this);
    }
}
