package org.luxoft.tutor.mazeframework.domain;

public abstract class MapSite {

	public abstract void enter(Player player);

    public abstract String asString();

	void onAssign(Room room) {
	}

}
