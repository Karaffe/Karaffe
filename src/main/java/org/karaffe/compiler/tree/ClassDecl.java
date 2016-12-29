/*
 * The MIT License
 *
 * Copyright 2016 Karaffe.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.karaffe.compiler.tree;

import java.util.ArrayList;
import java.util.List;
import org.karaffe.compiler.tree.meta.ClassMetaData;

/**
 *
 * @author noko
 */
public class ClassDecl implements Statement {

    private final ClassMetaData metaData;
    private final String name;
    private final List<Statement> statements = new ArrayList<>();
    private boolean hasConstructor;

    public ClassDecl(ClassMetaData metaData, String name) {
        if (metaData == null || name == null) {
            throw new NullPointerException("metadata : " + metaData + ", name : " + name);
        }
        this.metaData = metaData;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ASTType getASTType() {
        return ASTType.CLASS_DECL;
    }

    public List<Statement> getStatements() {
        return new ArrayList<>(statements);
    }

    public void addStatement(Statement statement) {
        this.statements.add(statement);
    }

    public String getSuperTypeName() {
        return metaData.getSuperClass().getInternalName();
    }

    public boolean isNeedDefaultConstructor() {
        return !hasConstructor;
    }

}
