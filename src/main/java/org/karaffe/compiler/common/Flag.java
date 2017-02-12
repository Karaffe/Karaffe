package org.karaffe.compiler.common;

import java.util.Arrays;
import java.util.List;

public class Flag {

    private final String flagName;
    private final List<String> aliases;

    public Flag(String flagName, String... aliases) {
        this.flagName = flagName;
        this.aliases = Arrays.asList(aliases);
    }

    public boolean is(String otherName) {
        if (this.flagName.equals(otherName)) {
            return true;
        }
        return this.aliases.contains(otherName);
    }
}
