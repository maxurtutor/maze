package org.luxoft.tutor.mazeframework.domain;

import java.util.EnumMap;

public abstract class Room extends MapSite {

	private final Integer roomNumber;

	private final EnumMap<Side, MapSite> sites = new EnumMap<>(Side.class);

	protected Room(int number, MapSite northSite, MapSite eastSite, MapSite southSite, MapSite westSite) {
		this.roomNumber = number;
		setSide(Side.NORTH, northSite);
		setSide(Side.EAST, eastSite);
		setSide(Side.SOUTH, southSite);
		setSide(Side.WEST, westSite);
	}

    public static Builder builder() {
        return new Builder();
    }

    public Integer getRoomNumber() {
		return roomNumber;
	}

	public MapSite getSide(Side side) {
		return sites.get(side);
	}

	private void setSide(Side side, MapSite site) {
		sites.put(side, site);
		site.onAssign(this);
	}

    public static class Builder {

        private MapSiteFactory factory = MapSiteFactory.get();

        private int number;
        private MapSite northSite = factory.makeWall();
        private MapSite eastSite = factory.makeWall();
        private MapSite southSite = factory.makeWall();
        private MapSite westSite = factory.makeWall();

        private Builder() {
        }

        public Builder number(int number) {
            this.number = number;
            return this;
        }

        public Builder north(MapSite northSite) {
            this.northSite = northSite;
            return this;
        }

        public Builder east(MapSite eastSite) {
            this.eastSite = eastSite;
            return this;
        }

        public Builder south(MapSite southSite) {
            this.southSite = southSite;
            return this;
        }

        public Builder west(MapSite westSite) {
            this.westSite = westSite;
            return this;
        }

        public Room build() {
            return factory.makeRoom(number, northSite, eastSite, southSite, westSite);
        }

    }
}
