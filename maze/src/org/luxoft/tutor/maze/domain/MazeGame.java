package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.mazeframework.domain.Displayed;
import org.luxoft.tutor.mazeframework.domain.MapSiteFactory;
import org.luxoft.tutor.mazeframework.domain.Player;
import org.luxoft.tutor.mazeframework.domain.Side;
import org.luxoft.tutor.mazeframework.domain.View;

public class MazeGame extends Displayed {

    private final Player player;

    public MazeGame(View<MazeGame> implementation) {
        super(implementation);
        final MapSiteFactory factory = MapSiteFactory.get();
        player = new PlayerImpl();
        factory.makeMaze(0).enter(player);
    }

    public void goTo(Side side) {
        player.moveTo(side);
    }

    @Override
    protected String getResourceId() {
        return "Game";
    }

    public Player getCurrentPlayer() {
        return player;
    }
}
