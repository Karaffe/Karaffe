/**
 * Karaffe Programming Language
 */
package karaffe.compiler.tree;

import java.util.Optional;
import karaffe.compiler.phase.parser.Lexer;
import karaffe.compiler.visitor.Visitor;

public class AmbiguousName extends AbstractNode {

    private final AmbiguousName name;
    private final Identifier id;

    public AmbiguousName(AmbiguousName name, Identifier id) {
        this(null, name, id);
    }

    public AmbiguousName(Identifier id) {
        this(null, null, id);
    }

    public AmbiguousName(Lexer.SymInfo symInfo, AmbiguousName name, Identifier id) {
        super(symInfo);
        this.name = name;
        this.id = id;
    }

    public AmbiguousName(Lexer.SymInfo symInfo, Identifier id) {
        this(symInfo, null, id);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.ambiguousName(this);
    }

    public Optional<AmbiguousName> name() {
        return Optional.ofNullable(name);
    }

    public Optional<Identifier> id() {
        return Optional.ofNullable(id);
    }

    public boolean hasName() {
        return name != null;
    }

    public boolean hasId() {
        return id != null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("AmbiguousName:");
        if (id != null) {
            builder.append(id.toString());
        }
        if (name != null) {
            builder.append("->");
            builder.append(name.toString());
        }
        return builder.toString();
    }

}
