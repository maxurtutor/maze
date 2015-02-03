package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.mazeframework.domain.MapSite;
import org.luxoft.tutor.mazeframework.domain.Player;
import org.luxoft.tutor.mazeframework.domain.Room;

import static java.lang.String.format;

public class RoomImpl extends Room {

	public RoomImpl(int number, MapSite eastSite, MapSite northSite, MapSite westSite, MapSite southSite) {
		super(number, eastSite, northSite, westSite, southSite);
	}

	@Override
	public void enter(Player player) {
        player.visit(this);
        player.moveToRoom(this);
	}

    @Override
    public String asString() {
        return format("Room %d", getRoomNumber());
    }


}
