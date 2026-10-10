/** Abstraction used by PaymentService. New methods just implement this. */
public interface PaymentMethod {
    String getName();
    /** @return true if the payment succeeded. */
    boolean processPayment(double amount);
}
