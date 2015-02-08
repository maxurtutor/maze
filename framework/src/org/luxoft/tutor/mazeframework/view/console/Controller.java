package org.luxoft.tutor.mazeframework.view.console;

import org.luxoft.tutor.mazeframework.domain.MazeGame;
import org.luxoft.tutor.mazeframework.view.Menu;

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
            do {
                menu.getItem(br.readLine()).execute();
            } while (!mazeGame.isTerminated());
        }
    }

}
