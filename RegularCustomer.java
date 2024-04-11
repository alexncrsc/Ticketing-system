public class RegularCustomer extends Customer {
    private double discountRate;

    public RegularCustomer(int customerId, String name, String email, double discountRate) {
        super(customerId, name, email); // Apelăm constructorul clasei de bază
        this.discountRate = discountRate;
    }

    // Getter pentru discountRate

    @Override
    public String toString() {
        return "RegularCustomer{" +
                "customerId=" + getCustomerId() +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", discountRate=" + discountRate +
                '}';
    }
}
