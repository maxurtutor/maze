package org.luxoft.tutor.maze.view;

import org.luxoft.tutor.maze.domain.MazeGame;
import org.luxoft.tutor.mazeframework.view.console.ViewConsoleImpl;

public class ViewMazeGame extends ViewConsoleImpl<MazeGame> {

    @Override
    public void show(String resourceId, MazeGame data) {
        info(data.getCurrentPlayer().asString());
    }
}
