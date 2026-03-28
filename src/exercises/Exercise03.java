package exercises;

import java.util.ArrayList;

class OrderRecord {
    private String code;
    private double totalAmount;

    public OrderRecord (String code, double totalAmount) {
        this.code = code;
        this.totalAmount = totalAmount;
    }

    public String getCode() {
        return code;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public boolean isValidOrder() {
        return code != null && !code.trim().isEmpty() && totalAmount > 0;
    }

    public void showOrderSummary() {
        System.out.printf("Code: %s | Total amount: $%.2f%n", getCode(), getTotalAmount());
    }
}

class OrderService {
    private final ArrayList<OrderRecord> orders = new ArrayList<>();

    public void addOrder(OrderRecord order) {
        orders.add(order);
    }

    public void listOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders registered.");
            return;
        }

        for (OrderRecord order : orders) {
            order.showOrderSummary();
        }
    }

    public int countValidOrders() {
        int validOrders = 0;

        for (OrderRecord order: orders) {
            if (order.isValidOrder()) {
                validOrders++;
            }
        }

        return validOrders;
    }
}

public class Exercise03 {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();

        orderService.addOrder(new OrderRecord("115", 123.90));
        orderService.addOrder(new OrderRecord("", 151.90));
        orderService.addOrder(new OrderRecord("117", 0));
        orderService.addOrder(new OrderRecord("118", 254.90));

        System.out.println();
        System.out.println("---- LIST ORDERS ----");
        orderService.listOrders();

        System.out.println();
        System.out.println("---- VALID ORDERS ----");
        int validOrder = orderService.countValidOrders();
        System.out.println("Valid orders: " + validOrder);
    }
}