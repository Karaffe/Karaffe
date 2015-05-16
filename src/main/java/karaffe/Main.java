package karaffe;

import java.io.File;
import java.util.stream.Stream;
import karaffe.compiler.KCompiler;

public class Main {

    public static void main(String... args) throws Exception {
        if (args == null || args.length == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Karaffe Compiler: ").append(KCompiler.VERSION).append(System.lineSeparator());
            stringBuilder.append("Java Version: ").append(System.getProperty("java.version")).append(System.lineSeparator());
            System.out.println(stringBuilder.toString());
        }
        Stream.of(args)
                .map(File::new)
                .map(KCompiler::new)
                .map(KCompiler::compile)
                .forEach(l -> {
                    l.forEach(System.out::print);
                });
    }
}
