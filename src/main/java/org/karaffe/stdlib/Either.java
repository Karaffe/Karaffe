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
package org.karaffe.stdlib;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 *
 * @author noko
 * @param <L>
 * @param <R>
 */
public final class Either<L, R> {

    public static <L, R> Either<L, R> left(L value) {
        return new Either<>(Optional.of(value), Optional.empty());
    }

    public static <L, R> Either<L, R> right(R value) {
        return new Either<>(Optional.empty(), Optional.of(value));
    }
    private final Optional<L> left;
    private final Optional<R> right;

    private Either(Optional<L> l, Optional<R> r) {
        left = l;
        right = r;
    }

    public <T> T map(
            Function<? super L, ? extends T> lFunc,
            Function<? super R, ? extends T> rFunc) {
        return left.map(lFunc).orElseGet(() -> right.map(rFunc).get());
    }

    public <T> Either<T, R> mapLeft(Function<? super L, ? extends T> lFunc) {
        return new Either<>(left.map(lFunc), right);
    }

    public <T> Either<L, T> mapRight(Function<? super R, ? extends T> rFunc) {
        return new Either<>(left, right.map(rFunc));
    }

    public void apply(Consumer<? super L> lFunc, Consumer<? super R> rFunc) {
        left.ifPresent(lFunc);
        right.ifPresent(rFunc);
    }

    public boolean isLeft() {
        return left.isPresent();
    }

    public boolean isRight() {
        return right.isPresent();
    }
}
