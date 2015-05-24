/**
 * Karaffe Programming Language
 */
package karaffe.compiler.tree.classdecls;

import karaffe.compiler.tree.AbstractNode;
import karaffe.compiler.tree.type.SimpleType;
import karaffe.compiler.tree.type.SimpleTypeList;
import karaffe.compiler.visitor.Visitor;

public class SuperTypeOrInterfaces extends AbstractNode {

    private final SimpleTypeList t;

    public SuperTypeOrInterfaces(Object t) {
        this.t = (SimpleTypeList) t;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.extendsOrImplements(this);
    }
}
