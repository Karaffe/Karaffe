/**
 *
 * Karaffe Programming Language
 *   __ _____   ___  ___   ____________
 *   / //_/ _ | / _ \/ _ | / __/ __/ __/
 *  / , \/ __ |/ , _/ __ |/ _// _// _/
 * /_/|_/_/ |_/_/|_/_/ |_/_/ /_/ /___/
 *
 */
package net.nokok.karaffe.parser.visitor;

import net.nokok.karaffe.parser.ASTCompileUnit;
import net.nokok.karaffe.parser.KaraffeParserDefaultVisitor;
import net.nokok.karaffe.parser.excptn.KaraffeParserException;
import net.nokok.karaffe.parser.util.TypePool;

public class TypeChecker extends KaraffeParserDefaultVisitor {

    private TypePool pool = new TypePool();

    @Override
    public TypePool visit(ASTCompileUnit node, Object data) throws KaraffeParserException {
        node.childrenAccept(this, data);
        return pool;
    }

}
