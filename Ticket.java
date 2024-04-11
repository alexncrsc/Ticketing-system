public class Ticket {
    private int id;
    private Customer customer;
    private Event event;

    public Ticket(int id, Customer customer, Event event) {
        this.id = id;
        this.customer = customer;
        this.event = event;
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
}
