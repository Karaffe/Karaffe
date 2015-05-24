/**
 * Karaffe Programming Language
 */
package karaffe.ncompiler;

import karaffe.ncompiler.input.ProgramFile;
import karaffe.ncompiler.input.Source;
import karaffe.ncompiler.output.Output;
import karaffe.ncompiler.process.Processor;

public class DefaultComplier implements Compiler {

    public DefaultComplier(String[] args) {

    }

    @Override
    public void compile() {
        Source source = null;
        ProgramFile sourceFile = source.getSource();
        Processor processor = null;
        processor.process(sourceFile);
        Output output = null;
        output.output(sourceFile);
    }

}
