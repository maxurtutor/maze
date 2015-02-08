package org.luxoft.tutor.mazeframework.domain;

public abstract class Displayed {

    private View implementation;

    protected Displayed(View implementation) {
        this.implementation = implementation;
    }

    public void show() {
        //noinspection unchecked
        implementation.show(getResourceId(), this);
    }

    public void error(String message) {
        implementation.error(message);
    }

    public void info(String message, Object... args) {
        implementation.info(message, args);
    }

    protected abstract String getResourceId();
}
