package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.mazeframework.domain.Room;

import java.util.HashMap;
import java.util.Map;

public class Maze {

	private final Map<Integer, Room> rooms = new HashMap<>();

	public Room roomNo(int number) {
		return rooms.get(number);
	}

	public void addRoom(Room room) {
		rooms.put(room.getRoomNumber(), room);
	}
}
