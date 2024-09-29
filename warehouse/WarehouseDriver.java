import java.util.Iterator; // Importing the Iterator class

public class WarehouseDriver {
    public static void main(String[] args) {
        ClientList clientList = new ClientList();

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

        // Get all clients using the iterator
        Iterator<Client> clientIterator = clientList.getClients();
        while (clientIterator.hasNext()) {
            Client client = clientIterator.next();
            System.out.println("Client ID: " + client.getID() + ", Name: " + client.getName());
        }
    }
}

