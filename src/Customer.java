import java.util.UUID;

public class Customer extends Person {
    private String customerID;
    private double balance;

      public Customer(String name, int age, String username, String password, double balance) {
        super(name, age, username, password);
        this.customerID = UUID.randomUUID().toString();
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerID() {
        return customerID;
    }

    @Override
    public String toString() {
        return super.toString() + ", Customer ID: " + customerID + ", Balance: " + balance;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Customer customer = (Customer) obj;
        return (getUsername().equals(customer.getUsername()) && getPassword().equals(customer.getPassword())) ||
                (customerID.equals(customer.getCustomerID()) && getPassword().equals(customer.getPassword()));
    }
    @Override
    public int hashCode() {
        return customerID.hashCode() + getPassword().hashCode();
    }
}
