package org.karaffe.testrunners;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class KaraffePassTestRunner {

    @Test
    public void runTest() throws URISyntaxException {
        URL passDirUrl = KaraffePassTestRunner.class.getResource("/");
        System.out.println(passDirUrl);
        File dir = new File(passDirUrl.toURI());
        List<String> passFiles = Arrays.asList(dir.list());
        for ( String fileName : passFiles ) {
            System.out.println(fileName);
        }
    }
}
