package com.linkedin.collections;

import java.util.*;

public class Application {

	public static void main(String[] args) {

		Guest john = new Guest("John", "Doe", false);
		Guest bob = new Guest("Bob", "Doe", false);
		Guest sonia = new Guest("Sonia", "Doe", true); //loyalty program
		Guest siri = new Guest("Siri", "Doe", true); //loyalty program

		Comparator<Guest> programComp = Comparator.comparing(Guest::isLoyaltyProgramMember).reversed();
		Queue<Guest> checkInQueue = new PriorityQueue<>(programComp);

		checkInQueue.offer(john);
		checkInQueue.offer(bob);
		checkInQueue.offer(sonia);
		checkInQueue.offer(siri);
		print(checkInQueue);

		Guest guest1 = checkInQueue.poll();
		print(checkInQueue);
		System.out.println(guest1);

		Guest guest2 = checkInQueue.peek();
		print(checkInQueue);
		System.out.println(guest2);

	}

	public static void print(Queue<Guest> queue) {

		System.out.format("%n--Queue Contents--%n");

		int x = 0;
		for(Guest guest : queue) {
			System.out.format("%x: %s %s %n", x++, guest.toString(), x == 1 ? "(Head)":"");
		}
		
		System.out.println("");
		
	}
}
