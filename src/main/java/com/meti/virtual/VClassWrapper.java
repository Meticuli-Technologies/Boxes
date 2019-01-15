package com.meti.virtual;

import java.util.Objects;

public class VClassWrapper {
    public final String wrappedName;
    public final String simpleName;

    public VClassWrapper(Class<?> clazz){
        this.wrappedName = clazz.getName();
        this.simpleName = clazz.getSimpleName();
    }

    public VClassWrapper(VClass vClass){
        this.wrappedName = vClass.getName();
        this.simpleName = vClass.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VClassWrapper wrapper = (VClassWrapper) o;
        return Objects.equals(wrappedName, wrapper.wrappedName);
    }
}
