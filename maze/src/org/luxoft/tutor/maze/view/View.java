package org.luxoft.tutor.maze.view;

import org.luxoft.tutor.mazeframework.domain.Player;

public class View {

    private final Player player;

    public View(Player player) {
        this.player = player;
    }

    public void printMenu() {
        System.out.println("- MENU -");

        System.out.println("'W' Go to WEST");
        System.out.println("'N' Go to NORTH");
        System.out.println("'S' Go to SOUTH");
        System.out.println("'E' Go to EAST");

        System.out.println("'?' Print Menu");

        System.out.println("'Q' Exit");
    }

    public void error(String message) {
        System.out.println(message);
    }

    public void info(String message, Object... args) {
        System.out.printf(message + "\n", args);
    }

    public void show() {
        info(player.asString());
    }
}
