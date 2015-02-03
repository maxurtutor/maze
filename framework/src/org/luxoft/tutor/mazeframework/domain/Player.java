package org.luxoft.tutor.mazeframework.domain;

public abstract class Player {

    private Room currentRoom;

    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void moveTo(Side side) {
        final MapSite site = currentRoom.getSide(side);
        site.enter(this);
    }

    public Room currentRoom() {
        return currentRoom;
    }

    public void moveToRoom(Room room) {
        this.currentRoom = room;
    }

    public abstract void visit(MapSite door);

    public abstract String asString();
}
