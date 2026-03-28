package review;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

class ProductRecord {
    private int id;
    private String name;
    private double price;

    public ProductRecord(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void showProductSummary() {
        System.out.printf("Id: %d | Name: %s | Price: $%.2f%n", getId(), getName(), getPrice());
    }
}

public class Day11QuickReview {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        ArrayList<ProductRecord> products = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println();
            System.out.println("|-------------- OPTIONS MENU --------------|");
            System.out.println("| Option 1 - Register product              |");
            System.out.println("| Option 2 - List products                 |");
            System.out.println("| Option 3 - Search product by name        |");
            System.out.println("| Option 4 - Remove product by id          |");
            System.out.println("| Option 5 - Exit                          |");
            System.out.println("|------------------------------------------|");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.println();
                System.out.println("---- REGISTER PRODUCT ----");

                System.out.print("Enter product id: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter product name: ");
                String name = scanner.nextLine();

                System.out.print("Enter product price: ");
                double price = scanner.nextDouble();

                ProductRecord product = new ProductRecord(id, name, price);
                products.add(product);

                System.out.println("Product registered successfully.");
            } else if (option == 2) {
                System.out.println();
                System.out.println("---- LIST PRODUCTS ----");

                if (products.isEmpty()) {
                    System.out.println("No products registered.");
                } else {
                    for (ProductRecord product : products) {
                        product.showProductSummary();
                    }
                }

            } else if (option == 3) {
                System.out.println();
                System.out.println("---- SEARCH PRODUCT BY NAME ----");

                System.out.print("Enter name: ");
                String targetName = scanner.nextLine();

                ProductRecord foundName = null;

                for (ProductRecord product : products) {
                    if (product.getName().equalsIgnoreCase(targetName)) {
                        foundName = product;
                        break;
                    }
                }

                if (foundName != null) {
                    foundName.showProductSummary();
                } else {
                    System.out.println("Product name not found.");
                }
            } else if (option == 4) {
                System.out.println();
                System.out.println("---- REMOVE PRODUCT BY ID ----");

                System.out.print("Enter id: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                ProductRecord productToRemove = null;

                for (ProductRecord product : products) {
                    if (product.getId() == id) {
                        productToRemove = product;
                        break;
                    }
                }

                if (productToRemove != null) {
                    products.remove(productToRemove);
                    System.out.println("Product removed successfully.");
                } else {
                    System.out.println("Product id not found.");
                }
            } else if (option == 5) {
                System.out.println("System closed.");
            } else {
                System.out.println("Invalid option.");
            }
        } while (option != 5);
    }
}