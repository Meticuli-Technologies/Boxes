package com.meti.virtual;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/14/2019
 */
public abstract class VClass implements Virtual {
    final VClassState classState = new VClassState();
    final VPackage vPackage;
    final String name;

    public VClass(String name) {
        this(VPackage.DEFAULT, name);
    }

    public VClass(VPackage vPackage, String name) {
        this.name = name;
        this.vPackage = vPackage;
    }

    @Override
    public String print() {
        /*
        to get the class as a compilable, writable, version,
        we simply have to write the class as normal
         */

        return String.join("\n",
                vPackage.print(),
                printContent()
        );
    }

    public abstract String printContent();

    public String getSimpleName() {
        return vPackage.joinedArguments() + "." + name;
    }
}
