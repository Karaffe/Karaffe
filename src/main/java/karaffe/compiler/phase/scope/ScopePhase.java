/**
 * Karaffe Programming Language
 */
package karaffe.compiler.phase.scope;

import karaffe.compiler.phase.Phase;
import karaffe.compiler.tree.AST;

public class ScopePhase extends Phase<AST, AST> {

    @Override
    public AST apply(AST t) {
        return t;
    }

}
