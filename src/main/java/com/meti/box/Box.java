package com.meti.box;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/17/2019
 */
public class Box {
    final Set<Box> subBoxes;
    final Map<String, Class<?>> classMap = new HashMap<>();

    public Box(Class<?>... classes) {
        this(new HashSet<>(), classes);
    }

    public Box(Set<Box> subBoxes, Class... classes) {
        this.subBoxes = subBoxes;
        for (Class<?> aClass : classes) {
            classMap.put(aClass.getName(), aClass);
        }
    }

    public Set<Class<?>> allClasses() {
        return new HashSet<>(classMap.values());
    }

    public Set<Class<?>> classByAssignable(Class<?> checkedClass) {
        return classMap.values().stream()
                .filter(checkedClass::isAssignableFrom)
                .collect(Collectors.toSet());
    }
}
