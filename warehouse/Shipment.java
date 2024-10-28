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
        List<WaitlistItem> waitlist = product.getWaitlist();
        
        for (WaitlistItem item : waitlist) {
            if (quantityReceived <= 0) break; // Stop if no stock left

            int quantityToFill = Math.min(item.getQuantity(), quantityReceived);
            quantityReceived -= quantityToFill;
            item.decreaseQuantity(quantityToFill);

            // Create invoice
            Invoice invoice = new Invoice(item.getClientId(), productId, quantityToFill, product.getPrice());
            invoices.add(invoice);
            warehouse.addInvoice(item.getClientId(), invoice);
        }
        
        // Remove fulfilled waitlist items
        waitlist.removeIf(item -> item.getQuantity() == 0);
        return invoices;
    }
}
