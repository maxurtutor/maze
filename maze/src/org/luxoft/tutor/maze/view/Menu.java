package org.luxoft.tutor.maze.view;

import org.luxoft.tutor.mazeframework.domain.Displayed;
import org.luxoft.tutor.mazeframework.domain.View;

public class Menu extends Displayed {

    public Menu(View implementation) {
        super(implementation);
    }

    @Override
    protected String getResourceId() {
        return "Main Menu";
    }

}
