package org.luxoft.tutor.maze.view;

import org.luxoft.tutor.maze.domain.MazeGame;
import org.luxoft.tutor.mazeframework.domain.Side;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {

    private final MazeGame mazeGame;
    private final Menu menu;

    public Controller(MazeGame mazeGame, Menu menu) {
        this.mazeGame = mazeGame;
        this.menu = menu;
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
                        menu.show();
                        break;
                    case "Q":
                        mazeGame.info("Good bay!");
                        break loop;
                    default:
                        mazeGame.error("Unknown command");
                }

            } while (true);
        }
    }

    private void goTo(Side side) {
        mazeGame.info(side.toString());
        mazeGame.goTo(side);
        mazeGame.show();
    }

}
