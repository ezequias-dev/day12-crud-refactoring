package exercises;

import java.util.ArrayList;

class CustomerRecord {
    private String fullName;
    private String email;

    public CustomerRecord(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public void showCustomerSummary() {
        System.out.println("Name: " + getFullName() + " | Email: " + getEmail());
    }
}

class CustomerService {
    private final ArrayList<CustomerRecord> customers = new ArrayList<>();

    public void addCustomer(CustomerRecord customer) {
        customers.add(customer);
    }

    public void listCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers registered.");
        } else {
            for (CustomerRecord customer : customers) {
                customer.showCustomerSummary();
            }
        }
    }

    public CustomerRecord findByEmail(String email) {
        for (CustomerRecord customer : customers) {
            if (customer.getEmail().equals(email)) {
                return customer;
            }
        }

        return null;
    }
}

public class Exercise02 {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();

        customerService.addCustomer(new CustomerRecord("Ezequias Souza", "ezequia@email.com"));
        customerService.addCustomer(new CustomerRecord("Marli Santos", "marli@email.com"));
        customerService.addCustomer(new CustomerRecord("Alealdo Roberto", "alealdo@email.com"));
        customerService.addCustomer(new CustomerRecord("Alda Silva", "alda@email.com"));

        System.out.println("---- SEARCH CUSTOMER BY EMAIL ----");
        String targetEmail = "alealdo@email.com";

        CustomerRecord foundCustomer = customerService.findByEmail(targetEmail);

        if (foundCustomer != null) {
            foundCustomer.showCustomerSummary();
        } else {
            System.out.println("Customer not found.");
        }
    }
}