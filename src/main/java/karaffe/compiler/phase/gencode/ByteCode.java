/**
 * Karaffe Programming Language
 */
package karaffe.compiler.phase.gencode;

import karaffe.compiler.KCompiler;
import karaffe.compiler.phase.ToDo;

public class ByteCode {

    private final byte[] bytecode;
    private final String fileName;
    private final String packagePrefix;

    public ByteCode(byte[] bytecode, String fileName, String packagePrefix) {
        this.bytecode = bytecode;
        this.fileName = fileName;
        if (fileName != null
                && (Character.isLowerCase(fileName.charAt(0))
                || fileName.charAt(0) == '_')) {
            //クラス名の開始が小文字または_で始まる
            KCompiler.todoList.add(
                    new ToDo(ToDo.Type.WARNING, "クラス名はアルファベットの大文字(A~Z)から始める必要があります。\n"
                            + "クラス名: " + fileName + "\n")
            );
        }
        this.packagePrefix = packagePrefix;
    }

    public String fileName() {
        return fileName;
    }

    public byte[] get() {
        return bytecode;
    }

    public String packagePrefix() {
        return packagePrefix;
    }
}
