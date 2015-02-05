package org.luxoft.tutor.maze;

import org.luxoft.tutor.maze.domain.MapSiteFactoryImpl;
import org.luxoft.tutor.maze.view.Controller;
import org.luxoft.tutor.maze.view.View;
import org.luxoft.tutor.mazeframework.domain.MapSiteFactory;

public class Launcher {

    public static void main(String[] args) throws Exception {
        MapSiteFactory.setInstance(new MapSiteFactoryImpl());
        View view = new View();
        Controller controller = new Controller(view);

        view.printMenu();
        controller.run();
    }

}
