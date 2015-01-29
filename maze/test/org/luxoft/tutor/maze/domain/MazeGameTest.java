package org.luxoft.tutor.maze.domain;

import org.junit.Test;
import org.luxoft.tutor.mazeframework.domain.MapSite;
import org.luxoft.tutor.mazeframework.domain.Side;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MazeGameTest {

    @Test
    public void testCreateMaze() throws Exception {
        final Maze maze = new MazeGame().createMaze();
        final Room r1 = maze.roomNo(1);
        final Room r2 = maze.roomNo(2);
        final MapSite site = r1.getSide(Side.EAST);
        final Door door = (Door) site;

        assertEquals(r1, door.otherSideFrom(r2));
        assertEquals(r2, door.otherSideFrom(r1));

        assertTrue(r1.getSide(Side.WEST) instanceof Wall);
        assertTrue(r1.getSide(Side.EAST) instanceof Door);
        assertTrue(r1.getSide(Side.NORTH) instanceof Wall);
        assertTrue(r1.getSide(Side.SOUTH) instanceof Wall);

        assertTrue(r2.getSide(Side.WEST) instanceof Door);
        assertTrue(r2.getSide(Side.EAST) instanceof Wall);
        assertTrue(r2.getSide(Side.NORTH) instanceof Wall);
        assertTrue(r2.getSide(Side.SOUTH) instanceof Wall);
    }
}