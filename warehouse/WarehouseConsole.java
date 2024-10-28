// Tsion 
// UI code to link everything 

import java.util.Scanner;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class WarehouseConsole {
    private ClientList clientList = new ClientList(); // List to manage clients
    private Catalog catalog = Catalog.getInstance(); // Singleton instance of the product catalog
    private Warehouse warehouse = new Warehouse(); // Warehouse for managing inventory and orders
    private List<Order> orders = new ArrayList<>(); // List to store orders

    public void showMainMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Warehouse Management System");
            System.out.println("1. Manage Clients");
            System.out.println("2. Manage Products");
            System.out.println("3. Create Order");
            System.out.println("4. View Orders");
            System.out.println("5. Record Payment");
            System.out.println("6. Receive Shipment");
            System.out.println("7. View Invoices");
            System.out.println("8. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    manageClients(scanner);
                    break;
                case 2:
                    manageProducts(scanner);
                    break;
                case 3:
                    createOrder(scanner);
                    break;
                case 4:
                    viewOrders();
                    break;
                case 5:
                    recordPayment(scanner);
                    break;
                case 6:
                    receiveShipment(scanner);
                    break;
                case 7:
                    viewInvoices(scanner);
                    break;
                case 8:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Method to record payment from a client
    private void recordPayment(Scanner scanner) {
        System.out.println("Record Payment");
        System.out.print("Enter Client ID: ");
        String clientID = scanner.nextLine();
        System.out.print("Enter Payment Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        Client client = clientList.search(clientID);
        if (client != null) {
            client.recordPayment(amount); // Adjust client’s balance
            System.out.println("Payment recorded successfully for Client ID: " + clientID);
        } else {
            System.out.println("Client not found.");
        }
    }

    // Method to receive a shipment
    private void receiveShipment(Scanner scanner) {
        System.out.println("Receive Shipment");
        System.out.print("Enter Product ID: ");
        String productID = scanner.nextLine();
        System.out.print("Enter Quantity Received: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Product product = catalog.searchProduct(productID);
        if (product != null) {
            Shipment shipment = new Shipment(productID, quantity); // Create shipment
            List<Invoice> invoices = shipment.processWaitlist(product, warehouse); // Process waitlist

            System.out.println("Shipment processed. Updated stock for Product ID: " + productID + " is " + product.getQuantity());
            if (!invoices.isEmpty()) {
                System.out.println("Invoices generated for waitlisted clients:");
                for (Invoice invoice : invoices) {
                    System.out.println(invoice);
                }
            } else {
                System.out.println("No waitlisted items for this shipment.");
            }
        } else {
            System.out.println("Product not found.");
        }
    }

    // Method to view invoices for a specific client
    private void viewInvoices(Scanner scanner) {
        System.out.println("View Invoices");
        System.out.print("Enter Client ID: ");
        String clientID = scanner.nextLine();

        List<Invoice> invoices = warehouse.getClientInvoices(clientID);
        if (invoices != null && !invoices.isEmpty()) {
            System.out.println("Invoices for Client ID " + clientID + ":");
            for (Invoice invoice : invoices) {
                System.out.println(invoice);
            }
        } else {
            System.out.println("No invoices found for this client.");
        }
    }

    // Other methods (manageClients, manageProducts, createOrder, viewOrders, displayNotices) remain the same
    // ...
    
    public static void main(String[] args) {
        WarehouseConsole app = new WarehouseConsole(); // Create a new instance of the application
        app.showMainMenu(); // Show the main menu to the user
    }
}



/*import java.util.Scanner;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class WarehouseConsole {
    private ClientList clientList = new ClientList(); // List to manage clients
    private Catalog catalog = Catalog.getInstance(); // Singleton instance of the product catalog
    private List<Order> orders = new ArrayList<>(); // List to store orders

    public void showMainMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // Display main menu options
            System.out.println("Warehouse Management System");
            System.out.println("1. Manage Clients");
            System.out.println("2. Manage Products");
            System.out.println("3. Create Order");
            System.out.println("4. View Orders");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            // Handle user selection
            switch (choice) {
                case 1:
                    manageClients(scanner); // Manage client details
                    break;
                case 2:
                    manageProducts(scanner); // Manage product details
                    break;
                case 3:
                    createOrder(scanner); // Create a new order
                    break;
                case 4:
                    viewOrders(); // View all orders
                    break;
                case 5:
                    System.out.println("Exiting..."); // Exit the program
                    return;
                default:
                    System.out.println("Invalid option. Please try again."); // Handle invalid selection
            }
        }
    }

    // Method to manage clients
    private void manageClients(Scanner scanner) {
        System.out.println("Manage Clients");
        System.out.print("Enter Client Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Client Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Client Phone: ");
        String phone = scanner.nextLine();

        Client client = new Client(name, address, phone); // Create a new client
        clientList.insertClient(client); // Add client to the client list
        System.out.println("Client added successfully with ID: " + client.getID()); // Print the client ID once
    }

    // Method to manage products
    private void manageProducts(Scanner scanner) {
        System.out.println("Manage Products");
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Product Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();  // Consume the newline character
        System.out.print("Enter Product Description: ");
        String description = scanner.nextLine();
        System.out.print("Enter Product Category: ");
        String category = scanner.nextLine();

        Product product = new Product(name, price, description, category); // Create a new product
        boolean added = catalog.addProduct(product); // Add product to the catalog
        if (added) {
            System.out.println("Product added successfully with ID: " + product.getID()); // Print the product ID once
        } else {
            System.out.println("Failed to add product."); // Handle product addition failure
        }

        // Display notices after adding the product
        displayNotices();
    }

    // Method to create an order
    private void createOrder(Scanner scanner) {
        System.out.println("Create Order");

        // Display existing clients
        clientList.viewClients(); // List all clients for selection

        System.out.print("Enter Client ID: ");
        String clientID = scanner.nextLine();
        System.out.print("Enter Product ID: ");
        String productID = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();

        // Retrieve client and product based on provided IDs
        Client client = clientList.search(clientID);
        Product product = catalog.searchProduct(productID);

        // Validate the existence of client and product
        if (client != null && product != null) {
            Order order = new Order(client.getID(), java.time.LocalDate.now()); // Create new order with today's date
            order.addItem(product, quantity); // Add item to the order
            orders.add(order); // Add the created order to the orders list
            System.out.println("Order created successfully with ID: " + order.getID()); // Print the order ID
        } else {
            System.out.println("Client or Product not found."); // Handle case where client or product is not found
        }
    }

    // Method to view orders
    private void viewOrders() {
        System.out.println("View Orders");
        if (orders.isEmpty()) {
            System.out.println("No orders to display."); // Handle empty orders list
            return;
        }
        // Print each order's details
        for (Order order : orders) {
            System.out.println(order.getOrderDetails());
            System.out.println(); // Add space between orders
        }
    }

    // Method to display notices
    private void displayNotices() {
        System.out.println("\nProduct Notices:");
        Iterator<Notice> noticeIterator = catalog.getNotices();
        while (noticeIterator.hasNext()) {
            Notice notice = noticeIterator.next(); // Iterate through notices
            System.out.println(notice.getMessage()); // Print each notice
        }
    }

    public static void main(String[] args) {
        WarehouseConsole app = new WarehouseConsole(); // Create a new instance of the application
        app.showMainMenu(); // Show the main menu to the user
    }
}*/

