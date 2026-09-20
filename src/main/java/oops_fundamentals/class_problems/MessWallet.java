public class MessWallet {
    private double balance;

    public MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            System.out.println("Warning: Opening balance cannot be negative. Starting at 0 instead.");
            this.balance = 0;
        } else {
            this.balance = openingBalance;
        }
    }

    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: amount must be greater than 0");
        } else {
            this.balance += amount;
        }
    }

    public void deduct(double amount) {
        if (amount > this.balance) {
            System.out.println("Deduct rejected: insufficient balance");
        } else {
            this.balance -= amount;
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public static void main(String[] args) {
        System.out.println("opening = 500");
        MessWallet wallet = new MessWallet(500);
        
        System.out.println("topUp(200)");
        wallet.topUp(200);
        System.out.println("Balance after top-up: " + wallet.getBalance());
        
        System.out.println("deduct(1000)");
        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());
    }
}