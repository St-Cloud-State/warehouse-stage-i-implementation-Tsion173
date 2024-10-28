import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Warehouse {
    private Map<String, Product> products = new HashMap<>();
    private Map<String, Client> clients = new HashMap<>();
    private Map<String, List<Invoice>> clientInvoices = new HashMap<>();

    public void addProduct(Product product) {
        products.put(product.getProductId(), product); // Ensure getProductId() exists
    }

    public void addClient(Client client) {
        clients.put(client.getClientId(), client); // Ensure getClientId() exists
    }

    public List<Invoice> getClientInvoices(String clientId) { // Ensure this method exists
        return clientInvoices.getOrDefault(clientId, new ArrayList<>());
    }
}
