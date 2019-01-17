package com.meti.box;

import java.util.Set;

public interface Box {
    Set<Box> getSubBoxes();

    Class<?> getClass(ClassProperty... properties);

    Set<Class<?>> getClasses(ClassProperty... properties);
}
