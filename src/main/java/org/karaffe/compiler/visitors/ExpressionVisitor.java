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

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import lombok.extern.slf4j.Slf4j;
import org.karaffe.compiler.antlr.KaraffeBaseVisitor;
import org.karaffe.compiler.antlr.KaraffeParser;
import org.karaffe.compiler.tree.Expression;
import org.karaffe.compiler.tree.Operator;
import org.karaffe.compiler.type.KType;

/**
 *
 * @author noko
 */
@Slf4j
public class ExpressionVisitor extends KaraffeBaseVisitor<Expression> {

    private final Queue<Expression> q = new ArrayDeque<>();

    @Override
    public Expression visitExpr(KaraffeParser.ExprContext exprContext) {
        log.info("visitExpr start");
        KaraffeParser.IntLiteralContext literalContext = exprContext.intLiteral();
        if (literalContext != null) {
            Expression intLiteral = literalContext.accept(this);
            q.add(intLiteral);
            return intLiteral;
        }
        List<KaraffeParser.ExprContext> exprSet = exprContext.expr();
        Expression left = exprSet.get(0).accept(this);
        q.add(left);
        Expression op = exprContext.op().accept(this);
        q.add(op);
        log.debug("op : {}", op);
        Expression right = exprSet.get(1).accept(this);
        q.add(right);
        log.info("visitExpr end");
        return Expression.nil();
    }

    @Override
    public Expression visitIntLiteral(KaraffeParser.IntLiteralContext ctx) {
        log.info("visitIntLiteral start");
        String intText = ctx.getText();
        log.debug("literal : {}", intText);
        Literal literal = new Literal(intText, KType.convert(int.class));
        q.add(literal);
        log.info("visitIntLiteral end");
        return literal;
    }

    @Override
    public Expression visitOp(KaraffeParser.OpContext ctx) {
        log.info("visitOp start");
        String op = ctx.getText();
        log.debug("op : {}", op);
        Operator operator = Operator.getOperator(op);
        q.add(operator);
        log.info("visitOp end");
        return operator;
    }

}
