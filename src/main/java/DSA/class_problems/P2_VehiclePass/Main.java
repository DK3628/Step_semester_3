import java.io.*;
import java.util.*;

/** Contract for vehicles that can use a charging bay. */
interface Chargeable {
    void bookChargingBay();
}

abstract class Vehicle {
    private final String passNumber;
    private final String owner;
    private final String typeLabel;

    protected Vehicle(String typeLabel, String passNumber, String owner) {
        this.typeLabel = typeLabel;
        this.passNumber = passNumber;
        this.owner = owner;
    }
    public abstract double getPassFee();
    public String getPassNumber() { return passNumber; }
    public String getOwner() { return owner; }
    public String getTypeLabel() { return typeLabel; }
}

class Bike extends Vehicle {
    Bike(String label, String pass, String owner) { super(label, pass, owner); }
    @Override public double getPassFee() { return 300; }
}
class Car extends Vehicle {
    Car(String label, String pass, String owner) { super(label, pass, owner); }
    @Override public double getPassFee() { return 1000; }
}
class EBike extends Vehicle implements Chargeable {
    private boolean bayBooked;
    EBike(String label, String pass, String owner) { super(label, pass, owner); }
    @Override public double getPassFee() { return 300; }
    @Override public void bookChargingBay() { bayBooked = true; }
}
class ECar extends Vehicle implements Chargeable {
    private boolean bayBooked;
    ECar(String label, String pass, String owner) { super(label, pass, owner); }
    @Override public double getPassFee() { return 1000; }
    @Override public void bookChargingBay() { bayBooked = true; }
}

public class Main {
    static String fmt(double v) { return v == Math.rint(v) ? String.valueOf((long) v) : String.format(Locale.US, "%.2f", v); }

    static Vehicle create(String type, String pass, String owner) {
        switch (type.toLowerCase().replace("-", "").replace("_", "")) {
            case "bike":  return new Bike(type, pass, owner);
            case "car":   return new Car(type, pass, owner);
            case "ebike": return new EBike(type, pass, owner);
            case "ecar":  return new ECar(type, pass, owner);
            default:      return null;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder all = new StringBuilder();
        for (String line; (line = in.readLine()) != null; ) all.append(line).append(' ');
        String[] t = all.toString().trim().split("\\s+");

        Map<String, Vehicle> vehicles = new HashMap<>();
        StringBuilder out = new StringBuilder();
        int i = 0;
        while (i < t.length) {
            if (t[i].equalsIgnoreCase("PASS") && i + 3 < t.length) {
                Vehicle v = create(t[i + 1], t[i + 2], t[i + 3]);
                if (v == null) out.append("Unknown vehicle type ").append(t[i + 1]).append('\n');
                else {
                    vehicles.put(v.getPassNumber(), v);
                    out.append(v.getPassNumber()).append(" (").append(v.getTypeLabel()).append(") pass fee ")
                       .append(fmt(v.getPassFee())).append('\n');
                }
                i += 4;
            } else if (t[i].equalsIgnoreCase("CHARGE") && i + 1 < t.length) {
                Vehicle v = vehicles.get(t[i + 1]);
                if (v == null) out.append("Vehicle not found\n");
                else if (v instanceof Chargeable) {
                    ((Chargeable) v).bookChargingBay();
                    out.append(v.getPassNumber()).append(" charging bay allotted\n");
                } else out.append(v.getPassNumber()).append(" rejected: charging unsupported\n");
                i += 2;
            } else i++;
        }
        System.out.print(out);
    }
}
