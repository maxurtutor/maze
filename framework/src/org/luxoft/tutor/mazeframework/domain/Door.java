package org.luxoft.tutor.mazeframework.domain;

public abstract class Door extends MapSite {

	private Room room1 = null;

	private Room room2 = null;

	private boolean open = false;


	public boolean isOpen() {
		return open;
	}

	public void open() {
		this.open = true;
	}

	public void close() {
		this.open = false;
	}

	@Override
	final void onAssign(Room room) {
		assert room != null;
		if (room1 == null) {
			room1 = room;
		} else if (room2 == null) {
			assert room1 != room;
			room2 = room;
		} else {
			assert false;
		}
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
