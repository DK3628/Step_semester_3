import java.util.*;

/** Manages its items and status. Only PaymentService can mark it Paid. */
public class Order {
    private final Customer customer;
    private final List<OrderItem> items = new ArrayList<>();
    private OrderStatus status = OrderStatus.PENDING;

    public Order(Customer customer) { this.customer = customer; }

    public void addItem(Product product, int quantity) { items.add(new OrderItem(product, quantity)); }

    public double getTotal() {
        double t = 0;
        for (OrderItem i : items) t += i.getSubtotal();
        return t;
    }
    public boolean isEmpty() { return items.isEmpty(); }

    void markPaid() { status = OrderStatus.PAID; }

    public Customer getCustomer() { return customer; }
    public List<OrderItem> getItems() { return Collections.unmodifiableList(items); }
    public OrderStatus getStatus() { return status; }
}
