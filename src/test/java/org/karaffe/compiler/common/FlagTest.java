package org.karaffe.compiler.config;

import org.junit.Test;
import org.karaffe.compiler.common.Flag;

public class FlagTest {
    @Test
    public void is() {
        Flag flag = new Flag("-d");
        assert flag.is("-d") : "flag equality fail";
    }

    @Test
    public void alias() {
        Flag flag = new Flag("-d", "--debug");
        assert flag.is("-d") : "flag equality fail";
        assert flag.is("--debug") : "aliased flag equality fail";
    }

    @Test
    public void nullargs() {
        Flag flag = new Flag("-d");
        flag.is(null);
        
        flag = new Flag("-d", "--debug");
        flag.is(null);
    }
}
