package com.meti.virtual;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/14/2019
 */
public class VStringClass extends VClass implements Virtual {
    final String content;

    public VStringClass(String name, String content) {
        this(VPackage.DEFAULT, name, content);
    }

    public VStringClass(VPackage vPackage, String name, String content) {
        super(name, vPackage);
        this.content = content;
    }

    @Override
    public String print() {
        /*
        to get the class as a compilable, writable, version,
        we simply have to write the class as normal
         */

        return String.join("\n",
                vPackage.print(),
                content
        );
    }
}
