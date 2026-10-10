import java.io.*;
import java.util.*;

abstract class Staff {
    private final String name;
    protected Staff(String name) { this.name = name; }
    public String getName() { return name; }
    public abstract String getType();
    public abstract double calculatePay();
}

class FullTime extends Staff {
    private final double salary;
    FullTime(String name, double salary) { super(name); this.salary = salary; }
    @Override public String getType() { return "FullTime"; }
    @Override public double calculatePay() { return salary; }
}

class PartTime extends Staff {
    private final double hours, rate;
    PartTime(String name, double hours, double rate) { super(name); this.hours = hours; this.rate = rate; }
    @Override public String getType() { return "PartTime"; }
    @Override public double calculatePay() { return hours * rate; }
}

class Intern extends Staff {
    private final double stipend;
    Intern(String name, double stipend) { super(name); this.stipend = stipend; }
    @Override public String getType() { return "Intern"; }
    @Override public double calculatePay() { return stipend; }
}

class Payslip {
    private final String name, type;
    private final double pay;
    Payslip(Staff s) { this.name = s.getName(); this.type = s.getType(); this.pay = s.calculatePay(); }
    public String getName() { return name; }
    public double getPay() { return pay; }
    @Override public String toString() {
        return "Payslip[name=" + name + ", type=" + type + ", pay=" + Main.fmt(pay) + "]";
    }
}

public class Main {
    static String fmt(double v) { return v == Math.rint(v) ? String.valueOf((long) v) : String.format(Locale.US, "%.2f", v); }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder all = new StringBuilder();
        for (String line; (line = in.readLine()) != null; ) all.append(line).append(' ');
        String[] t = all.toString().trim().split("\\s+");

        List<Payslip> list = new ArrayList<>();
        int i = 0;
        while (i < t.length) {
            if (t[i].equalsIgnoreCase("FullTime") && i + 2 < t.length) {
                list.add(new Payslip(new FullTime(t[i + 1], Double.parseDouble(t[i + 2]))));
                i += 3;
            } else if (t[i].equalsIgnoreCase("PartTime") && i + 3 < t.length) {
                list.add(new Payslip(new PartTime(t[i + 1], Double.parseDouble(t[i + 2]), Double.parseDouble(t[i + 3]))));
                i += 4;
            } else if (t[i].equalsIgnoreCase("Intern") && i + 2 < t.length) {
                list.add(new Payslip(new Intern(t[i + 1], Double.parseDouble(t[i + 2]))));
                i += 3;
            } else i++;
        }

        Payslip[] payslips = list.toArray(new Payslip[0]);   // payslips stored in an array
        double total = 0;
        Payslip top = null;
        for (Payslip p : payslips) {
            System.out.println(p);
            total += p.getPay();
            if (top == null || p.getPay() > top.getPay()) top = p;   // first wins ties
        }
        System.out.println("Total " + fmt(total));
        if (top != null) System.out.println("top earner " + top.getName());
    }
}
