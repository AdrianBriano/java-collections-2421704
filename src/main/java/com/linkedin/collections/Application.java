package com.linkedin.collections;

import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String[] args) {

		Guest john = new Guest("John", "Doe", false);
		Guest maria = new Guest("Maria", "Doe", false);
		Guest sonia = new Guest("Sonia", "Doe", true);
		Guest siri = new Guest("Siri", "Doe", true);

		List<Guest> guests = new ArrayList<Guest>(100);
		guests.add(john);
		guests.add(maria);
		print(guests);

		guests.add(0, sonia);
		print(guests);

		guests.get(2).setLoyaltyProgramMember(true);

		guests.addAll(1, List.of(maria, siri));
		print(guests);

		guests.remove(guests.size() - 1);
		print(guests);

		System.out.println(guests.indexOf(john)+1);
	}

	public static void print(List<Guest> list) {

		System.out.format("%n--List Contents--%n");

		for (int x = 0; x < list.size(); x++) {
			Guest guest = list.get(x);
			System.out.format("%x: %s %n", x, guest.toString());
		}
		
	}
}
