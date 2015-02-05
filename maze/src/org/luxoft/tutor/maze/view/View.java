package org.luxoft.tutor.maze.view;

import org.luxoft.tutor.maze.domain.MazeGame;

public class View {

    public void printMenu() {
        info("- MENU -");

        info("'W' Go to WEST");
        info("'N' Go to NORTH");
        info("'S' Go to SOUTH");
        info("'E' Go to EAST");

        info("'?' Print Menu");

        info("'Q' Exit");
    }

    public void error(String message) {
        System.out.println(message);
    }

    public void info(String message, Object... args) {
        System.out.printf(message + "\n", args);
    }

    public void show() {
        info(MazeGame.get().asString());
    }
}
