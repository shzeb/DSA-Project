import java.util.*;

public class HotelBooking {
    HashMap<Integer, String> rooms = new HashMap<>();

    HotelBooking() {
        rooms.put(101, null);
        rooms.put(102, null);
        rooms.put(201, null);
        rooms.put(202, null);
    }

    void bookRoom(int roomNo, String guest) {
        if (rooms.containsKey(roomNo) && rooms.get(roomNo) == null) {
            rooms.put(roomNo, guest);
            System.out.println("Room booked.");
        } else {
            System.out.println("Room not available.");
        }
    }

    void cancelBooking(int roomNo) {
        if (rooms.containsKey(roomNo)) {
            rooms.put(roomNo, null);
            System.out.println("Booking cancelled.");
        }
    }

    void checkAvailability() {
        System.out.println("Available Rooms:");
        for (Map.Entry<Integer, String> e : rooms.entrySet())
            if (e.getValue() == null)
                System.out.println(e.getKey());
    }

    void viewGuests() {
        for (Map.Entry<Integer, String> e : rooms.entrySet())
            System.out.println("Room " + e.getKey() + " : " +
                    (e.getValue() == null ? "Available" : e.getValue()));
    }

    void searchGuest(String guest) {
        for (Map.Entry<Integer, String> e : rooms.entrySet()) {
            if (guest.equalsIgnoreCase(e.getValue())) {
                System.out.println(guest + " is in room " + e.getKey());
                return;
            }
        }
        System.out.println("Guest not found.");
    }

    public static void main(String[] args) {
        HotelBooking h = new HotelBooking();

        h.bookRoom(101, "Ali");
        h.bookRoom(201, "Sara");

        h.viewGuests();
        h.checkAvailability();
        h.searchGuest("Sara");

        h.cancelBooking(101);
        h.viewGuests();
    }
}