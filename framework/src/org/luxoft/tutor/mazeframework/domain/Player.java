package org.luxoft.tutor.mazeframework.domain;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Player {

    private Room currentRoom;

    private AtomicInteger health = new AtomicInteger(100);

    public void moveTo(Side side) {
        final MapSite site = currentRoom.getSide(side);
        site.enter(this);
    }

    public void hit(Integer strength) {
        health.getAndAdd(-strength);
    }

    public AtomicInteger health() {
        return health;
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
