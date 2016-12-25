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
package org.karaffe.compiler.visitors;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.karaffe.compiler.antlr.KaraffeBaseVisitor;
import org.karaffe.compiler.antlr.KaraffeParser;
import org.karaffe.compiler.exception.NotInheritableException;
import org.karaffe.compiler.exception.TypeNotFoundException;
import org.karaffe.compiler.tree.ClassDecl;
import org.karaffe.compiler.tree.meta.ClassMetaData;
import org.karaffe.compiler.tree.meta.Scope;
import org.karaffe.compiler.type.JavaType;
import org.karaffe.compiler.type.KType;

/**
 *
 * @author noko
 */
@Slf4j
public class SuperOrInterfaceVisitor extends KaraffeBaseVisitor<ClassMetaData> {

    private final Scope scope;
    private final ClassDecl parent;

    SuperOrInterfaceVisitor(Scope scope, ClassDecl parent) {
        this.scope = scope;
        this.parent = parent;
    }

    @Override
    public ClassMetaData visitSuperOrInterfaceList(KaraffeParser.SuperOrInterfaceListContext ctx) {
        log.info("enter super or interface");
        List<KaraffeParser.ClassNameContext> superOrInterfaceList = ctx.className();
        log.debug("super or interfaces : {}", superOrInterfaceList.size());

        KType superType = null;
        List<KType> interfaces = new ArrayList<>(superOrInterfaceList.size());
        for (int i = 0; i < superOrInterfaceList.size(); i++) {
            KaraffeParser.ClassNameContext superOrInterface = superOrInterfaceList.get(i);
            String superOrInterfaceName = superOrInterface.getText();
            log.debug("super or interface : " + superOrInterfaceName);
            Optional<KType> resolveType = scope.resolveType(superOrInterfaceName);
            KType kType = resolveType.orElseThrow(() -> new TypeNotFoundException(superOrInterfaceName));
            if (i == 0) {
                boolean inheritable = KType.isInheritable(kType);
                boolean isInterface = KType.isInterface(kType);
                if (inheritable) {
                    superType = kType;
                    continue;
                }
                if (!isInterface) {
                    throw new NotInheritableException(kType.getSimpleName(), ctx.getParent(), superOrInterface);
                }
            }
            interfaces.add(kType);
        }

        if (superType == null) {
            superType = JavaType.ANY_TYPE;
        }

        ClassMetaData metaData = ClassMetaData.builder().superClass(superType).interfaces(interfaces).outerClass(parent).build();
        log.info("end super or interface");
        return metaData;
    }

}
