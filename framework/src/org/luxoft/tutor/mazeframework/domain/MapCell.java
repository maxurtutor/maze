package org.luxoft.tutor.mazeframework.domain;

public abstract class MapCell extends MapSite {

    protected final Integer number;

    public MapCell(int number) {
        this.number = number;
    }

    public Integer getNumber() {
		return number;
	}
}
