package org.luxoft.tutor.mazeframework.domain;

import java.util.HashMap;
import java.util.Map;

public abstract class Maze extends MapCell {

	private final Map<Integer, MapCell> cells = new HashMap<>();

    public Maze(int number) {
        super(number);
    }

    public <T extends MapCell> T cellBy(int number) {
        //noinspection unchecked
        return (T) cells.get(number);
	}

	public void addCell(MapCell cell) {
		cells.put(cell.getNumber(), cell);
	}

    @Override
    public void enter(Player player) {
        final MapCell firstCell = cells.values().iterator().next();
        firstCell.enter(player);
    }

}
