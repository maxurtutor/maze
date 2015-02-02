package org.luxoft.tutor.mazeframework.domain;

public abstract class Door extends MapSite {

	private Room room1 = null;
	private Room room2 = null;
	private boolean open = false;

	public Door(Room room2, Room room1) {
		this.room2 = room2;
		this.room1 = room1;
	}

	public boolean isOpen() {
		return open;
	}

	public void open() {
		this.open = true;
	}

	public void close() {
		this.open = false;
	}

	public Room otherSideFrom(Room room) {
        assert(null != room);
		if (room1.equals(room)) {
			return room2;
		} else if (room2.equals(room)) {
			return room1;
		} else {
			return null;
		}
	}
}
