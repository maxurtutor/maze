package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.mazeframework.domain.MapSite;
import org.luxoft.tutor.mazeframework.domain.Player;
import org.luxoft.tutor.mazeframework.domain.Room;
import org.luxoft.tutor.mazeframework.domain.Side;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class PlayerImpl extends Player {

    private final List<MapSite> lastPath = new ArrayList<>(10);

    public PlayerImpl(Room currentRoom) {
        super(currentRoom);
    }

    @Override
    public void moveTo(Side side) {
        lastPath.clear();
        super.moveTo(side);
    }

    @Override
    public void visit(MapSite site) {
        lastPath.add(site);
    }

    @Override
    public String asString() {
        String  result = "";
        for (MapSite site : lastPath) {
            result += format(" -> %s", site.asString());
        }
        result += format("\n\nHealth: %s\n", health());
        return result;
    }

}
