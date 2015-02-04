package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.mazeframework.domain.Door;
import org.luxoft.tutor.mazeframework.domain.Maze;
import org.luxoft.tutor.mazeframework.domain.Player;

public class MazeGame {

    private final Player player;

    public MazeGame() {
        Maze maze = createMaze();
        player = new PlayerImpl(maze.roomNo(1));
    }

    public Maze createMaze() {
        Maze aMaze = new Maze();
        Door theDoor = new DoorImpl();
        aMaze.addRoom(
                RoomImpl.builder()
                        .number(1)
                        .east(theDoor)
                        .build()
        );
        aMaze.addRoom(
                RoomImpl.builder()
                        .number(2)
                        .west(theDoor)
                        .build()
        );
        return aMaze;
    }

    public Player getPlayer() {
        return player;
    }
}
