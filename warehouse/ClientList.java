//Nathan Nelson

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClientList {
    private List<Client> clients;

    public ClientList() {
        this.clients = new ArrayList<>();
    }

    public void insertClient(Client client) {
        clients.add(client);
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
}
