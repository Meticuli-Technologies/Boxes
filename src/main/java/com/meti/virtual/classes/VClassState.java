package com.meti.virtual.classes;

import com.meti.virtual.Virtual;
import com.meti.virtual.fields.VFieldRegistry;
import com.meti.virtual.methods.VMethodRegistry;

class VClassState implements Virtual {
    private final VFieldRegistry fieldRegistry = new VFieldRegistry();
    private final VMethodRegistry methodRegistry = new VMethodRegistry();

    @Override
    public String print() {
        return fieldRegistry.print() + "\n" + methodRegistry.toString();
    }
}
