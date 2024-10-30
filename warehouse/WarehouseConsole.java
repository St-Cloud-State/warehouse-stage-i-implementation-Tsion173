import java.util.Scanner;
import java.util.Iterator;

public class WarehouseConsole {
    private ClientList clientList = new ClientList();
    private Catalog catalog = Catalog.getInstance();
    private OrderList orderList = new OrderList();  // Store orders

    public void showMainMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Warehouse Management System");
            System.out.println("1. Manage Clients");
            System.out.println("2. Manage Products");
            System.out.println("3. Create Order");
            System.out.println("4. View Orders");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    manageClients(scanner);
                    break;
                case 2:
                    manageProducts(scanner);
                    break;
                case 3:
                    createOrder(scanner);
                    break;
                case 4:
                    viewOrders();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Method to manage clients
    private void manageClients(Scanner scanner) {
        System.out.println("Manage Clients");
        System.out.print("Enter Client Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Client Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Client Phone: ");
        String phone = scanner.nextLine();

        Client client = new Client(name, address, phone, 0.0); // Added fourth parameter for balance
        clientList.insertClient(client);
        System.out.println("Client added successfully! Client ID: " + client.getID());
    }

    // Method to manage products
    private void manageProducts(Scanner scanner) {
        System.out.println("Manage Products");
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Product Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();  // Consume the newline character
        System.out.print("Enter Product Description: ");
        String description = scanner.nextLine();
        System.out.print("Enter Product Category: ");
        String category = scanner.nextLine();

        Product product = new Product(name, price, description, category, 0); // Added fifth parameter for quantity
        catalog.addProduct(product);
        System.out.println("Product added successfully! Product ID: " + product.getID());
    }

    // Method to create an order
    private void createOrder(Scanner scanner) {
        System.out.println("Create Order");
        System.out.print("Enter Client ID: ");
        String clientID = scanner.nextLine();
        System.out.print("Enter Product ID: ");
        String productID = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();

        Client client = clientList.search(clientID);
        Product product = catalog.searchProduct(productID);

        if (client != null && product != null) {
            Order order = new Order(client.getID(), java.time.LocalDate.now());
            order.addItem(product, quantity);
            orderList.addOrder(order);  // Add the order to the order list
            System.out.println("Order created successfully! Order ID: " + order.getOrderID());
        } else {
            System.out.println("Client or Product not found.");
        }
    }

