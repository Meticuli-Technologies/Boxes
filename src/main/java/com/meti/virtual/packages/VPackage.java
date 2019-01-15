package com.meti.virtual.packages;

import com.meti.virtual.Virtual;

import java.util.Arrays;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/14/2019
 */
public class VPackage implements Virtual {
    public static final VPackage DEFAULT = new VPackage();
    public final String[] args;

    public VPackage(String... args) {
        this.args = args;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VPackage vPackage = (VPackage) o;
        return Arrays.equals(args, vPackage.args);
    }

    @Override
    public String print() {
        return "package " + joinedArguments() + ";";
    }

    public String joinedArguments() {
        return String.join(".", args);
    }
}
