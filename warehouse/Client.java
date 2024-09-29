//Nathan Nelson

import java.util.UUID;

public class Client {
    private String id;
    private String name;
    private String address;
    private String phone;

    // Constructor that generates a unique ID
    public Client(String name, String address, String phone) {
        this.id = UUID.randomUUID().toString(); // Generate a unique ID
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    // Getter methods
    public String getID() {
        return id; // Return the generated ID
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}



    /*
    // Issue a product (adds to orders)
    public boolean issueProduct(Product product) {
        return myOrders.addOrder(product);  // Adds product to the Orders list
    }

    // Remove a product (removes from orders)
    public boolean removeProduct(Product product) {
        return myOrders.removeOrder(product);  // Removes product from the Orders list
    }

    // Get an iterator for the wishlist
    public Iterator<Product> getWishlist() {
        return myWishlist.getProducts();
    }

    // Get an iterator for the orders
    public Iterator<Product> getOrders() {
        return myOrders.getProducts();
    }
    */

