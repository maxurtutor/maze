package org.luxoft.tutor.maze;

import org.luxoft.tutor.maze.domain.MapSiteFactoryImpl;
import org.luxoft.tutor.maze.domain.MazeGameImpl;
import org.luxoft.tutor.maze.view.MenuImpl;
import org.luxoft.tutor.maze.view.ViewMazeGame;
import org.luxoft.tutor.maze.view.ViewMenu;
import org.luxoft.tutor.mazeframework.domain.MapSiteFactory;
import org.luxoft.tutor.mazeframework.domain.MazeGame;
import org.luxoft.tutor.mazeframework.view.Menu;
import org.luxoft.tutor.mazeframework.view.console.Controller;

public class Launcher {

    public static void main(String[] args) throws Exception {
        MapSiteFactory.setInstance(new MapSiteFactoryImpl());
        MazeGame mazeGame = new MazeGameImpl(new ViewMazeGame());

        MenuImpl menu = new MenuImpl(new ViewMenu(), mazeGame);
        Menu.setInstance(menu);
        menu.show();

        Controller controller = new Controller(mazeGame, menu);
        controller.run();
    }

}
