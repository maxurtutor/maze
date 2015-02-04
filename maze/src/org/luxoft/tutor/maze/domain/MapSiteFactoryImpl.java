package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.mazeframework.domain.Door;
import org.luxoft.tutor.mazeframework.domain.MapSite;
import org.luxoft.tutor.mazeframework.domain.MapSiteFactory;
import org.luxoft.tutor.mazeframework.domain.Room;
import org.luxoft.tutor.mazeframework.domain.Wall;

public class MapSiteFactoryImpl extends MapSiteFactory {

    @Override
    public Wall makeWall() {
        return new WallImpl();
    }

    @Override
    public Door makeDoor() {
        return new DoorImpl();
    }

    @Override
    public Room makeRoom(int number, MapSite northSite, MapSite eastSite, MapSite southSite, MapSite westSite) {
        return new RoomImpl(number, northSite, eastSite, southSite, westSite);
    }
}
