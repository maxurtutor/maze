package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.mazeframework.domain.Door;
import org.luxoft.tutor.mazeframework.domain.Room;

public class DoorImpl extends Door {

	public DoorImpl(Room room1, Room room2) {
		super(room2, room1);
		assert(null != room1 && null != room2);
	}

	@Override
	public void enter() {
		// TODO Auto-generated method stub
	}

}
