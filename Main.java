import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import SalesReport;
public class Main {
    public static void main(String[] args) {
        // Inițializare sistem de rezervări (BookingSystem)
        BookingSystem bookingSystem = new BookingSystem();

        // Adăugare evenimente și locații
        Event event1 = new Event(1, "Concert Travis Scott", "2024-05-15", "Stadium", 100.0);
        Event event2 = new Event(2, "Festival de Muzică", "2024-06-20", "Park", 50.0);
        bookingSystem.addEvent(event1);
        bookingSystem.addEvent(event2);

        // Adăugare clienți
        Customer customer1 = new Customer(1, "John Doe", "john@example.com");
        Customer customer2 = new Customer(2, "Jane Smith", "jane@example.com");
        
        List<Customer> customerList = new ArrayList<>();
        
        // Adăugare clienți de tip RegularCustomer și VIPCustomer în listă
        customerList.add(new RegularCustomer(3, "John Doe", "john@example.com", 0.1));
        customerList.add(new VIPCustomer(4, "Jane Smith", "jane@example.com", "Gold"));

        bookingSystem.addCustomer(customer1);
        bookingSystem.addCustomer(customer2);

        Venue venue1 = new Venue(1, "Stadium", "Main Street, City");
        Venue venue2 = new Venue(2, "Park", "Central Park, City");
        bookingSystem.addVenue(venue1);
        bookingSystem.addVenue(venue2);

        // Rezervare bilete pentru eveniment
        bookingSystem.reserveTickets(event1, customer1, 2);

        // Anulare rezervare
        Reservation reservationToCancel = bookingSystem.getCustomerReservationHistory(customer1).get(0);
        bookingSystem.cancelReservation(reservationToCancel);

        // Vizualizare istoric rezervări pentru un client
        List<Reservation> customerHistory = bookingSystem.getCustomerReservationHistory(customer1);
        System.out.println("Reservation History for " + customer1.getName() + ":");
        for (Reservation reservation : customerHistory) {
            System.out.println("Event: " + reservation.getEvent().getName() + ", Tickets: " + reservation.getNumberOfTickets());
        }

        // Calcul cost total pentru rezervări
        double totalCost = bookingSystem.calculateTotalCostForCustomer(customer1);
        System.out.println("Total Cost for " + customer1.getName() + ": " + totalCost + " RON");

        // Generare raport de vânzări
        bookingSystem.generateSalesReport();

        // Afișare toate evenimentele
        List<Event> allEvents = bookingSystem.getAllEvents();
        System.out.println("Lista evenimentelor disponibile:");
        for (Event event : allEvents) {
            System.out.println(event.getName() + " - " + event.getDate() + " at " + event.getLocation());
        }

        // Găsire locație după id
        Venue foundVenue = bookingSystem.getVenueById(1);
        if (foundVenue != null) {
            System.out.println("Locație găsită: " + foundVenue.getName() + " - " + foundVenue.getAddress());
        } else {
            System.out.println("Locație nu a fost găsită pentru id-ul specificat.");
        }
        
        for (Customer customer : customerList) {
           System.out.println(customer.getName());
        }
        
        SystemService systemService = new SystemServiceImpl();

        // Apelarea metodelor expuse de serviciu pentru a executa operațiile sistemului
        systemService.performAction1();
        String result = systemService.performAction2(123);
        System.out.println("Result of Action 2: " + result);
    }

    
}
