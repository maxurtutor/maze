package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.mazeframework.domain.Door;
import org.luxoft.tutor.mazeframework.domain.MapSiteFactory;
import org.luxoft.tutor.mazeframework.domain.Maze;
import org.luxoft.tutor.mazeframework.domain.Player;
import org.luxoft.tutor.mazeframework.domain.Room;
import org.luxoft.tutor.mazeframework.domain.Side;

public class MazeGame {

    private static MazeGame instance = new MazeGame();

    private final Player player;

    public static MazeGame get() {
        return instance;
    }

    private MazeGame() {
        Maze maze = createMaze();
        player = new PlayerImpl(maze.roomNo(1));
    }

    public Maze createMaze() {
        Maze aMaze = new Maze();
        final MapSiteFactory factory = MapSiteFactory.get();
        Door theDoor = factory.makeMapSite("door");
        aMaze.addRoom(
                Room.builder()
                        .number(1)
                        .north(factory.makeMapSite("magicWall"))
                        .east(theDoor)
                        .build()
        );
        aMaze.addRoom(
                Room.builder()
                        .number(2)
                        .west(theDoor)
                        .build()
        );
        return aMaze;
    }


    public String asString() {
        return player.asString();
    }

    public void goTo(Side side) {
        player.moveTo(side);
    }
}
