import java.util.UUID;

public class Manager extends Person {
    private String managerID;
    private int actionNumber;
    public Manager(String name, int age, String username, String password) {
        super(name, age, username, password);
        this.managerID = UUID.randomUUID().toString();
        this.actionNumber = 0;
    }
    public int getActionNumber() {
        return actionNumber;
    }
    public void setActionNumber(int actionNumber) {
        this.actionNumber = actionNumber;
    }

    public String getManagerID() {
        return managerID;
    }

    @Override
    public String toString() {
        return super.toString() + ", Manager ID: " + managerID + ", Action Number: " + actionNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Manager manager = (Manager) obj;

        return (getUsername().equals(manager.getUsername()) && getPassword().equals(manager.getPassword())) ||
                (managerID.equals(manager.getManagerID()) && getPassword().equals(manager.getPassword()));
    }

    @Override
    public int hashCode() {
        return managerID.hashCode() + getPassword().hashCode();
    }

    public void increaseMoney(Customer customer, double amount) {
        if (amount > 0) {
            customer.setBalance(customer.getBalance() + amount);
            actionNumber++; 
        } else {
            System.out.println("Amount to increase must be positive!");
        }
    }

    public void decreaseMoney(Customer customer, double amount) {
        if (amount > 0 && customer.getBalance() >= amount) {
            customer.setBalance(customer.getBalance() - amount);
            actionNumber++;
        } else if (amount > 0 && customer.getBalance() < amount) {
            System.out.println("Insufficient balance to decrease!");
        } else {
            System.out.println("Amount to decrease must be positive!");
        }
    }

    public void updateMoney(Customer customer, double changeAmount) {
        customer.setBalance(customer.getBalance() + changeAmount);
        actionNumber++;
        System.out.println("Customer's updated balance: " + customer.getBalance());
    }

    public static void main(String[] args) {
        // Create a Manager object
        Manager manager = new Manager("Melissa", 23, "Feza", "Feza123");

        // Create Customer objects
        Customer customer1 = new Customer("Huseyin", 30, "alice123", "pass123", 500.0);

        manager.increaseMoney(customer1, 100.0);
        System.out.println(customer1);

        manager.decreaseMoney(customer1, 50.0);
        System.out.println(customer1);

        manager.updateMoney(customer1, -200.0);
        System.out.println(customer1);

        manager.updateMoney(customer1, 150.0);
        System.out.println(customer1);
    }
}
