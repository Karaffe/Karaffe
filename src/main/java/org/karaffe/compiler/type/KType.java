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

import java.lang.reflect.Modifier;
import org.objectweb.asm.Type;

/**
 *
 * @author noko
 */
public interface KType {

    public static final KType UNRESOLVED = new KType() {
        @Override
        public String getSimpleName() {
            throw new UnsupportedOperationException("Not supported yet. .getSimpleName:java.lang.String");
        }

        @Override
        public String getInternalName() {
            throw new UnsupportedOperationException("Not supported yet. .getInternalName:java.lang.String");
        }

        @Override
        public String getDescriptor() {
            throw new UnsupportedOperationException("Not supported yet. .getDescriptor:java.lang.String");
        }

        @Override
        public Type getASMType() {
            throw new UnsupportedOperationException("Not supported yet. .getASMType:org.objectweb.asm.Type");
        }

        @Override
        public Class<?> toClass() {
            throw new UnsupportedOperationException("Not supported yet. .toClass:java.lang.Class<?>");
        }

        @Override
        public TypeCategory getCategory() {
            throw new UnsupportedOperationException("Not supported yet. .getCategory:org.karaffe.compiler.type.TypeCategory");
        }
    };

    public static KType convert(Class<?> clazz) {
        boolean isPrimitive = clazz.isPrimitive();
        if (isPrimitive) {
            return new JavaPrimitiveType(Type.getType(clazz));
        } else {
            return new JavaType(clazz.getTypeName());
        }
    }

    public String getSimpleName();

    public String getInternalName();

    public String getDescriptor();

    public Type getASMType();

    public Class<?> toClass();

    public TypeCategory getCategory();

    public static boolean isFinalType(KType type) {
        Class<?> superClass = type.toClass();
        int modifiers = superClass.getModifiers();
        return Modifier.isFinal(modifiers);
    }

    public static boolean isInheritable(KType type) {
        return !isFinalType(type);
    }

    public static boolean isInterface(KType type) {
        Class<?> clazz = type.toClass();
        return clazz.isInterface();
    }
}
