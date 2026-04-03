package exercises;

import java.util.ArrayList;

class StockItem {
    private final int id;
    private final String name;
    private final int quantity;

    public StockItem(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void showStockSummary() {
        System.out.printf("Id: %d | Name: %s | Quantity: %d%n", id, name, quantity);
    }
}

class StockService {
    private final ArrayList<StockItem> items = new ArrayList<>();

    public void addItem(StockItem item) {
        if (item == null) {
            System.out.println("Item cannot be null.");
            return;
        }

        items.add(item);
        System.out.println("Item added successfully.");
    }

    public void listItems() {
        if (items.isEmpty()) {
            System.out.println("No items registered.");
            return;
        }

        for (StockItem item : items) {
            item.showStockSummary();
        }
    }

    public void removeById(int id) {
        if (id < 1) {
            System.out.println("Id must be greater than zero.");
            return;
        }

        StockItem itemToRemove = null;

        for (StockItem item : items) {
            if (item.getId() == id) {
                itemToRemove = item;
                break;
            }
        }

        if (itemToRemove == null) {
            System.out.println("Item with id " + id + " not found.");
            return;
        }

        items.remove(itemToRemove);
        System.out.println("Item with id " + id + " removed successfully.");
    }
}

public class Exercise05 {
    public static void main(String[] args) {
        StockService stockService = new StockService();

        stockService.addItem(new StockItem(1, "iPhone 12", 2));
        stockService.addItem(new StockItem(2, "iPhone 13", 4));
        stockService.addItem(new StockItem(3, "iPhone 14", 6));
        stockService.addItem(new StockItem(4, "iPhone 15", 8));

        System.out.println("\n---- LIST ITEMS ----");
        stockService.listItems();

        stockService.removeById(2);

        System.out.println("\n---- LIST ITEMS AFTER REMOVAL ----");
        stockService.listItems();
    }
}