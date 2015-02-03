package org.luxoft.tutor.maze;

import org.luxoft.tutor.maze.domain.MazeGame;
import org.luxoft.tutor.maze.view.Controller;
import org.luxoft.tutor.maze.view.View;

public class Launcher {

    public static void main(String[] args) throws Exception {
        MazeGame game = new MazeGame();
        View view = new View(game);
        view.printMenu();
        Controller controller = new Controller(view, game);
        controller.run();
    }

}
