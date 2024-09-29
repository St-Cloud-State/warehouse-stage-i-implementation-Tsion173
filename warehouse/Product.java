import java.util.UUID;

public class Product {
    private String id;
    private String name;
    private double price;
    private String description;
    private String category;

    // Constructor to initialize a new product
    public Product(String name, double price, String description, String category) {
        this.id = UUID.randomUUID().toString(); // Generate a unique ID for the product
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    // Getter for product ID
    public String getID() {
        return id;
    }

    // Getter for product name
    public String getName() {
        return name;
    }

    // Getter for product price
    public double getPrice() {
        return price;
    }

    // Getter for product description
    public String getDescription() {
        return description;
    }

    // Getter for product category
    public String getCategory() {
        return category;
    }

    // Setter for product price
    public void setPrice(double price) {
        this.price = price;
    }

    // Setter for product description
    public void setDescription(String description) {
        this.description = description;
    }

    // Setter for product category
    public void setCategory(String category) {
        this.category = category;
    }

    // Method to get product information as a formatted string
    public String getProductInfo() {
        return "Product ID: " + id +
               ", Name: " + name +
               ", Price: $" + price +
               ", Description: " + description +
               ", Category: " + category;
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
        this.id = UUID.randomUUID().toString(); // Generate a unique ID for each product
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    // Getter for product ID
    public String getID() {
        return id;
    }

    // Getter for product name
    public String getName() {
        return name;
    }

    // Getter for product price
    public double getPrice() {
        return price; // Add this method
    }

    // Getter for product description
    public String getDescription() {
        return description;
    }

    // Getter for product category
    public String getCategory() {
        return category;
    }

    // Optional: Setters if you want to allow modifying these fields
    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Optional: Method to get all product information as a string
    public String getProductInfo() {
        return "ID: " + id + ", Name: " + name + ", Price: $" + price + ", Description: " + description + ", Category: " + category;
    }
}

*/


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
}
*/