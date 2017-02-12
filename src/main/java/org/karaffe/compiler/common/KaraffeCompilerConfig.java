package org.karaffe.compiler.common;

import java.util.EnumSet;
import java.util.Optional;


public class KaraffeCompilerConfig {

    private static final EnumSet<AvailableFlags> DEFAULT_FLAGS = 
            EnumSet.noneOf(AvailableFlags.class);

    private final EnumSet<AvailableFlags> flags = EnumSet.noneOf(AvailableFlags.class);

    public KaraffeCompilerConfig() {
        this.flags.addAll(KaraffeCompilerConfig.DEFAULT_FLAGS);
    }

    public KaraffeCompilerConfig(String[] args) {
        if (args == null) {
            throw new NullPointerException("null args");
        }
        for (String arg : args) {
            Optional<AvailableFlags> findResult = AvailableFlags.findFlag(arg);
            findResult.map(flags::add);
        }
    }

    public boolean has(AvailableFlags flag) {
        return this.flags.contains(flag);
    }
}
