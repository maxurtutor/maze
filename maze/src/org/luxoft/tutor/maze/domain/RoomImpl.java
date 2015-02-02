package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.mazeframework.domain.MapSite;
import org.luxoft.tutor.mazeframework.domain.Room;

public class RoomImpl extends Room {

	public RoomImpl(int number, MapSite eastSite, MapSite northSite, MapSite westSite, MapSite southSite) {
		super(number, eastSite, northSite, westSite, southSite);
	}

	@Override
	public void enter() {
		// TODO Auto-generated method stub
	}

}
