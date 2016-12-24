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
package org.karaffe.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import lombok.extern.slf4j.Slf4j;
import org.karaffe.compiler.report.Report;
import org.karaffe.compiler.report.ReportType;
import org.karaffe.compiler.report.Reporter;
import org.karaffe.compiler.tree.ClassDecl;
import org.karaffe.compiler.tree.CompileUnit;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;

/**
 *
 * @author noko
 */
@Slf4j
public class ClassFileWriter implements Reporter {

    private final CompileUnit compileUnit;
    private final BiConsumer<String, byte[]> writer;
    private final List<Report> reports = new ArrayList<>();

    public ClassFileWriter(CompileUnit compileUnit) {
        this.compileUnit = compileUnit;
        this.writer = (name, byteCode) -> {
            try {
                Files.write(Paths.get(name), byteCode);
            } catch (IOException ex) {
                Report report = Report.builder().title("").type(ReportType.ERROR).build();
                reports.add(report);
            }
        };
    }

    public void writeClassDeclsToClassFile(List<ClassDecl> classDecls) {
        compileUnit.classDeclStream()
                .map(c -> convert(c))
                .forEach(c -> {
                    ClassWriter classVisitor = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
                    c.accept(classVisitor);
                    byte[] byteCode = classVisitor.toByteArray();
                    this.writer.accept(c.name + ".class", byteCode);
                });
    }

    private ClassNode convert(ClassDecl classDecl) {
        ClassNode classNode = new ClassNode();
        classNode.name = classDecl.getName();
        classNode.version = Opcodes.V1_8;
        classNode.sourceFile = classDecl.getName() + ".krf";
        return classNode;
    }

    @Override
    public List<Report> getReports() {
        return reports;
    }
}
