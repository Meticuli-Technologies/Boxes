package com.meti;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/13/2019
 */
public class Callback {
    Exception exception;

    public Callback() {
    }

    public Callback(Exception exception) {
        this.exception = exception;
    }

    public void throwIfPresent() throws Exception {
        if(exception != null){
            throw exception;
        }
    }

    public void setException(Exception exception) {
        if (this.exception == null) {
            this.exception = exception;
        }
        else{
            throw new IllegalArgumentException("Exception has already been set!");
        }
    }

    public boolean hasException() {
        return exception != null;
    }
}
