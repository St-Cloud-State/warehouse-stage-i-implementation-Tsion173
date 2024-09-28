//Nathan Nelson

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class Client {

    // Instance variables
    private String id;
    private String name;
    private String address;
    private String phone;
    private List<String> transactions;
    // private Wishlist myWishlist;
    // private Orders myOrders;

    // Constructor
    public Client(String name, String address, String phone) {
        this.id = UUID.randomUUID().toString();  // Generates a unique ID
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.transactions = new ArrayList<>();  // Empty list of transactions
        // this.myWishlist = new Wishlist();       // Initialize empty Wishlist
        // this.myOrders = new Orders();           // Initialize empty Orders
    }

    // Getters and Setters
    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Get an iterator for transactions
    public Iterator<String> getTransactions() {
        return transactions.iterator();
    }

    // Add a transaction to the list
    public void addTransaction(String transaction) {
        transactions.add(transaction);
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
}