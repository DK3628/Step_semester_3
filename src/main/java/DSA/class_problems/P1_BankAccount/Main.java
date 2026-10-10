import java.io.*;
import java.util.*;

/** Base account: owns its balance; each subtype supplies only its own withdrawal rule. */
abstract class Account {
    private final String id;
    private double balance;

    protected Account(String id, double initialBalance) { this.id = id; this.balance = initialBalance; }

    /** @return null if the resulting balance is allowed, otherwise the rejection reason. */
    protected abstract String violation(double balanceAfter);

    /** @return null on success, otherwise the rejection reason. */
    public String withdraw(double amount) {
        if (amount <= 0) return "invalid amount";
        String reason = violation(balance - amount);
        if (reason != null) return reason;
        balance -= amount;
        return null;
    }

    public String getId() { return id; }
    public double getBalance() { return balance; }
}

class SavingsAccount extends Account {
    static final double MIN_BALANCE = 1000;
    SavingsAccount(String id, double b) { super(id, b); }
    @Override protected String violation(double after) {
        return after < MIN_BALANCE ? "minimum balance " + Main.fmt(MIN_BALANCE) : null;
    }
}

class CurrentAccount extends Account {
    static final double OVERDRAFT_LIMIT = 5000;
    CurrentAccount(String id, double b) { super(id, b); }
    @Override protected String violation(double after) {
        return after < -OVERDRAFT_LIMIT ? "overdraft limit " + Main.fmt(OVERDRAFT_LIMIT) : null;
    }
}

public class Main {
    static String fmt(double v) { return v == Math.rint(v) ? String.valueOf((long) v) : String.format(Locale.US, "%.2f", v); }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder all = new StringBuilder();
        for (String line; (line = in.readLine()) != null; ) all.append(line).append(' ');
        String[] t = all.toString().trim().split("\\s+");

        Map<String, Account> accounts = new LinkedHashMap<>();
        StringBuilder out = new StringBuilder();
        int i = 0;
        while (i < t.length) {
            String op = t[i];
            if (op.isEmpty()) { i++; continue; }
            if (op.equalsIgnoreCase("Savings") && i + 2 < t.length) {
                accounts.putIfAbsent(t[i + 1], new SavingsAccount(t[i + 1], Double.parseDouble(t[i + 2])));
                i += 3;
            } else if (op.equalsIgnoreCase("Current") && i + 2 < t.length) {
                accounts.putIfAbsent(t[i + 1], new CurrentAccount(t[i + 1], Double.parseDouble(t[i + 2])));
                i += 3;
            } else if (op.equalsIgnoreCase("WITHDRAW") && i + 2 < t.length) {
                Account a = accounts.get(t[i + 1]);
                if (a == null) out.append("Account not found\n");
                else {
                    String reason = a.withdraw(Double.parseDouble(t[i + 2]));
                    if (reason == null) out.append(a.getId()).append(" balance ").append(fmt(a.getBalance())).append('\n');
                    else out.append(a.getId()).append(" rejected: ").append(reason).append('\n');
                }
                i += 3;
            } else {
                i++;   // skip unknown token
            }
        }
        System.out.print(out);
    }
}
