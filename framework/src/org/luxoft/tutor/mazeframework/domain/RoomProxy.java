package org.luxoft.tutor.mazeframework.domain;

public class RoomProxy extends Room {

    private final int targetMazeId;

    private final int targetRoomId;

    private Room room;

    protected RoomProxy(
            int number,
            MapSite northSite,
            MapSite eastSite,
            MapSite southSite,
            MapSite westSite,
            int targetMazeId,
            int targetRoomId
    ) {
        super(number, northSite, eastSite, southSite, westSite);
        this.targetMazeId = targetMazeId;
        this.targetRoomId = targetRoomId;
    }

    @Override
    public String asString() {
        if (room == null) {
            loadRoom();
        }
        return room.asString();
    }

    @Override
    public void enter(Player player) {
        if (room == null) {
            loadRoom();
        }
        room.enter(player);

    }

    public MapSite getSide(Side side) {
        if (room == null) {
            loadRoom();
        }
        return room.getSide(side);
    }

    private void loadRoom() {
        MapSiteFactory factory = MapSiteFactory.get();
        Maze maze = factory.makeMaze(targetMazeId);
        this.room = maze.cellBy(targetRoomId);
    }


    public static Builder proxyBuilder() {
        return new Builder();
    }


    public static class Builder {

        private MapSiteFactory factory = MapSiteFactory.get();

        private Integer number;
        private MapSite northSite = factory.<Wall>makeSharedMapSite("wall");
        private MapSite eastSite  = factory.<Wall>makeSharedMapSite("wall");
        private MapSite southSite = factory.<Wall>makeSharedMapSite("wall");
        private MapSite westSite  = factory.<Wall>makeSharedMapSite("wall");
        private int targetMazeId;
        private int targetRoomId;

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

        public Builder targetMaze(int targetMazeId) {
            this.targetMazeId = targetMazeId;
            return this;
        }

        public Builder targetRoom(int targetRoomId) {
            this.targetRoomId = targetRoomId;
            return this;
        }

        public RoomProxy build() {
            return new RoomProxy(number, northSite, eastSite, southSite, westSite, targetMazeId, targetRoomId);
        }


    }



}
