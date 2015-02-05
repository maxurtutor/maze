package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.mazeframework.domain.Maze;
import org.luxoft.tutor.mazeframework.domain.Player;

public class MazeImpl extends Maze {

    public MazeImpl(int number) {
        super(number);
    }

    @Override
    public void enter(Player player) {
        super.enter(player);
        player.visit(this);
    }

    @Override
    public String asString() {
        return "Maze";
    }

}
