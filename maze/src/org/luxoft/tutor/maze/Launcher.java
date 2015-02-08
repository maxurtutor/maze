package org.luxoft.tutor.maze;

import org.luxoft.tutor.maze.domain.MapSiteFactoryImpl;
import org.luxoft.tutor.maze.domain.MazeGame;
import org.luxoft.tutor.maze.view.Controller;
import org.luxoft.tutor.maze.view.Menu;
import org.luxoft.tutor.maze.view.ViewMazeGame;
import org.luxoft.tutor.maze.view.ViewMenu;
import org.luxoft.tutor.mazeframework.domain.MapSiteFactory;

public class Launcher {

    public static void main(String[] args) throws Exception {
        MapSiteFactory.setInstance(new MapSiteFactoryImpl());
        Menu menu = new Menu(new ViewMenu());
        MazeGame mazeGame = new MazeGame(new ViewMazeGame());
        Controller controller = new Controller(mazeGame, menu);
        menu.show();
        controller.run();
    }

}
