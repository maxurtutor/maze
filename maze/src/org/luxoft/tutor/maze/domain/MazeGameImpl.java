package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.mazeframework.domain.MapSiteFactory;
import org.luxoft.tutor.mazeframework.domain.MazeGame;
import org.luxoft.tutor.mazeframework.domain.Player;
import org.luxoft.tutor.mazeframework.domain.View;

public class MazeGameImpl extends MazeGame {

    private final Player player;

    public MazeGameImpl(View<MazeGame> implementation) {
        super(implementation);
        final MapSiteFactory factory = MapSiteFactory.get();
        player = new PlayerImpl();
        factory.makeMaze(0).enter(player);
    }

    @Override
    protected String getResourceId() {
        return "Game";
    }

    @Override public Player getCurrentPlayer() {
        return player;
    }
}
