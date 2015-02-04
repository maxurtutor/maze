package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.mazeframework.domain.MapSite;
import org.luxoft.tutor.mazeframework.domain.MapSiteFactory;
import org.luxoft.tutor.mazeframework.domain.Room;

public class MapSiteFactoryImpl extends MapSiteFactory {

    public MapSiteFactoryImpl() {
        persist("wall", new WallImpl());
        persist("door", new DoorImpl());
    }

    @Override
    public Room makeRoom(Integer number, MapSite northSite, MapSite eastSite, MapSite southSite, MapSite westSite) {
        if (number == null) {
            throw new IllegalArgumentException("The room number must not be null");
        }
        return new RoomImpl(number, northSite, eastSite, southSite, westSite);
    }
}
