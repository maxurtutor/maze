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
        player = new PlayerImpl();
        createMaze().enter(player);
    }

    public Maze createMaze() {
        Maze maze0 = new MazeImpl(0);
        final MapSiteFactory factory = MapSiteFactory.get();
        Door door1 = factory.makeMapSite("door");
        Door door2 = factory.makeMapSite("door");
        maze0.addCell(
                Room.builder()
                        .number(1)
                        .north(factory.makeMapSite("magicWall"))
                        .east(door1)
                        .south(door2)
                        .build()
        );
        maze0.addCell(
                Room.builder()
                        .number(2)
                        .west(door1)
                        .build()
        );
        Maze maze1 = new MazeImpl(3);
        maze1.addCell(
                Room.builder()
                        .number(101)
                        .north(door2)
                        .build()
        );
        return maze0;
    }


    public String asString() {
        return player.asString();
    }

    public void goTo(Side side) {
        player.moveTo(side);
    }
}
