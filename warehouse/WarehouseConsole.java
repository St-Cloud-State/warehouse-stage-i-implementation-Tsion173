import java.util.Scanner;
import java.util.Iterator;

public class WarehouseConsole {
    private ClientList clientList = new ClientList();
    private Catalog catalog = Catalog.getInstance();

    public void showMainMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Warehouse Management System");
            System.out.println("1. Manage Clients");
            System.out.println("2. Manage Products");
            System.out.println("3. Create Order");
            System.out.println("4. View Orders");
            System.out.println("5. Exit");
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
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
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

        Client client = new Client(name, address, phone);
        clientList.insertClient(client);
        System.out.println("Client added successfully!");
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

        Product product = new Product(name, price, description, category);
        catalog.addProduct(product);
        System.out.println("Product added successfully!");
    }

    // Method to create an order
    private void createOrder(Scanner scanner) {
        System.out.println("Create Order");
        System.out.print("Enter Client ID: ");
        String clientID = scanner.nextLine();
        System.out.print("Enter Product ID: ");
        String productID = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();

        Client client = clientList.search(clientID);
        Product product = catalog.searchProduct(productID);

        if (client != null && product != null) {
            Order order = new Order(client.getID(), java.time.LocalDate.now());
            order.addItem(product, quantity);
            System.out.println("Order created successfully!");
        } else {
            System.out.println("Client or Product not found.");
        }
    }

    // Method to view orders (Placeholder)
    private void viewOrders() {
        System.out.println("View Orders");
        // Orders functionality would go here
        System.out.println("No orders to display (order management not yet implemented).");
    }

    public static void main(String[] args) {
        WarehouseConsole app = new WarehouseConsole();
        app.showMainMenu();
    }
}
