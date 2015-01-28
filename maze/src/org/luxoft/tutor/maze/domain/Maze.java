package org.luxoft.tutor.maze.domain;

import java.util.HashMap;
import java.util.Map;

public class Maze {

	private Map<Integer, Room> rooms = new HashMap<Integer, Room>();

	public Room roomNo(int number) {
		return rooms.get(number);
	}

	public void addRoom(Room room) {
		rooms.put(room.getRoomNumber(), room);
	}
}
