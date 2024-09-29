public class Notice {
    private String message;
    private String productID;

    // Constructor to initialize Notice with a message and productID
    public Notice(String message, String productID) {
        this.message = message;
        this.productID = productID;
    }

    // Getter for the message
    public String getMessage() {
        return message;
    }

    // Getter for the product ID
    public String getProductID() {
        return productID;
    }

    // Display the notice details
    public String displayNotice() {
        return "Notice: " + message + " [Product ID: " + productID + "]";
    }
}
