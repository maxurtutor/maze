package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.mazeframework.domain.Door;
import org.luxoft.tutor.mazeframework.domain.Maze;
import org.luxoft.tutor.mazeframework.domain.Player;
import org.luxoft.tutor.mazeframework.domain.Room;

public class MazeGame {

    private final Player player;

    public MazeGame() {
        Maze maze = createMaze();
        player = new PlayerImpl(maze.roomNo(1));
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

    public Player getPlayer() {
        return player;
    }
}
