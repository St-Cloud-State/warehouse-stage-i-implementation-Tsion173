public class OrderItem {
    private String productID;
    private int quantity;

    public OrderItem(Product product, int quantity) {
        this.productID = product.getID(); // Assuming Product has getID()
        this.quantity = quantity;
    }

    public String getProductID() {
        return productID;
    }

    public int getQuantity() {
        return quantity;
    }
}
