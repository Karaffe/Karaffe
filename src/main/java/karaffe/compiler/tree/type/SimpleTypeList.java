/**
 * Karaffe Programming Language
 */
package karaffe.compiler.tree.type;

import java.util.Iterator;
import java.util.Optional;
import karaffe.compiler.tree.AbstractNode;
import karaffe.compiler.visitor.Visitor;

public class SimpleTypeList extends AbstractNode implements Iterator<SimpleTypeList> {

    private final SimpleType type;
    private final Optional<SimpleTypeList> typeList;

    public SimpleTypeList(Object t) {
        this(t, null);
    }

    public SimpleTypeList(Object t, Object l) {
        this.type = (SimpleType) t;
        this.typeList = Optional.ofNullable((SimpleTypeList) l);
        addChild(type);
        addChild(typeList);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.simpleTypeList(this);
    }

    public SimpleType first() {
        return type;
    }

    @Override
    public SimpleTypeList next() {
        return typeList.get();
    }

    @Override
    public boolean hasNext() {
        return typeList.isPresent();
    }

}
