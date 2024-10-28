import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Warehouse {
    private Map<String, Product> products = new HashMap<>();
    private Map<String, Client> clients = new HashMap<>();
    private Map<String, List<Invoice>> clientInvoices = new HashMap<>();

    public void addProduct(Product product) { products.put(product.getProductId(), product); }
    public void addClient(Client client) { clients.put(client.getClientId(), client); }

    public void processShipment(Shipment shipment) {
        Product product = products.get(shipment.getProductId());
        if (product != null) {
            List<Invoice> invoices = shipment.processWaitlist(product, this);
            product.decreaseQuantity(-shipment.getQuantityReceived());
            System.out.println("Shipment processed, invoices generated: " + invoices);
        }
    }

    public void addInvoice(String clientId, Invoice invoice) {
        clientInvoices.computeIfAbsent(clientId, k -> new ArrayList<>()).add(invoice);
    }
}
