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

}
