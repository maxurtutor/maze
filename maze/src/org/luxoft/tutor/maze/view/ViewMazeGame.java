package org.luxoft.tutor.maze.view;

import org.luxoft.tutor.maze.domain.MazeGame;
import org.luxoft.tutor.mazeframework.view.console.ViewConsoleImpl;

public class ViewMazeGame extends ViewConsoleImpl {

    @Override
    public void show() {
        info(MazeGame.get().asString());
    }
}
