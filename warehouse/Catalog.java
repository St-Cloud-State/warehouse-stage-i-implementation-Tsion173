import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Catalog {
    private static Catalog catalog;
    private List<Product> products;
    private List<Notice> notices;  // List to store notices

    private Catalog() {
        this.products = new ArrayList<>();
        this.notices = new ArrayList<>();  // Initialize the notices list
    }

    public static Catalog getInstance() {
        if (catalog == null) {
            catalog = new Catalog();
        }
        return catalog;
    }

    public boolean addProduct(Product product) {
        boolean added = products.add(product);
        if (added) {
            Notice notice = new Notice("Product added: " + product.getName(), product.getID());
            notices.add(notice);
        }
        return added;
    }

    public boolean removeProduct(String productID) {
        for (Product product : products) {
            if (product.getID().equals(productID)) {
                return products.remove(product);
            }
        }
        return false;
    }

    public Product searchProduct(String productID) {
        for (Product product : products) {
            if (product.getID().equals(productID)) {
                return product;
            }
        }
        return null;
    }

    public Iterator<Product> getAllProducts() {
        return products.iterator();
    }

    // Method to get an iterator for notices
    public Iterator<Notice> getNotices() {
        return notices.iterator();
    }
}

