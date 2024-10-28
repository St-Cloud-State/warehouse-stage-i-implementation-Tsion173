import java.util.Date;

public class Invoice {
    private String clientId;
    private String productId;
    private int quantity;
    private double totalAmount;
    private Date issueDate;

    public Invoice(String clientId, String productId, int quantity, double unitPrice) {
        this.clientId = clientId;
        this.productId = productId;
        this.quantity = quantity;
        this.totalAmount = quantity * unitPrice;
        this.issueDate = new Date();
    }

    public String getClientId() { return clientId; }
    public String getProductId() { return productId; }
    public int getQuantity() { return quantity; }
    public double getTotalAmount() { return totalAmount; }
    public Date getIssueDate() { return issueDate; }

    public String toString() {
        return "Invoice[Client ID: " + clientId + ", Product ID: " + productId +
               ", Quantity: " + quantity + ", Total: $" + totalAmount +
               ", Date: " + issueDate + "]";
    }
}
