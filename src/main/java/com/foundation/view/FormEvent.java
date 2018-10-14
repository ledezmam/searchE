package com.foundation.view;

import java.util.EventObject;

public class FormEvent extends EventObject {

    private String one;
    private String two;

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source, String one, String two) {
        super(source);
        this.one = one;
        this.two = two;
    }

    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public String getTwo() {
        return two;
    }

    public void setTwo(String two) {
        this.two = two;
    }
}
