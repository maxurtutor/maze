package org.luxoft.tutor.maze.domain;

import org.junit.Test;
import org.luxoft.tutor.mazeframework.domain.Door;
import org.luxoft.tutor.mazeframework.domain.MapSite;
import org.luxoft.tutor.mazeframework.domain.MapSiteFactory;
import org.luxoft.tutor.mazeframework.domain.Maze;
import org.luxoft.tutor.mazeframework.domain.Room;
import org.luxoft.tutor.mazeframework.domain.Side;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class MazeGameTest {

    @Test
    public void testCreateMaze() throws Exception {
        MapSiteFactory.setInstance(new MapSiteFactoryImpl());

        final Maze maze = MazeGame.get().createMaze();
        final Room r1 = maze.roomNo(1);
        final Room r2 = maze.roomNo(2);
        final MapSite site = r1.getSide(Side.EAST);
        final Door door = (Door) site;

        assertEquals(r1, door.otherSideFrom(r2));
        assertEquals(r2, door.otherSideFrom(r1));

        assertTrue(r1.getSide(Side.EAST) instanceof DoorImpl);
        assertTrue(r2.getSide(Side.WEST) instanceof DoorImpl);
        assertTrue(r1.getSide(Side.NORTH) instanceof MagicDecorator);
    }


    @Test
    public void testWallIsFlyweight() throws Exception {
        MapSiteFactory.setInstance(new MapSiteFactoryImpl());

        final Maze maze = MazeGame.get().createMaze();
        final Room r1 = maze.roomNo(1);
        final Room r2 = maze.roomNo(2);

        MapSite wall = MapSiteFactory.get().makeSharedMapSite("wall");


        assertSame(wall, r1.getSide(Side.SOUTH));
        assertSame(wall, r1.getSide(Side.WEST));

        assertSame(wall, r2.getSide(Side.NORTH));
        assertSame(wall, r2.getSide(Side.EAST));
        assertSame(wall, r2.getSide(Side.SOUTH));
    }
}