    // Method to view orders
    private void viewOrders() {
        System.out.println("View Orders");

        if (orderList.isEmpty()) {
            System.out.println("No orders to display.");
            return;
        }

        for (Order order : orderList.getOrders()) {
            System.out.println("Order ID: " + order.getOrderID());
            System.out.println("Client ID: " + order.getClientID());
            System.out.println("Order Date: " + order.getOrderDate());
            System.out.println("Items:");
            for (OrderItem item : order.getItems()) {
                System.out.println("  Product ID: " + item.getProductID() + ", Quantity: " + item.getQuantity());
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        WarehouseConsole app = new WarehouseConsole();
        app.showMainMenu();
    }
}


                                               
/*import java.util.Scanner;
import java.util.Iterator;

public class WarehouseConsole {
    private ClientList clientList = new ClientList();
    private Catalog catalog = Catalog.getInstance();
    private Integer clientCount = 0;
    private Integer productCount = 0;

    public void showMainMenu() {
        Scanner scanner = new Scanner(System.in);
        displayOptions();
        while (true) {
            System.out.print("Select an command, 19 for Help: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    manageClients(scanner);
                    break;
                case 2:
                    manageProducts(scanner);
                    break;
                case 3:
                    createOrder(scanner);
                    break;
                case 4:
                    viewOrders();
                    break;
                case 5:
                    displayClients();
                    break;
                case 6:
                    displayProducts();
                    break;
                case 7:
                    manageClientWishlist(scanner);
                    break;
                case 19:
                    displayOptions();
                    break;
                case 20:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void displayOptions(){
        System.out.println("Warehouse Management System");
        System.out.println("1. Add Client");
        System.out.println("2. Add Product");
        System.out.println("3. Create Order");
        System.out.println("4. View Orders");
        System.out.println("5. View All Clients");
        System.out.println("6. View All Products");
        System.out.println("7. Manage a clients wishlist");
        System.out.println("19, For Help");
        System.out.println("20. Exit");
    }

    private void manageClientWishlist(Scanner scanner){
        System.out.println("Which client do you want to manage: ");
        displayClients();
        boolean valid = false;
        Integer bal = 0;
        while (!valid) {
            System.out.print("Enter clients number you want to manage: ");
            String input = scanner.nextLine();

            try {
                bal = Integer.parseInt(input); // Attempt to parse it as an integer
                if(bal > 0 && bal <= clientCount )
                    valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid client number.");
            }
        }
        Iterator<Client> cIterator = clientList.getClients();
        Client client = new Client("temp", "temp", "temp", 0.0);
        for(int i=0; i<bal;i++){
            client = cIterator.next();
        }
        System.out.println("Client choosen: " + client + " and their wishlist is: " + "\n");
        Iterator<Product> clientWishlist = client.WishlistIterator();
        int inc = 0;
        while (clientWishlist.hasNext()) { 
            inc++;
            Product product = clientWishlist.next(); 
            System.out.println(inc + " " + product.getProductInfo());
        }
        System.out.println("Do you want to add or remove from this wishlist? 0 to return");
        valid = false;
        while (!valid) {
            System.out.print("Enter add or remove or 0 or buyall: ");
            String input = scanner.nextLine();
            if(input.equals("0")){return;}
            if(input.equals("buyall")){
                clientWishlist = client.WishlistIterator();
                while (clientWishlist.hasNext()) { 
                    Product product = clientWishlist.next(); 
                    if(client.getBalance() >= product.getPrice() && product.getQuantity() > 0){
                        client.addToBalance(-1.0 * (product.getPrice()));
                        product.addToQuantity(-1);
                        clientWishlist.remove();
                        System.out.println("bought " + product);
                    } else{
                        System.out.println("couldn't buy " + product);
                    }
                }
                return;
            }
            if(input.equals("add") || input.equals("remove")){
                valid = true;
                if(input.equals("add")){
                    System.out.println("what product would you like to add? ");
                    displayProducts();
                    boolean valid2 = false;
                    Integer bal2 = 0;
                    while (!valid2) {
                        System.out.print("Enter product number you wish to add: ");
                        input = scanner.nextLine();

                        try {
                            bal2 = Integer.parseInt(input); // Attempt to parse it as an integer
                            if(bal2 > 0 && bal2 <= productCount )
                                valid2 = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid client number.");
                        }
                    }
                    clientWishlist = catalog.getAllProducts();
                    Product product2 = new Product("temp", 0.0, "temp", "temp", 0);
                    for(int i=0; i<bal2;i++){
                        product2 = clientWishlist.next();
                    }
                    System.out.println("Product choosen: " + product2 + " adding to their wishlist now... ");
                    client.addToWishlist(product2);
                }else{
                    clientWishlist = client.WishlistIterator();
                    inc = 0;
                    while (clientWishlist.hasNext()) { 
                        inc++;
                        Product product = clientWishlist.next(); 
                        System.out.println(inc + " " + product.getProductInfo());
                    }
                    if(inc == 0){
                        System.out.println("there is nothing to remove...");
                        return;
                    }
                    System.out.println("what product would you like to remove? ");
                    boolean valid2 = false;
                    Integer bal2 = 0;
                    while (!valid2) {
                        System.out.print("Enter product number you wish to remove: ");
                        input = scanner.nextLine();

                        try {
                            bal2 = Integer.parseInt(input); // Attempt to parse it as an integer
                            if(bal2 > 0 && bal2 <= inc )
                                valid2 = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid client number.");
                        }
                    }
                    clientWishlist = client.WishlistIterator();
                    Product product2 = new Product("temp", 0.0, "temp", "temp", 0);
                    for(int i=0; i<bal2;i++){
                        product2 = clientWishlist.next();
                    }
                    System.out.println("Product choosen: " + product2 + " removing to their wishlist now... ");
                    client.removeFromWishlist(product2);
                }
            }
            else{
                System.out.println("You entered the string: " + input);
            }             
        }
    }

    private void displayProducts(){
        Iterator<Product> pIterator = catalog.getAllProducts();
        int inc = 0;
        while (pIterator.hasNext()) { 
            inc++;
            Product product = pIterator.next(); 
            System.out.println(inc + " " + product.getProductInfo());
        }
    }

    private void displayClients(){
        Iterator<Client> cIterator = clientList.getClients();
        int inc = 0;
        while (cIterator.hasNext()) { 
            inc++;
            Client client = cIterator.next(); 
            System.out.println(inc + " " + client);
        }
    }

    // Method to manage clients
    private void manageClients(Scanner scanner) {
        System.out.println("Manage Clients");
        System.out.print("Enter Client Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Client Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Client Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter starting balance: ");
        boolean valid = false;
        Double bal = 0.0;
        while (!valid) {
            System.out.print("Enter clients balance: ");
            String input = scanner.nextLine();

            try {
                bal = Double.parseDouble(input); // Attempt to parse it as an integer
                valid = true;
                System.out.println("You entered the integer: " + bal);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }

        Client client = new Client(name, address, phone, bal);
        clientList.insertClient(client);
        System.out.println("Client added successfully!");
        clientCount++;
    }

    // Method to manage products
    private void manageProducts(Scanner scanner) {
        System.out.println("Manage Products");
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Product Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();  // Consume the newline character
        System.out.print("Enter Product Description: ");
        String description = scanner.nextLine();
        System.out.print("Enter Product Category: ");
        String category = scanner.nextLine();
        boolean valid = false;
        Integer bal = 0;
        while (!valid) {
            System.out.print("Enter the qunatity: ");
            String input = scanner.nextLine();

            try {
                bal = Integer.parseInt(input); // Attempt to parse it as an integer
                valid = true;
                System.out.println("You entered the integer: " + bal);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }

        Product product = new Product(name, price, description, category, bal);
        catalog.addProduct(product);
        System.out.println("Product added successfully!");
        productCount++;
    }

    // Method to create an order
    private void createOrder(Scanner scanner) {
        System.out.println("Create Order");
        System.out.print("Enter Client ID: ");
        String clientID = scanner.nextLine();
        System.out.print("Enter Product ID: ");
        String productID = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();

        Client client = clientList.search(clientID);
        Product product = catalog.searchProduct(productID);

        if (client != null && product != null) {
            Order order = new Order(client.getID(), java.time.LocalDate.now());
            order.addItem(product, quantity);
            System.out.println("Order created successfully!");
        } else {
            System.out.println("Client or Product not found.");
        }
    }

    // Method to view orders (Placeholder)
    private void viewOrders() {
        System.out.println("View Orders");
        // Orders functionality would go here
        System.out.println("No orders to display (order management not yet implemented).");
    }

    public static void main(String[] args) {
        WarehouseConsole app = new WarehouseConsole();
        app.showMainMenu();
    }
}
*/