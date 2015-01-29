package org.luxoft.tutor.maze.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.luxoft.tutor.mazeframework.domain.Side.EAST;
import static org.luxoft.tutor.mazeframework.domain.Side.NORTH;
import static org.luxoft.tutor.mazeframework.domain.Side.SOUTH;
import static org.luxoft.tutor.mazeframework.domain.Side.WEST;

public class MazeGame {

    public static void main(String[] args) throws Exception {
        printMenu();
        new MazeGame().run();
    }

    public Maze createMaze() {
        Maze aMaze = new Maze();
        Room r1 = new Room(1);
        Room r2 = new Room(2);
        Door theDoor = new Door(r1, r2);

        aMaze.addRoom(r1);
        aMaze.addRoom(r2);

        r1.setSide(NORTH, new Wall());
        r1.setSide(EAST, theDoor);
        r1.setSide(SOUTH, new Wall());
        r1.setSide(WEST, new Wall());

        r2.setSide(NORTH, new Wall());
        r2.setSide(EAST, new Wall());
        r2.setSide(SOUTH, new Wall());
        r2.setSide(WEST, theDoor);

        return aMaze;
    }


    private void run() throws IOException {

        final Maze maze = createMaze();
        Room currentRoom = maze.roomNo(1);
        try (
                InputStreamReader in = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(in)
        ) {
            String s;
loop:
            do {
                s = br.readLine();
                switch (s.toUpperCase()) {
                    case "W":
                        System.out.println("WEST");
                        if (currentRoom.getRoomNumber() == 2) {
                            currentRoom = maze.roomNo(1);
                            System.out.println("Room 1");
                        } else {
                            System.out.println("Wall");
                        }
                        break;
                    case "N":
                        System.out.println("NORTH");
                        System.out.println("Wall");
                        break;
                    case "S":
                        System.out.println("SOUTH");
                        System.out.println("Wall");
                        break;
                    case "E":
                        System.out.println("EAST");
                        if (currentRoom.getRoomNumber() == 1) {
                            currentRoom = maze.roomNo(2);
                            System.out.println("Room 2");
                        } else {
                            System.out.println("Wall");
                        }
                        break;
                    case "?":
                        printMenu();
                        break;
                    case "Q":
                        System.out.println("Good bay!");
                        break loop;
                    default:
                        System.out.println("Unknown command");
                }

            } while (true);
        }
    }

    private static void printMenu() {
        System.out.println("- MENU -");

        System.out.println("'W' Go to WEST");
        System.out.println("'N' Go to NORTH");
        System.out.println("'S' Go to SOUTH");
        System.out.println("'E' Go to EAST");

        System.out.println("'?' Print Menu");

        System.out.println("'Q' Exit");
    }



}
