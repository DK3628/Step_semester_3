public class PayrollAccount {
    private double basicSalary;
    private double bonus;

    public PayrollAccount(double openingBasicSalary) {
        if (openingBasicSalary < 0) {
            System.out.println("Warning: Opening basic salary cannot be negative. Starting at 0 instead.");
            this.basicSalary = 0;
        } else {
            this.basicSalary = openingBasicSalary;
        }
        this.bonus = 0;
    }

    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Bonus rejected: amount must be greater than 0");
        } else {
            this.bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Tax deduction rejected: percentage must be between 0 and 100");
        } else {
            double deduction = (this.basicSalary * percent) / 100;
            this.basicSalary -= deduction;
            // The sample output shows 10%, formatted without the decimal if it's an integer, 
            // but we'll stick to a simple print for accuracy.
            System.out.printf("Tax deducted: %.0f%%\n", percent);
        }
    }

    public double getNetSalary() {
        return this.basicSalary + this.bonus;
    }

    public static void main(String[] args) {
        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}