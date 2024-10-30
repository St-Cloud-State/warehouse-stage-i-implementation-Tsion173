import java.util.ArrayList;
import java.util.List;

public class OrderList {
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Order findOrderById(int orderID) {
        for (Order order : orders) {
            if (order.getOrderID() == orderID) {
                return order;
            }
        }
        return null; // Return null if not found
    }

    // Add the isEmpty method
    public boolean isEmpty() {
        return orders.isEmpty();
    }
}
