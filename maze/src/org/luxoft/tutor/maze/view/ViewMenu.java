package org.luxoft.tutor.maze.view;

import org.luxoft.tutor.mazeframework.view.console.ViewConsoleImpl;

public class ViewMenu extends ViewConsoleImpl {

    @Override
    public void show() {
        info("- MENU -");

        info("'W' Go to WEST");
        info("'N' Go to NORTH");
        info("'S' Go to SOUTH");
        info("'E' Go to EAST");

        info("'?' Print Menu");

        info("'Q' Exit");
    }
}
