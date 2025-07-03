package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.Booking;
import util.Session;

public class BookingService {
    private static final List<Booking> orders = new ArrayList<>();
    private static int idCounter = 1;

    public static void addBooking(String roomType, LocalDate in, LocalDate out) {
        orders.add(new Booking(idCounter++, roomType, in, out, Session.getUsername()));
    }

    public static List<Booking> getAll() {
        return new ArrayList<>(orders);
    }

    public static List<Booking> getByUser() {
        return orders.stream()
                     .filter(b -> b.getUsername().equals(Session.getUsername()))
                     .collect(Collectors.toList());
    }
}
