/** Payment workflow; depends only on the PaymentMethod abstraction. */
public class PaymentService {

    public Order createOrder(Customer customer) {
        System.out.println("Order created for Customer " + customer.getName() + ".");
        return new Order(customer);
    }

    public boolean pay(Order order, PaymentMethod method) {
        String who = order.getCustomer().getName();
        if (order.isEmpty()) {
            System.out.println("Cannot process payment for an empty order.");
            return false;
        }
        if (order.getStatus() == OrderStatus.PAID) {
            System.out.println("Order " + who + " is already paid.");
            return false;
        }
        System.out.println("Payment initiated via " + method.getName() + " for Order " + who + ".");
        boolean success = method.processPayment(order.getTotal());
        if (success) {
            order.markPaid();
            System.out.println("Payment for Order " + who + " successful. Order status: " + order.getStatus() + ".");
        } else {
            System.out.println("Payment for Order " + who + " failed. Order status: " + order.getStatus() + ".");
        }
        return success;
    }
}
