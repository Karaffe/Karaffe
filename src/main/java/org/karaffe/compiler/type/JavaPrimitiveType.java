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

import org.objectweb.asm.Type;

/**
 *
 * @author noko
 */
public class JavaPrimitiveType implements KType {

    private final Type type;

    public JavaPrimitiveType(Type type) {
        this.type = type;
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
        if (type.equals(Type.INT_TYPE)) {
            return int.class;
        } else if (type.equals(Type.BOOLEAN_TYPE)) {
            return boolean.class;
        } else if (type.equals(Type.BYTE_TYPE)) {
            return byte.class;
        } else if (type.equals(Type.CHAR_TYPE)) {
            return char.class;
        } else if (type.equals(Type.DOUBLE_TYPE)) {
            return double.class;
        } else if (type.equals(Type.FLOAT_TYPE)) {
            return float.class;
        } else if (type.equals(Type.LONG_TYPE)) {
            return long.class;
        } else if (type.equals(Type.SHORT_TYPE)) {
            return short.class;
        } else if (type.equals(Type.VOID_TYPE)) {
            return void.class;
        } else {
            throw new RuntimeException("Primitive Type Not Found. : " + type);
        }
    }

    @Override
    public TypeCategory getCategory() {
        return TypeCategory.JAVA_PRIM_TYPE;
    }

}
