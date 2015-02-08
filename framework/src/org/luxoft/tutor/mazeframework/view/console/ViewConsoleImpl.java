package org.luxoft.tutor.mazeframework.view.console;

import org.luxoft.tutor.mazeframework.domain.Displayed;
import org.luxoft.tutor.mazeframework.domain.View;

public abstract class ViewConsoleImpl<T extends Displayed> implements View<T> {

    public void error(String message) {
        System.out.println(message);
    }

    public void info(String message, Object... args) {
        System.out.printf(message + "\n", args);
    }
}
