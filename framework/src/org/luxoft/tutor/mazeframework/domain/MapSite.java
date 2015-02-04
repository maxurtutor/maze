package org.luxoft.tutor.mazeframework.domain;

public abstract class MapSite implements Cloneable {

	public abstract void enter(Player player);

    public abstract String asString();

	void onAssign(Room room) {
	}

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
