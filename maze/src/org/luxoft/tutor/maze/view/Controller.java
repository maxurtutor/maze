package org.luxoft.tutor.maze.view;

import org.luxoft.tutor.maze.domain.MazeGame;
import org.luxoft.tutor.mazeframework.domain.Side;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {

    private final View view;
    private final MazeGame game;

    public Controller(View view, MazeGame game) {
        this.view = view;
        this.game = game;
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
                        view.printMenu();
                        break;
                    case "Q":
                        view.info("Good bay!");
                        break loop;
                    default:
                        view.error("Unknown command");
                }

            } while (true);
        }
    }

    private void goTo(Side side) {
        view.info(side.toString());
        game.moveTo(side);
        view.show();
    }

}
