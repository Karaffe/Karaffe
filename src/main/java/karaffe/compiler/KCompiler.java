/**
 * Karaffe Programming Language
 */
package karaffe.compiler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import karaffe.compiler.phase.ToDo;
import karaffe.compiler.phase.checker.Warnings;
import karaffe.compiler.phase.gencode.ClassGen;
import karaffe.compiler.phase.gencode.KClassWriter;
import karaffe.compiler.phase.parser.ParserPhase;
import karaffe.compiler.phase.resolvers.ResolvePhase;
import karaffe.compiler.phase.scope.ScopePhase;

public class KCompiler {

    public static final String VERSION = "0.0.0b2";
    public static final List<ToDo> todoList = new ArrayList<>();

    private final File file;

    public KCompiler(File file) {
        this.file = file;
        if (!file.exists()) {
            todoList.add(new ToDo(ToDo.Type.ERROR, file.getAbsolutePath() + "が見つかりません。ファイルが存在しないか、アクセスできません。"));
        }
    }

    public List<ToDo> compile() {
        return compile(file.getAbsolutePath());
    }

    private List<ToDo> compile(String path) {
        Stream.of(path)
                .map(new ParserPhase())
                .map(new ScopePhase())
                .map(new ResolvePhase())
                .map(new Warnings())
                .map(new ClassGen())
                .flatMap(List::stream)
                .forEach(new KClassWriter());
        return todoList;
    }

    public static List<ToDo> compileBySource(String src) {
        try {
            File file = File.createTempFile("krf", "");
            try (FileWriter writer = new FileWriter(file);
                    BufferedWriter bufferedWriter = new BufferedWriter(writer);) {
                bufferedWriter.write(src);
            }
            List<ToDo> tds = new KCompiler(file).compile();
            file.delete();
            return tds;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
