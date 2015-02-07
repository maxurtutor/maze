package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.mazeframework.domain.Door;
import org.luxoft.tutor.mazeframework.domain.MapSite;
import org.luxoft.tutor.mazeframework.domain.MapSiteFactory;
import org.luxoft.tutor.mazeframework.domain.Maze;
import org.luxoft.tutor.mazeframework.domain.Room;
import org.luxoft.tutor.mazeframework.domain.RoomProxy;

import static org.luxoft.tutor.maze.domain.MagicDecorator.magic;

public class MapSiteFactoryImpl extends MapSiteFactory {


    @Override
    protected void init() {
        persist("wall", new WallImpl());
        persist("door", new DoorImpl());
        persist("magicWall", magic(new WallImpl()));
        persist("maze0", createMaze0());
        persist("maze3", createMaze3());
    }

    @Override
    public Room makeRoom(Integer number, MapSite northSite, MapSite eastSite, MapSite southSite, MapSite westSite) {
        if (number == null) {
            throw new IllegalArgumentException("The room number must not be null");
        }
        return new RoomImpl(number, northSite, eastSite, southSite, westSite);
    }

    @Override
    public Maze makeMaze(Integer number) {
        return makeSharedMapSite(mazeId(number));
    }

    private Maze createMaze3() {
        Maze result = new MazeImpl(3);
        Door door2 = makeMapSite("door");
        result.addCell(
                Room.builder()
                        .number(101)
                        .north(door2)
                        .build()
        );
        RoomProxy.proxyBuilder()
                .number(-1)
                .south(door2)
                .targetMaze(0)
                .targetRoom(1)
                .build();
        return result;
    }

    private Maze createMaze0() {
        Maze result = new MazeImpl(0);
        Door door1 = makeMapSite("door");
        Door door2 = makeMapSite("door");
        result.addCell(
                Room.builder()
                        .number(1)
                        .north(makeMapSite("magicWall"))
                        .east(door1)
                        .south(door2)
                        .build()
        );
        result.addCell(
                Room.builder()
                        .number(2)
                        .west(door1)
                        .build()
        );
        RoomProxy.proxyBuilder()
                .number(-1)
                .north(door2)
                .targetMaze(3)
                .targetRoom(101)
                .build();
        return result;
    }

    private String mazeId(Integer number) {
        return "maze" + number;
    }


}
