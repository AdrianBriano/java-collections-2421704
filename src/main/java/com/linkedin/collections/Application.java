package com.linkedin.collections;

import java.util.HashMap;
import java.util.Map;

public class Application {

	public static void main(String[] args) {

		Room piccadilly = new Room("Piccadilly", "Guest Room", 3, 125.00);
		Room oxford = new Room("Oxford", "Suite", 5, 225.0);
		Guest john = new Guest("John", "Doe", false);
		Guest maria = new Guest("Maria", "Doe", true);

		Map<Room, Guest> roomGuestMap = new HashMap<>();
		roomGuestMap.put(oxford, maria);
		roomGuestMap.put(piccadilly, john);

		Guest guest =  roomGuestMap.put(piccadilly, roomGuestMap.remove(oxford));
		roomGuestMap.putIfAbsent(oxford, guest);

		System.out.println("Oxford: " + roomGuestMap.get(new Room("Oxford", "Suite", 5, 225.0)	));
		System.out.println("Piccadilly: " + roomGuestMap.get(piccadilly));
	}

}
