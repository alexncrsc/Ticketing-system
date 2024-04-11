public class Reservation {
    private int id;
    private Customer customer;
    private Event event;
    private int numberOfTickets;

    public Reservation(int id, Customer customer, Event event, int numberOfTickets) {
        this.id = id;
        this.customer = customer;
        this.event = event;
        this.numberOfTickets = numberOfTickets;
    }

    // Metode de acces
    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Event getEvent() {
        return event;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }
}
