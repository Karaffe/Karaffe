/**
 * Karaffe Programming Language
 */
package karaffe.ncompiler.process;

import karaffe.ncompiler.input.ProgramFile;

public interface Processor {

    public default ProgramFile process(ProgramFile p) {
        return p;
    }
}
