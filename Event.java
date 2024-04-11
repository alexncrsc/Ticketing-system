public class Event {
    private int id;
    private String name;
    private String date;
    private String location;
    private double ticketPrice;

    public Event(int id, String name, String date, String location, double ticketPrice) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.location = location;
        this.ticketPrice = ticketPrice;
    }

    // Metode de acces
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
}
