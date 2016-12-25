/*
 * The MIT License
 *
 * Copyright 2016 Karaffe.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.karaffe.compiler.tree.meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.karaffe.compiler.type.JavaType;
import org.karaffe.compiler.type.KType;

/**
 *
 * @author noko
 */
@Slf4j
public class Scope {

    private final Map<String, KType> typeCache;
    private static final List<String> defaultImportPackages = new ArrayList<>();
    private static final Map<String, KType> javaKaraffeTypeMapper = new HashMap();

    static {
        defaultImportPackages.add("java.lang");
        defaultImportPackages.add("java.io");
        defaultImportPackages.add("java.net");
        defaultImportPackages.add("java.util");

        javaKaraffeTypeMapper.put("karaffe.Any", JavaType.ANY_TYPE);
        javaKaraffeTypeMapper.put("karaffe.Int", new JavaType("java.lang.Integer"));
    }

    public Scope() {
        this.typeCache = new HashMap<>();
    }

    public Optional<KType> resolveType(String simpleClassName) {
        if (simpleClassName.contains(".")) {
            throw new RuntimeException("Invalid Simple ClassName : " + simpleClassName);
        }
        Optional<KType> first = typeCache
                .entrySet()
                .stream()
                .filter(entry -> {
                    log.debug(entry.getKey());
                    return entry.getKey().endsWith("." + simpleClassName);
                })
                .map(Map.Entry::getValue)
                .findFirst();
        if (first.isPresent()) {
            log.debug("found : {} -> {}", simpleClassName, first.get().getSimpleName());
            return first;
        }

        for (Map.Entry<String, KType> entry : javaKaraffeTypeMapper.entrySet()) {
            if (entry.getKey().endsWith(simpleClassName)) {
                log.debug("found : {} -> {}", simpleClassName, entry.getKey());
                typeCache.put(entry.getKey(), entry.getValue());
                return Optional.of(entry.getValue());
            }
        }

        for (String packageName : defaultImportPackages) {
            String fullName = packageName + "." + simpleClassName;
            log.debug("search : {}", fullName);
            try {
                Class<?> clazz = Class.forName(fullName);
                KType kType = KType.convert(clazz);
                log.debug("found : {} -> {}", simpleClassName, fullName);
                typeCache.put(fullName, kType);
                return Optional.of(kType);
            } catch (ClassNotFoundException ex) {
                //IGNORED
            }
        }
        return Optional.empty();
    }

    public Optional<KType> resolveType(Class<?> clazz) {
        return resolveType(clazz.getCanonicalName());
    }

}
