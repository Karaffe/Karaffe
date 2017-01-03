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

import java.util.HashMap;
import java.util.Map;
import org.karaffe.compiler.type.KType;

/**
 *
 * @author noko
 */
public class Operator implements Expression, Op {

    private static final Map<String, Operator> opMap = new HashMap<>();

    public static final Operator PLUS = new Operator("+", KType.UNRESOLVED, OpType.INFIX, "$plus", 0);
    public static final Operator MINUS = new Operator("-", KType.UNRESOLVED, OpType.INFIX, "$minus", 0);
    public static final Operator STAR = new Operator("*", KType.UNRESOLVED, OpType.INFIX, "$times", 0);
    public static final Operator SLASH = new Operator("/", KType.UNRESOLVED, OpType.INFIX, "$div", 0);

    static {
        opMap.put("+", PLUS);
        opMap.put("-", MINUS);
        opMap.put("*", STAR);
        opMap.put("/", SLASH);
    }

    private final String name;
    private final KType returnType;
    private final OpType type;
    private final String internalName;
    private final int priority;

    public Operator(String name, KType returnType, OpType type, String internalName, int priority) {
        this.name = name;
        this.returnType = returnType;
        this.type = type;
        this.internalName = internalName;
        this.priority = priority;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ASTType getASTType() {
        return ASTType.OPERATOR;
    }

    @Override
    public KType getReturnType(Expression... args) {
        return returnType;
    }

    @Override
    public OpType operatorType() {
        return type;
    }

    @Override
    public int priority() {
        return priority;
    }

    public static Operator getOperator(String op) {
        return opMap.get(op);
    }
}
