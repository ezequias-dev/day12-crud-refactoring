package exercises;

import java.util.ArrayList;

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
        System.out.print("Id: " + getId() + " | Name: " + getName());
        System.out.printf(" | Price: $%.2f%n", getPrice());
    }
}

class ProductService {
    private final ArrayList<ProductRecord> products = new ArrayList<>();

    public void addProduct(ProductRecord product) {
        products.add(product);
    }

    public void listProducts() {
        if (products.isEmpty()) {
            System.out.println("No products registered.");
            return;
        }

        for (ProductRecord product : products) {
            product.showProductSummary();
        }
    }

    public ProductRecord findById(int id) {
        for (ProductRecord product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}

public class Exercise01 {
    public static void main(String[] args) {
        ProductService productService = new ProductService();

        productService.addProduct(new ProductRecord(1, "iPhone 12", 250.90));
        productService.addProduct(new ProductRecord(2, "iPhone 13", 360.90));
        productService.addProduct(new ProductRecord(3, "iPhone 14", 420.50));
        productService.addProduct(new ProductRecord(4, "iPhone 15", 680.99));

        System.out.println();
        System.out.println("---- PRODUCT LIST ----");
        productService.listProducts();

        System.out.println();
        System.out.println("---- SEARCH BY ID ----");
        ProductRecord foundProduct = productService.findById(3);

        if (foundProduct != null) {
            foundProduct.showProductSummary();
        } else {
            System.out.println("Product not found.");
        }
    }
}