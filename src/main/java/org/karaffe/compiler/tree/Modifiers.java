package org.karaffe.compiler.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.karaffe.compiler.tree.base.AbstractNodes;

public class Modifiers extends AbstractNodes<Modifier> {

    public Modifiers() {
        this(new ArrayList<>(0));
    }

    public Modifiers(final Modifier modifier) {
        this(new ArrayList<>(Arrays.asList(modifier)));
    }

    public Modifiers(final Modifier... modifiers) {
        this(new ArrayList<>(Arrays.asList(modifiers)));
    }

    public Modifiers(final List<Modifier> modifiers) {
        super(NodeType.S_MODIFIER, modifiers);
    }

}
