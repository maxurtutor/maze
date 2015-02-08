package org.luxoft.tutor.mazeframework.view.console;

import org.luxoft.tutor.mazeframework.view.View;

public abstract class ViewConsoleImpl implements View {

    public void error(String message) {
        System.out.println(message);
    }

    public void info(String message, Object... args) {
        System.out.printf(message + "\n", args);
    }
}
