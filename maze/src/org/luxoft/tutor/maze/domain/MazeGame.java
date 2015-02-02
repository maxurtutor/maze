package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.mazeframework.domain.Door;
import org.luxoft.tutor.mazeframework.domain.MapSite;
import org.luxoft.tutor.mazeframework.domain.Room;
import org.luxoft.tutor.mazeframework.domain.Side;
import org.luxoft.tutor.mazeframework.domain.Wall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MazeGame {

    private Room currentRoom;

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
        Maze maze = createMaze();
        currentRoom = maze.roomNo(1);
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
                        moveTo(Side.WEST);
                        break;
                    case "N":
                        moveTo(Side.NORTH);
                        break;
                    case "S":
                        moveTo(Side.SOUTH);
                        break;
                    case "E":
                        moveTo(Side.EAST);
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

    private void moveTo(Side side) {
        System.out.println(side.toString());
        final MapSite site = currentRoom.getSide(side);
        if (site instanceof Wall) {
            System.out.println("Wall");
        } else if (site instanceof Door) {
            Door door = (Door) site;
            currentRoom = door.otherSideFrom(currentRoom);
            System.out.printf("Room %d \n", currentRoom.getRoomNumber());
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
