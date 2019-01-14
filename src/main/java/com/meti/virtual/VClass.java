package com.meti.virtual;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/14/2019
 */
public abstract class VClass {
    final String name;
    final VPackage vPackage;

    public VClass(String name, VPackage vPackage) {
        this.name = name;
        this.vPackage = vPackage;
    }

    public abstract String print();

    public String getSimpleName() {
        return vPackage.joinedArguments() + "." + name;
    }
}
