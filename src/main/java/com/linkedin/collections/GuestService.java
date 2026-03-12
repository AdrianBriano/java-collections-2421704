package com.linkedin.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GuestService {

	private List<Guest> checkinList = new LinkedList<>();

	public static List<Guest> filterByFavoriteRoom(List<Guest> guests, Room room) {

		/*
		 *  1. Returns a new collection that contains guests from the provided collection
		 *  who have indicated the provided room as the first preference in their preferred
		 *  room list. 
		 */
		return guests.stream()
				.filter(guest -> !guest.getPreferredRooms().isEmpty())
				.filter(guest -> guest.getPreferredRooms().get(0).equals(room))
				.collect(Collectors.toList());

	}

	public void checkIn(Guest guest) {
		
		/*
		 *  2. Adds a guest to the checkinList, placing members of the loyalty program
		 *  ahead of those guests not in the program. Otherwise, guests are arranged in the
		 *  order they were inserted.
		 */
		if (guest.isLoyaltyProgramMember() || checkinList.isEmpty()){
			Optional<Guest> lastLoyaltyProgramMember = checkinList.stream().filter(guest1 -> !guest1.isLoyaltyProgramMember()).findFirst();

			if (lastLoyaltyProgramMember.isPresent()) {
				int index = checkinList.indexOf(lastLoyaltyProgramMember.get());
				checkinList.add(index , guest);
			}  else {
				checkinList.add(guest);
			}

		} else {
			checkinList.add(guest);
		}
	}
	
	public void swapPosition(Guest guest1, Guest guest2) {
		
		/*
		 *  3.  Swaps the position of the two provided guests within the checkinList.
		 *  If guests are not currently in the list no action is required.
		 */
		if (checkinList.containsAll(List.of(guest1, guest2))) {

			int indexGuest1 = checkinList.indexOf(guest1);
			int indexGuest2 = checkinList.indexOf(guest2);

			checkinList.set(indexGuest1, guest2);
			checkinList.set(indexGuest2, guest1);
		}

	}

	public List<Guest> getCheckInList() {
		return List.copyOf(this.checkinList);
	}
}
