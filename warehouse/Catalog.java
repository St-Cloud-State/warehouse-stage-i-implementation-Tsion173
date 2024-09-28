import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Catalog {
    private static Catalog catalog;
    private List<Product> products;
    private List<Notice> notices; // List to store notices related to products

    private Catalog() {
        this.products = new ArrayList<>();
        this.notices = new ArrayList<>(); // Initialize the list of notices
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
            // Create a notice when a product is added
            Notice notice = new Notice("Product added: " + product.getName(), product.getID());
            notices.add(notice); // Add the notice to the list
            System.out.println(notice); // Print the notice
        }
        return added;
    }

    // Other methods remain unchanged...

    public Iterator<Notice> getNotices() {
        return notices.iterator(); // Return an iterator for the notices
    }
}
