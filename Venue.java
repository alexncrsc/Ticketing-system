public class Venue {
    private int id;
    private String name;
    private String address;

    public Venue(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    // Metode de acces
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
