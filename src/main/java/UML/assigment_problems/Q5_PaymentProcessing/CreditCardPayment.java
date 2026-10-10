public class CreditCardPayment implements PaymentMethod {
    private final String cardNumber;
    private final double creditLimit;
    public CreditCardPayment(String cardNumber, double creditLimit) {
        this.cardNumber = cardNumber;
        this.creditLimit = creditLimit;
    }
    @Override public String getName() { return "Credit Card"; }
    @Override public boolean processPayment(double amount) {
        return cardNumber != null && cardNumber.matches("\\d{16}") && amount <= creditLimit;
    }
}
