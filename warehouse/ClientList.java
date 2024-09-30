//Nathan Nelson
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClientList {
    private List<Client> clients;

    public ClientList() {
        this.clients = new ArrayList<>();
    }

    public boolean insertClient(Client client) {
        // Check for duplicate client IDs before adding
        if (search(client.getID()) != null) {
            return false; // Prevent adding a duplicate client
        }
        clients.add(client);
        return true; // Return true if the client was added successfully
    }

    public Iterator<Client> getClients() {
        return clients.iterator();
    }

    public Client search(String clientID) {
        for (Client client : clients) {
            if (client.getID().equals(clientID)) {
                return client;
            }
        }
        return null;
    }

    // Method to display all clients
    public void viewClients() {
        System.out.println("Clients:");
        for (Client client : clients) {
            System.out.println("ID: " + client.getID() + ", Name: " + client.getName());
        }
    }
}

