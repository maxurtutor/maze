package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.mazeframework.domain.Door;
import org.luxoft.tutor.mazeframework.domain.Player;

public class DoorImpl extends Door {

	@Override
	public void enter(Player player) {
        player.visit(this);
        otherSideFrom(player.currentRoom()).enter(player);
	}

    @Override
    public String asString() {
        return "Door";
    }

}
