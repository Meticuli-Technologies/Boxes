package com.meti.box;

import java.util.Set;

public interface Box {
    Class<?> getClass(ClassProperty... properties);

    Set<Class<?>> getClasses(ClassProperty... properties);
}
