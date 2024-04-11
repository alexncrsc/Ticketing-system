public class VIPCustomer extends Customer {
    private String vipLevel;

    public VIPCustomer(int customerId, String name, String email, String vipLevel) {
        super(customerId, name, email); // Apelăm constructorul clasei de bază
        this.vipLevel = vipLevel;
    }

    // Getter pentru vipLevel

    @Override
    public String toString() {
        return "VIPCustomer{" +
                "customerId=" + getCustomerId() +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", vipLevel='" + vipLevel + '\'' +
                '}';
    }
}
