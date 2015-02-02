package org.luxoft.tutor.mazeframework.domain;

import java.util.EnumMap;

public abstract class Room extends MapSite {

	private Integer roomNumber;

	private EnumMap<Side, MapSite> sites = new EnumMap<>(Side.class);

	public Room(int number) {
		this.roomNumber = number;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public MapSite getSide(Side side) {
		return sites.get(side);
	}

	public void setSide(Side side, MapSite site) {
		sites.put(side, site);
	}
}
