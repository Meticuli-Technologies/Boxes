package com.meti.virtual.fields;

import com.meti.virtual.Virtual;
import com.meti.virtual.classes.VClassWrapper;
import com.meti.virtual.util.VElement;

public class VField implements Virtual {
    final VElement<VClassWrapper> type;
    final String name;

    public VField(VElement<VClassWrapper> type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public String print() {
        return type.content.simpleName + " " + name + ";";
    }
}
