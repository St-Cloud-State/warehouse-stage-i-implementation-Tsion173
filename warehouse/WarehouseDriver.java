//Nathan Nelson

// Updated by Tsion
import java.util.Iterator;

public class WarehouseDriver {
    public static void main(String[] args) {
        // Create a ClientList object
        ClientList clientList = new ClientList();

        // Create and add Client objects
        Client client1 = new Client("Nathan Nelson", "101 Main St", "555-1234");
        Client client2 = new Client("Group Twelve", "999 Oak St", "555-5678");
        Client client3 = new Client("Tsion Nidaw", "150 Park Ave", "555-8765");
        Client client4 = new Client("Morgan Rassatt", "202 Lakeview Dr", "555-4321");
        Client client5 = new Client("Larson Triston", "303 Maple St", "555-6789");

        // Insert clients into the client list
        clientList.insertClient(client1);
        clientList.insertClient(client2);
        clientList.insertClient(client3);
        clientList.insertClient(client4);
        clientList.insertClient(client5);

        // Display all clients
        System.out.println("All clients:");
        Iterator<Client> clientIterator = clientList.getClients();
        while (clientIterator.hasNext()) {
            Client client = clientIterator.next();
            System.out.println("Client ID: " + client.getID() + ", Name: " + client.getName() +
                               ", Address: " + client.getAddress() + ", Phone: " + client.getPhone());
        }

        // Search for a specific client by ID (Example: client1)
        System.out.println("\nSearching for client with ID: " + client1.getID());
        Client foundClient = clientList.search(client1.getID());
        if (foundClient != null) {
            System.out.println("Found client: " + foundClient.getName());
        } else {
            System.out.println("Client not found.");
        }

        // Create a Catalog object
        Catalog catalog = Catalog.getInstance();

        // Create a few Product objects
        Product product1 = new Product("Laptop", 999.99, "High-performance laptop", "Electronics");
        Product product2 = new Product("Phone", 499.99, "Latest model smartphone", "Electronics");

        // Add products to the catalog and generate notices
        catalog.addProduct(product1);
        catalog.addProduct(product2);

        // Display all notices related to products
        System.out.println("\nNotices:");
        Iterator<Notice> noticeIterator = catalog.getNotices();
        while (noticeIterator.hasNext()) {
            Notice notice = noticeIterator.next();
            System.out.println(notice);
        }
    }
}
