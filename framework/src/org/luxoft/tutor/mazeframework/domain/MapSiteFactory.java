package org.luxoft.tutor.mazeframework.domain;

public abstract class MapSiteFactory {

    private static MapSiteFactory instance;

    public static void setInstance(MapSiteFactory instance) {
        MapSiteFactory.instance = instance;
    }

    public static MapSiteFactory get() {
        return instance;
    }

    public abstract Wall makeWall();

    public abstract Door makeDoor();

    public abstract Room makeRoom(int number, MapSite northSite, MapSite eastSite, MapSite southSite, MapSite westSite);

}
