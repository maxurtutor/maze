package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.mazeframework.domain.MapSiteFactory;
import org.luxoft.tutor.mazeframework.domain.Player;
import org.luxoft.tutor.mazeframework.domain.Side;

public class MazeGame {

    private static MazeGame instance = new MazeGame();

    private final Player player;

    public static MazeGame get() {
        return instance;
    }

    private MazeGame() {
        final MapSiteFactory factory = MapSiteFactory.get();
        player = new PlayerImpl();
        factory.makeMaze(0).enter(player);
    }

    public String asString() {
        return player.asString();
    }

    public void goTo(Side side) {
        player.moveTo(side);
    }
}
