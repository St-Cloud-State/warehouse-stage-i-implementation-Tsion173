import java.util.UUID;

public class Product {
    private String id;
    private String name;
    private Double price;
    private String description;
    private String category;
    private Integer quantity;

    public Product(String name, Double price, String description, String category, Integer quantity) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.quantity = quantity;
    }

    public void addToQuantity(Integer addition){
        quantity += addition;
    }

    public Integer getQuantity(){
        return quantity;
    }

    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
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
               "Category: " + category + "\n" +
               "Quantity: " + quantity;
    }

    public boolean updateProduct(double price, String description, String category, Integer quantity) {
        this.price = price;
        this.description = description;
        this.category = category;
        this.quantity = quantity;
        return true;
    }

    public boolean removeProduct() {
        this.name = null;
        this.price = 0.0;
        this.description = null;
        this.category = null;
        this.quantity = 0;
        return true;
    }

    @Override
    public String toString(){
        return name;
    }
}
