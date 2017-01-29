package org.karaffe.compiler.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.karaffe.compiler.io.SourceCode;
import org.karaffe.compiler.reporter.Reporter;

class StdInInput implements KaraffeInput {

    private final InputStream inputStream;
    private final Reporter reporter = Reporter.INSTANCE;

    StdInInput() {
        inputStream = System.in;
    }

    StdInInput(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public SourceCode read() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            StringBuilder sb = new StringBuilder();
            String line = "";
            while ( (line = reader.readLine()) != null ) {
                sb.append(line).append(System.lineSeparator());
            }
            SourceCode sourceCode = new SourceCode("stdin", sb);
            return sourceCode;
        } catch (IOException e) {
            throw new KaraffeIOException(e);
        }

    }

}
