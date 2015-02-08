package org.luxoft.tutor.maze.view;

import org.luxoft.tutor.maze.domain.MazeGame;
import org.luxoft.tutor.mazeframework.domain.Side;
import org.luxoft.tutor.mazeframework.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {

    private final View viewGame;
    private final View viewMenu;

    public Controller(View viewGame, View viewMenu) {
        this.viewGame = viewGame;
        this.viewMenu = viewMenu;
    }

    public void run() throws IOException {

        try (
                InputStreamReader in = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(in)
        ) {
            String s;
            loop:
            do {
                s = br.readLine();
                switch (s.toUpperCase()) {
                    case "W":
                        goTo(Side.WEST);
                        break;
                    case "N":
                        goTo(Side.NORTH);
                        break;
                    case "S":
                        goTo(Side.SOUTH);
                        break;
                    case "E":
                        goTo(Side.EAST);
                        break;
                    case "?":
                        viewMenu.show();
                        break;
                    case "Q":
                        viewGame.info("Good bay!");
                        break loop;
                    default:
                        viewGame.error("Unknown command");
                }

            } while (true);
        }
    }

    private void goTo(Side side) {
        viewGame.info(side.toString());
        MazeGame.get().goTo(side);
        viewGame.show();
    }

}
