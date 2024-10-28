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
    public String getClientId() { // Add this method
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

/*import java.util.UUID;

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
}*/

