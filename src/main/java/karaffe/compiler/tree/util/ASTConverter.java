/**
 * Karaffe Programming Language
 */
package karaffe.compiler.tree.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import static java.util.stream.Collectors.toList;
import karaffe.compiler.tree.AST;
import karaffe.compiler.tree.classdecls.SuperTypeOrInterfaces;
import karaffe.compiler.tree.type.SimpleType;
import karaffe.compiler.tree.type.SimpleTypeList;
import org.objectweb.asm.Type;

public class ASTConverter {

    public static final Function<AST, String> superOrInterfacesToSuperTypeInternalName = ast -> {
        SuperTypeOrInterfaces s = (SuperTypeOrInterfaces) ast;
        SimpleType first = s.getFirst();
        Type type = first.get();
        try {
            Class<?> clazz = Class.forName(type.getClassName());
            if (clazz.isInterface()) {
                return Type.getInternalName(Object.class);
            }
            return type.getInternalName();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    };

    public static final Function<AST, List<Type>> superOrInterfacesToInternalTypeNameList = ast -> {
        SuperTypeOrInterfaces s = (SuperTypeOrInterfaces) ast;
        List<Type> internalTypeNames = new ArrayList<>();
        SimpleType type = s.getFirst();
        internalTypeNames.add(type.get());
        if (s.hasNext()) {
            SimpleTypeList l = s.nextSimpleTypeList();
            internalTypeNames.add(l.first().get());
            while (l.hasNext()) {
                l = l.next();
                internalTypeNames.add(l.first().get());
            }
        }
        return internalTypeNames;
    };

    public static final Function<AST, List<String>> superOrInterfacesToInterfaces = ast -> {
        List<Type> types = superOrInterfacesToInternalTypeNameList.apply(ast);
        List<String> interfaces = types.stream()
                .map(t -> t.getClassName())
                .map(n -> {
                    try {
                        return Class.forName(n);
                    } catch (ClassNotFoundException e) {
                        System.out.println(e);
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .filter(Class::isInterface)
                .map(Type::getInternalName)
                .collect(toList());
        return interfaces;
    };

}
