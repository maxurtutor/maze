package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.mazeframework.domain.Door;
import org.luxoft.tutor.mazeframework.domain.Room;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MazeGame {

    public static void main(String[] args) throws Exception {
        printMenu();
        new MazeGame().run();
    }

    public Maze createMaze() {
        Maze aMaze = new Maze();
        Door theDoor = new DoorImpl();
        Room r1 = new RoomImpl(1, new WallImpl(), theDoor, new WallImpl(), new WallImpl());
        aMaze.addRoom(r1);
        Room r2 = new RoomImpl(2, new WallImpl(), new WallImpl(), new WallImpl(), theDoor);
        aMaze.addRoom(r2);
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
