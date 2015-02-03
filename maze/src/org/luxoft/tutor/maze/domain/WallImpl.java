package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.mazeframework.domain.Player;
import org.luxoft.tutor.mazeframework.domain.Wall;

public class WallImpl extends Wall {
	
	public void enter(Player player) {
		player.visit(this);
	}

    @Override
    public String asString() {
        return "Wall";
    }

}
