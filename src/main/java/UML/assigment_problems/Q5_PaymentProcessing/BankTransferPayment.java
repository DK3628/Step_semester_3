public class BankTransferPayment implements PaymentMethod {
    private final String accountNumber;
    private final double accountBalance;
    public BankTransferPayment(String accountNumber, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }
    @Override public String getName() { return "Bank Transfer"; }
    @Override public boolean processPayment(double amount) {
        return accountNumber != null && !accountNumber.isBlank() && amount <= accountBalance;
    }
}
