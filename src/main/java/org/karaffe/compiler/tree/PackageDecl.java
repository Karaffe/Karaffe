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

import java.util.List;
import org.karaffe.compiler.exception.ExceptionMessages;
import org.karaffe.compiler.exception.IllegalSymbolException;
import org.karaffe.compiler.tree.meta.Path;

/**
 *
 * @author noko
 */
public class PackageDecl implements Statement {

    private final List<String> packagePathList;
    private final String packagePath;

    public PackageDecl(Path path) {
        this.packagePathList = path.toList();
        this.packagePath = path.stream().reduce((left, right) -> left + "." + right).orElseThrow(() -> new IllegalSymbolException(ExceptionMessages.INVALID_PATH));
    }

    @Override
    public String getName() {
        return packagePath;
    }

    @Override
    public ASTType getASTType() {
        return ASTType.PACKAGE_DECL;
    }

}
