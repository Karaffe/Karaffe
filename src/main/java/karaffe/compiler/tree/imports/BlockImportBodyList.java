/**
 * Karaffe Programming Language
 */
package karaffe.compiler.tree.imports;

import karaffe.compiler.tree.AST;
import karaffe.compiler.tree.AbstractNode;
import karaffe.compiler.visitor.Visitor;

public class BlockImportBodyList extends AbstractNode {

    private final AST body;
    private final AST list;

    public BlockImportBodyList(Object body, Object list) {
        this.body = (AST) body;
        this.list = (AST) list;
        children.add(this.body);
        children.add(this.list);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.blockImportBodyList(this);
    }

    @Override
    public String toString() {
        return "(BlockImportBodyList:" + body + "," + list + ")";
    }
}
