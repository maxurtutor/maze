package org.luxoft.tutor.maze.view;

import org.luxoft.tutor.mazeframework.domain.Command;
import org.luxoft.tutor.mazeframework.view.Menu;
import org.luxoft.tutor.mazeframework.view.console.ViewConsoleImpl;

import java.util.Map;

public class ViewMenu extends ViewConsoleImpl<Menu> {

    @Override
    public void show(String resourceId, Menu data) {
        info("- %s -", resourceId);
        for (Map.Entry<String, Command> entry : data) {
            info("'%s' %s", entry.getKey(), entry.getValue());
        }
    }
}
