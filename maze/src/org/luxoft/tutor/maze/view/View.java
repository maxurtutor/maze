package org.luxoft.tutor.maze.view;

import org.luxoft.tutor.maze.domain.MazeGame;

public class View {

    private final MazeGame game;

    public View(MazeGame game) {
        this.game = game;
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
        info("Room %d \n", game.currentRoom().getRoomNumber());
    }
}
