/*
 * The MIT License
 *
 * Copyright 2017 Karaffe.
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
package org.karaffe.io;

import java.io.FileInputStream;
import java.io.IOException;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;

/**
 *
 * @author noko
 */
public class ClassFileReader {

    public static void main(String[] args) throws IOException {
        ClassReader reader = new ClassReader(new FileInputStream("/Users/noko/sand/J$1I.class"));
        ClassNode node = new ClassNode();
        reader.accept(node, ClassReader.EXPAND_FRAMES);
        System.out.printf("access                   %s%n", node.access);
        System.out.printf("attrs                    %s%n", node.attrs);
        System.out.printf("fields                   %s%n", node.fields);
        System.out.printf("innerClasses             %s%n", node.innerClasses);
        System.out.printf("interfaces               %s%n", node.interfaces);
        System.out.printf("invisibleAnnotations     %s%n", node.invisibleAnnotations);
        System.out.printf("invisibleTypeAnnotations %s%n", node.invisibleTypeAnnotations);
        System.out.printf("methods                  %s%n", node.methods);
        System.out.printf("name                     %s%n", node.name);
        System.out.printf("outerClass               %s%n", node.outerClass);
        System.out.printf("outerMethod              %s%n", node.outerMethod);
        System.out.printf("outerMethodDesc          %s%n", node.outerMethodDesc);
        System.out.printf("signature                %s%n", node.signature);
        System.out.printf("sourceDebug              %s%n", node.sourceDebug);
        System.out.printf("sourceFile               %s%n", node.sourceFile);
        System.out.printf("superName                %s%n", node.superName);
        System.out.printf("version                  %s%n", node.version);
        System.out.printf("visibleAnnotations       %s%n", node.visibleAnnotations);
        System.out.printf("visibleTypeAnnotations   %s%n", node.visibleTypeAnnotations);
    }
}
