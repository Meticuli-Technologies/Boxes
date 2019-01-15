package com.meti.virtual;

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
