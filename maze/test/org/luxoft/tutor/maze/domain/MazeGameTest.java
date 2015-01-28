package org.luxoft.tutor.maze.domain;

import org.junit.Assert;
import org.junit.Test;

public class MazeGameTest {

    @Test
    public void testCreateMaze() throws Exception {
        final Maze maze = new MazeGame().createMaze();
        final Room r1 = maze.roomNo(1);
        final Room r2 = maze.roomNo(2);
        final MapSite side = r1.getSide(Side.EAST);
        final Door door = (Door) side;
        Assert.assertEquals(r1, door.otherSideFrom(r2));
    }
}