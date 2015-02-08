package org.luxoft.tutor.mazeframework.domain;

public interface View<T extends Displayed> {

    void error(String message);

    void info(String message, Object... args);

    void show(String resourceId, T data);
}
