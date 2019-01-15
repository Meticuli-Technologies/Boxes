package com.meti.virtual.fields;

import com.meti.virtual.Virtual;
import com.meti.virtual.util.VGenericRegistry;

public class VFieldRegistry extends VGenericRegistry<VField> implements Virtual {
    @Override
    public String print() {
        StringBuilder builder = new StringBuilder();
        contentStream().map(VField::print)
                .forEach(s -> builder.append(s)
                        .append("\n"));

        return builder.toString();
    }
}
