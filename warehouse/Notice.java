// Notice.java
import java.time.LocalDateTime;

public class Notice {
    private String message; // Message of the notice
    private String productID; // Associated product ID
    private LocalDateTime timestamp; // Time when the notice was created

    // Constructor
    public Notice(String message, String productID) {
        this.message = message;
        this.productID = productID;
        this.timestamp = LocalDateTime.now(); // Sets the current time
    }

    // Getters
    public String getMessage() {
        return message;
    }

    public String getProductID() {
        return productID;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    // Method to display notice details
    public String displayNotice() {
        return "Notice: " + message + "\nProduct ID: " + productID + "\nTimestamp: " + timestamp;
    }
}
