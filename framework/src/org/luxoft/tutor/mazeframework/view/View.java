package org.luxoft.tutor.mazeframework.view;

public interface View {

    void error(String message);

    void info(String message, Object... args);

    void show();
}
