package com.meti.virtual.methods;

import com.meti.virtual.Virtual;
import com.meti.virtual.imports.VImport;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/15/2019
 */
public class VParameter implements Virtual {
    private final VImport type;
    private final String name;

    public VParameter(VImport type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public String print() {
        return type.content.simpleName + " " + name;
    }
}
