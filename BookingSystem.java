import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import SalesReport;

public class BookingSystem {
    private List<Event> events;
    private Map<Integer, Venue> venueMap;
    private List<Customer> customers;
    private List<Ticket> tickets;
    private List<Reservation> reservations;
    private Map<Event, List<ElectronicTicket>> electronicTicketsMap;
    private SalesReport salesReport;

    public BookingSystem() {
        this.events = new ArrayList<>();
        this.venueMap = new HashMap<>();
        this.customers = new ArrayList<>();
        this.tickets = new ArrayList<>();
        this.reservations = new ArrayList<>();
        this.electronicTicketsMap = new HashMap<>();
        this.salesReport = new SalesReport();
    }

    // Metode pentru acțiuni specifice din sistem

    // 1. Adăugare eveniment nou
    public void addEvent(Event event) {
        events.add(event);
    }

    // 2. Vizualizare lista evenimentelor disponibile
    public List<Event> getAllEvents() {
        return events;
    }
    
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // 3. Căutare eveniment după nume 
    public Event findEventByName(String name) {
        for (Event event : events) {
            if (event.getName().equalsIgnoreCase(name)) {
                return event;
            }
        }
        return null;
    }

    public Venue getVenueById(int venueId) {
        return venueMap.get(venueId);
    }

    //dupa data
    public Event findEventByDate(String date) {
        for (Event event : events) {
            if (event.getDate().equalsIgnoreCase(date)) {
                return event;
            }
        }
        return null;
    }

    // 4. Adăugare locație nouă
   public void addVenue(Venue venue) {
        venueMap.put(venue.getId(), venue);
    }

    // 5. Rezervare bilete pentru eveniment
    public void reserveTickets(Event event, Customer customer, int numberOfTickets) {
        if (event != null && customer != null && numberOfTickets > 0) {
            Reservation reservation = new Reservation(reservations.size() + 1, customer, event, numberOfTickets);
            reservations.add(reservation);

            // Generare bilet electronic pentru fiecare bilet rezervat
            List<ElectronicTicket> electronicTickets = new ArrayList<>();
            for (int i = 0; i < numberOfTickets; i++) {
                String barcode = generateBarcode();
                ElectronicTicket electronicTicket = new ElectronicTicket(electronicTickets.size() + 1, new Ticket(tickets.size() + 1, customer, event), barcode);
                electronicTickets.add(electronicTicket);
            }
            electronicTicketsMap.put(event, electronicTickets);
        }
    }

    // Metodă utilitară pentru generarea unui cod de bare simplu
    private String generateBarcode() {
        // Implementare simplă pentru generarea unui cod de bare aleator
        return "E-TICKET-" + System.currentTimeMillis();
    }

    // 6. Anulare rezervare bilet
    public void cancelReservation(Reservation reservation) {
        if (reservation != null) {
            reservations.remove(reservation);

            // Eliminare bilet electronic asociat rezervării
            List<ElectronicTicket> electronicTickets = electronicTicketsMap.get(reservation.getEvent());
            if (electronicTickets != null) {
                electronicTickets.removeIf(eTicket -> eTicket.getTicket().getId() == reservation.getId());
            }
        }
    }

    // 7. Vizualizare istoric rezervări pentru client
    public List<Reservation> getCustomerReservationHistory(Customer customer) {
        List<Reservation> history = new ArrayList<>();
        for (Reservation reservation : reservations) {
            if (reservation.getCustomer().getId() == customer.getId()) {
                history.add(reservation);
            }
        }
        return history;
    }

    // 8. Calcul cost total pentru rezervări
    public double calculateTotalCostForCustomer(Customer customer) {
        double totalCost = 0.0;
        for (Reservation reservation : reservations) {
            if (reservation.getCustomer().getId() == customer.getId()) {
                totalCost += reservation.getNumberOfTickets() * reservation.getEvent().getTicketPrice();
            }
        }
        return totalCost;
    }

    // 9. Generare rapoarte și statistici despre vânzări
    public void generateSalesReport() {
        salesReport.generateReport();
    }


    
    
}
