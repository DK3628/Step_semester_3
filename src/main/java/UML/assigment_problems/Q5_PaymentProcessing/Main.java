public class Main {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();
        Product a = new Product("Product A", 250.0), b = new Product("Product B", 400.0), c = new Product("Product C", 999.0);
        Customer x = new Customer("X"), y = new Customer("Y"), z = new Customer("Z");

        Order ox = service.createOrder(x);
        ox.addItem(a, 2);
        ox.addItem(b, 1);
        service.pay(ox, new CreditCardPayment("1234567812345678", 5000));

        Order oy = service.createOrder(y);       // empty
        service.pay(oy, new CreditCardPayment("1234567812345678", 5000));

        Order oz = service.createOrder(z);
        oz.addItem(c, 1);
        service.pay(oz, new PayPalPayment("z@example.com", 100));   // insufficient -> fails
    }
}
