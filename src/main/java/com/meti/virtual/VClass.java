package com.meti.virtual;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/14/2019
 */
public class VClass implements Virtual {
    final String content;
    final VPackage vPackage;

    public VClass(String content) {
        this(VPackage.DEFAULT, content);
    }

    public VClass(VPackage vPackage, String content) {
        this.vPackage = vPackage;
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
