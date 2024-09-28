import java.util.UUID;

public class Product {
    private String id;
    private String name;
    private double price;
    private String description;
    private String category;
    private String notice; // Add a notice field

    public Product(String name, double price, String description, String category) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.notice = ""; // Initialize notice
    }

    // Getters and setters for notice
    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
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
}
