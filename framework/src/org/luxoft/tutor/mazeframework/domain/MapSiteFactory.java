package org.luxoft.tutor.mazeframework.domain;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public abstract class MapSiteFactory {

    private static MapSiteFactory instance;

    public static void setInstance(MapSiteFactory instance) {
        MapSiteFactory.instance = instance;
        instance.init();
    }

    public static MapSiteFactory get() {
        return instance;
    }

    private final Map<String, MapSite> prototypes = new HashMap<>();

    public <T extends MapSite> T makeSharedMapSite(String kind) {
        final MapSite site = prototypes.get(kind.toLowerCase());
        if (site == null)  {
            throw new IllegalArgumentException(format("The site of '%s' was not found", kind));
        }
        try {
            //noinspection unchecked
            return (T) site;
        } catch (ClassCastException e) {
            throw new IllegalStateException(format("The site of '%s' has invalid type", kind));
        }
    }


    public <T extends MapSite> T makeMapSite(String kind) {
        try {
            //noinspection unchecked
            return (T) makeSharedMapSite(kind).clone();
        } catch (ClassCastException e) {
            throw new IllegalStateException(format("The site of '%s' has invalid type", kind));
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(format("The site of '%s' must be cloneable", kind));
        }
    }

    public void persist(String kind, MapSite site) {
        prototypes.put(kind.toLowerCase(), site);
    }

    protected abstract void init();

    public abstract Room makeRoom(
            Integer number,
            MapSite northSite,
            MapSite eastSite,
            MapSite southSite,
            MapSite westSite
    );


    public abstract Maze makeMaze(Integer number);

}
