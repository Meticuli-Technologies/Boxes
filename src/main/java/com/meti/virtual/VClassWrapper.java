package com.meti.virtual;

public class VClassWrapper {
    public final String wrappedName;

    public VClassWrapper(Class<?> clazz){
        this.wrappedName = clazz.getSimpleName();
    }

    public VClassWrapper(VClass vClass){
        this.wrappedName = vClass.getSimpleName();
    }
}
