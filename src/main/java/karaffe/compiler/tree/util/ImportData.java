/**
 * Karaffe Programming Language
 */
package karaffe.compiler.tree.util;

import karaffe.compiler.tree.name.PackageOrTypeName;

public class ImportData {

    private final String shortName;
    private final String fullName;

    public ImportData(String shortName, String fullName) {
        this.shortName = shortName;
        this.fullName = fullName;
    }

    public ImportData(PackageOrTypeName packageOrTypeName) {
        String path = packageOrTypeName.toPath();
        this.fullName = path;
        String[] split = path.split("\\.");
        this.shortName = split[split.length - 1];
    }

    public String shortName() {
        return shortName;
    }

    public String fullName() {
        return fullName;
    }
}
