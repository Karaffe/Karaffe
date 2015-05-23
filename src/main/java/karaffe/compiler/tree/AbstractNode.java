/**
 * Karaffe Programming Language
 */
package karaffe.compiler.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java_cup.runtime.Symbol;

public abstract class AbstractNode implements AST {

    private final List<AST> children = new ArrayList<>();

    private Optional<Symbol> symbol = Optional.empty();

    @Override
    public List<AST> children() {
        return children;
    }

    public void addChild(AST ast) {
        children.add(Objects.requireNonNull(ast));
    }

    public void addChild(Optional<? extends AST> ast) {
        Objects.requireNonNull(ast).ifPresent(children::add);
    }

    public void addChildren(AST... asts) {
        for (AST ast : asts) {
            addChild(ast);
        }
    }

    public AbstractNode setSymbol(Object symbol) {
        this.symbol = Optional.of(Symbol.class.cast(symbol));
        return this;
    }

    public int line() {
        return symbol.map(s -> s.left).orElse(-1);
    }

    public int column() {
        return symbol.map(s -> s.right).orElse(-1);
    }
}
