package org.luxoft.tutor.maze;

import org.luxoft.tutor.maze.domain.MazeGame;
import org.luxoft.tutor.maze.view.Controller;
import org.luxoft.tutor.maze.view.View;
import org.luxoft.tutor.mazeframework.domain.Player;

public class Launcher {

    public static void main(String[] args) throws Exception {
        MazeGame game = new MazeGame();
        Player player = game.getPlayer();

        View view = new View(player);
        Controller controller = new Controller(view, player);

        view.printMenu();
        controller.run();
    }

}
