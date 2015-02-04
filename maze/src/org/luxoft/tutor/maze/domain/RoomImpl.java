package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.mazeframework.domain.MapSite;
import org.luxoft.tutor.mazeframework.domain.Player;
import org.luxoft.tutor.mazeframework.domain.Room;

import static java.lang.String.format;

public class RoomImpl extends Room {

    private RoomImpl(int number, MapSite northSite, MapSite eastSite, MapSite southSite, MapSite westSite) {
		super(number, northSite, eastSite, southSite, westSite);
	}

	@Override
	public void enter(Player player) {
        player.visit(this);
        player.moveToRoom(this);
	}

    @Override
    public String asString() {
        return format("Room %d", getRoomNumber());
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private int number;
        private MapSite northSite = new WallImpl();
        private MapSite eastSite = new WallImpl();
        private MapSite southSite = new WallImpl();
        private MapSite westSite = new WallImpl();

        private Builder() {
        }

        public Builder number(int number) {
            this.number = number;
            return this;
        }

        public Builder north(MapSite northSite) {
            this.northSite = northSite;
            return this;
        }

        public Builder east(MapSite eastSite) {
            this.eastSite = eastSite;
            return this;
        }

        public Builder south(MapSite southSite) {
            this.southSite = southSite;
            return this;
        }

        public Builder west(MapSite westSite) {
            this.westSite = westSite;
            return this;
        }

        public RoomImpl build() {
            return new RoomImpl(number, northSite, eastSite, southSite, westSite);
        }

    }


}
