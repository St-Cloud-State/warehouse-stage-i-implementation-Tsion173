import java.util.ArrayList;
import java.util.List;

public class Shipment {
    private String productId;
    private int quantityReceived;

    public Shipment(String productId, int quantityReceived) {
        this.productId = productId;
        this.quantityReceived = quantityReceived;
    }

    public String getProductId() { return productId; }
    public int getQuantityReceived() { return quantityReceived; }

    // Process waitlist and generate invoices for filled orders
    public List<Invoice> processWaitlist(Product product, Warehouse warehouse) {
        List<Invoice> invoices = new ArrayList<>();
        List<Product.WaitlistEntry> waitlist = product.getWaitlist(); // Updated to use WaitlistEntry

        for (Product.WaitlistEntry entry : waitlist) { // Updated to use WaitlistEntry
            if (quantityReceived <= 0) break; // Stop if no stock left

            int quantityToFill = Math.min(entry.getQuantity(), quantityReceived);
            quantityReceived -= quantityToFill;
            entry.decreaseQuantity(quantityToFill); // Assuming a method exists in WaitlistEntry to decrease quantity

            // Create invoice
            Invoice invoice = new Invoice(entry.getClientId(), productId, quantityToFill, product.getPrice());
            invoices.add(invoice);
            warehouse.addInvoice(entry.getClientId(), invoice);
        }
        
        // Remove fulfilled waitlist items
        waitlist.removeIf(entry -> entry.getQuantity() == 0); // Updated to use WaitlistEntry
        return invoices;
    }
}
