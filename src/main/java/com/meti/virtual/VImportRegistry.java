package com.meti.virtual;

public class VImportRegistry extends VRegistry<VClassWrapper> implements Virtual {
    @Override
    public String print() {
        StringBuilder builder = new StringBuilder();
        contentStream()
                .map(wrapper -> wrapper.wrappedName)
                .forEach(s -> builder.append("import ")
                        .append(s)
                        .append(";\n"));
        return builder.toString();
    }
}