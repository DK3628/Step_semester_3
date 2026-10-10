public class PayPalPayment implements PaymentMethod {
    private final String email;
    private final double balance;
    public PayPalPayment(String email, double balance) { this.email = email; this.balance = balance; }
    @Override public String getName() { return "PayPal"; }
    @Override public boolean processPayment(double amount) {
        return email != null && email.contains("@") && amount <= balance;
    }
}
