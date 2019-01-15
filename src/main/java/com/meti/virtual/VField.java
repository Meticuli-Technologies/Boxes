package com.meti.virtual;

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
