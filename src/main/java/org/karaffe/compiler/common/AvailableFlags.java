package org.karaffe.compiler.common;

import java.util.Optional;

public enum AvailableFlags {
    LOG_DEBUG(new Flag("--log:debug")),
    LOG_WARN(new Flag("--log:warn")), 
    LOG_INFO(new Flag("--log:info", "--log")),;

    private final Flag current;

    private AvailableFlags(Flag flag) {
        this.current = flag;
    }

    public boolean isAvailableFlag(String flagName) {
        return this.current.is(flagName);
    }

    public static Optional<AvailableFlags> findFlag(String arg) {
        for (AvailableFlags availableFlag : values()) {
            Flag flag = availableFlag.current;
            if (flag.is(arg)) {
                return Optional.of(availableFlag);
            }
        }
        return Optional.empty();
    }
}
