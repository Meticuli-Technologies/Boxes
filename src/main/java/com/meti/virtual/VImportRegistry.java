package com.meti.virtual;

public class VImportRegistry extends VRegistry<VClassWrapper, VImport> implements Virtual {
    public VImportRegistry() {
        super(VImport::new);
    }
    @Override
    public String print() {
        StringBuilder builder = new StringBuilder();
        contentStream()
                .map(wrapper -> wrapper.wrappedName)
                .sorted()
                .forEach(s -> builder.append("import ")
                        .append(s)
                        .append(";\n"));
        return builder.toString();
    }
}
