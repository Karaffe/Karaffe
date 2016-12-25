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
package org.karaffe.compiler.type;

import org.karaffe.compiler.exception.TypeNotFoundException;
import org.objectweb.asm.Type;

/**
 *
 * @author noko
 */
public class JavaType implements KType {

    public static final KType ANY_TYPE = new JavaType("java.lang.Object");

    private final Type type;

    public JavaType(String fqcn) {
        try {
            Class<?> clazz = Class.forName(fqcn);
            this.type = Type.getType(clazz);
        } catch (ClassNotFoundException ex) {
            throw new TypeNotFoundException(fqcn);
        }
    }

    @Override
    public String getSimpleName() {
        return type.getClassName();
    }

    @Override
    public String getInternalName() {
        return type.getInternalName();
    }

    @Override
    public String getDescriptor() {
        return type.getDescriptor();
    }

    @Override
    public Type getASMType() {
        return type;
    }

    @Override
    public Class<?> toClass() {
        try {
            return Class.forName(type.getClassName());
        } catch (ClassNotFoundException ex) {
            throw new TypeNotFoundException(type.getClassName());
        }
    }

    @Override
    public TypeCategory getCategory() {
        return TypeCategory.JAVA_REF_TYPE;
    }

}
