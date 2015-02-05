package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.mazeframework.domain.MapSite;
import org.luxoft.tutor.mazeframework.domain.Player;
import org.luxoft.tutor.mazeframework.domain.Room;

import static java.lang.String.format;

public class RoomImpl extends Room {

    RoomImpl(int number, MapSite northSite, MapSite eastSite, MapSite southSite, MapSite westSite) {
		super(number, northSite, eastSite, southSite, westSite);
	}

	@Override
	public void enter(Player player) {
        super.enter(player);
        player.visit(this);
	}

    @Override
    public String asString() {
        return format("Room %d", getNumber());
    }


}
