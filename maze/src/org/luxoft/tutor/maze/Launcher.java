package org.luxoft.tutor.maze;

import org.luxoft.tutor.maze.domain.MapSiteFactoryImpl;
import org.luxoft.tutor.maze.view.Controller;
import org.luxoft.tutor.maze.view.ViewMazeGame;
import org.luxoft.tutor.maze.view.ViewMenu;
import org.luxoft.tutor.mazeframework.domain.MapSiteFactory;
import org.luxoft.tutor.mazeframework.view.View;

public class Launcher {

    public static void main(String[] args) throws Exception {
        MapSiteFactory.setInstance(new MapSiteFactoryImpl());
        View viewGame = new ViewMazeGame();
        View viewMenu = new ViewMenu();
        Controller controller = new Controller(viewGame, viewMenu);
        viewMenu.show();
        controller.run();
    }

}
