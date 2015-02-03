package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.mazeframework.domain.Door;
import org.luxoft.tutor.mazeframework.domain.MapSite;
import org.luxoft.tutor.mazeframework.domain.Room;
import org.luxoft.tutor.mazeframework.domain.Side;

public class MazeGame {

    private Room currentRoom;

    public MazeGame() {
        Maze maze = createMaze();
        currentRoom = maze.roomNo(1);
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

    public void moveTo(Side side) {
        final MapSite site = currentRoom.getSide(side);
        if (site instanceof Door) {
            currentRoom = ((Door) site).otherSideFrom(currentRoom);
        }
    }

    public Room currentRoom() {
        return currentRoom;
    }
}
