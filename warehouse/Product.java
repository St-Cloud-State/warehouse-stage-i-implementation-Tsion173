//Triston
import java.util.ArrayList;
import java.util.List;

public class Product {
    private String productId;
    private int quantity;
    private double price;
    private List<WaitlistItem> waitlist = new ArrayList<>();

    public Product(String productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() { return productId; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public List<WaitlistItem> getWaitlist() { return waitlist; }

    public void decreaseQuantity(int quantity) { this.quantity -= quantity; }

    public void addToWaitlist(String clientId, int quantity) {
        waitlist.add(new WaitlistItem(clientId, quantity));
    }
}





/*import java.util.UUID;

public class Product {
    private String id;
    private String name;
    private double price;
    private String description;
    private String category;

    public Product(String name, double price, String description, String category) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductInfo() {
        return "Product ID: " + id + "\n" +
               "Name: " + name + "\n" +
               "Price: " + price + "\n" +
               "Description: " + description + "\n" +
               "Category: " + category;
    }

    public boolean updateProduct(double price, String description, String category) {
        this.price = price;
        this.description = description;
        this.category = category;
        return true;
    }

    public boolean removeProduct() {
        this.name = null;
        this.price = 0.0;
        this.description = null;
        this.category = null;
        return true;
    }
}*/
