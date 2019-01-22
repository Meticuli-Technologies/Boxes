package com.meti.virtual.imports;

import com.meti.virtual.classes.VClassWrapper;
import com.meti.virtual.util.VRegistry;
import com.meti.virtual.Virtual;

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
