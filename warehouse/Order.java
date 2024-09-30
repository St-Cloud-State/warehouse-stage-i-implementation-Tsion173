// Morgan Rassatt
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order { // Represents a single order in the system
    private String id; // Unique identifier for the order
    private String clientID; // Client ID associated with the order
    private LocalDate date; // Date when the order was created
    private List<OrderItem> items; // List of items in the order

    public Order(String clientID, LocalDate date) { // Initializes the order with client ID and date
        this.id = UUID.randomUUID().toString(); // Generates a unique identifier for an order
        this.clientID = clientID;
        this.date = date;
        this.items = new ArrayList<>();
    }

    // Getters for the order ID, client ID, and date
    public String getID() { // Get the order ID
        return id;
    }

    public String getClientID() { // Get the client ID
        return clientID;
    }

    public LocalDate getDate() { // Get the date of the order
        return date;
    }

    // Method to add an item to the order
    public boolean addItem(Product product, int quantity) {
        for (OrderItem item : items) {
            if (item.getProduct().getID().equals(product.getID())) {
                return false; // Return false if the product already exists
            }
        }
        items.add(new OrderItem(product, quantity));
        return true;
    }

    // Method to get detailed information about the order
    public String getOrderDetails() { // Method to get detailed information about the order
        StringBuilder details = new StringBuilder("Order ID: " + id + "\nClient ID: " + clientID + "\nDate: " + date + "\nItems:\n");
        for (OrderItem item : items) {
            details.append(item.getProductInfo()).append("\n");
        }
        return details.toString();
    }

    // Additional methods (updateItem, removeItem, etc.) can be added as needed
}

