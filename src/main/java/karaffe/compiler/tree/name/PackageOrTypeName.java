/**
 * Karaffe Programming Language
 */
package karaffe.compiler.tree.name;

import karaffe.compiler.tree.AbstractNode;
import karaffe.compiler.visitor.Visitor;

public class PackageOrTypeName extends AbstractNode {

    private final AmbiguousName name;

    public PackageOrTypeName(Object name) {
        this.name = (AmbiguousName) name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.packageOrTypeName(this);
    }

    public String toPath() {
        return name.toPath();
    }

    public String toPath(String string) {
        return name.toPath(string);
    }
}
