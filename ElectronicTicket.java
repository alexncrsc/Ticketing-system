public class ElectronicTicket {
    private int id;
    private Ticket ticket;
    private String barcode;

    public ElectronicTicket(int id, Ticket ticket, String barcode) {
        this.id = id;
        this.ticket = ticket;
        this.barcode = barcode;
    }

    // Metode de acces
    public int getId() {
        return id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public String getBarcode() {
        return barcode;
    }
}
