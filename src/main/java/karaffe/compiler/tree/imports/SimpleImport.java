/**
 * Karaffe Programming Language
 */
package karaffe.compiler.tree.imports;

import karaffe.compiler.tree.AbstractNode;
import karaffe.compiler.tree.name.PackageOrTypeName;
import karaffe.compiler.tree.util.ImportData;
import karaffe.compiler.visitor.Visitor;

public class SimpleImport extends AbstractNode {

    private final ImportData importData;

    public SimpleImport(Object n) {
        this.importData = new ImportData((PackageOrTypeName) n);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.simpleImportDecl(this);
    }

    @Override
    public String toString() {
        return "(SimpleImport:" + importData.fullName() + ")";
    }

    public String fullName() {
        return importData.fullName();
    }

    public String shortName() {
        return importData.shortName();
    }

}
