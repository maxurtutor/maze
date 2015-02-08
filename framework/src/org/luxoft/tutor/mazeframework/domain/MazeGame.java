package org.luxoft.tutor.mazeframework.domain;

public abstract class MazeGame extends Displayed {

    private boolean terminated = false;

    public MazeGame(View implementation) {
        super(implementation);
    }

    public void goTo(Side side) {
        getCurrentPlayer().moveTo(side);
    }

    public boolean isTerminated() {
        return terminated;
    }

    public void terminate() {
        this.terminated = true;
    }

    public abstract Player getCurrentPlayer();
}
