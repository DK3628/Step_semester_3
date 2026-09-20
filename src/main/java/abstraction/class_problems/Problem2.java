interface Printable {
    String printLabel();
}

class P2_PackageBox implements Printable {
    private String trackingId;

    public P2_PackageBox(String trackingId) {
        this.trackingId = trackingId;
    }

    @Override
    public String printLabel() {
        return "Package label: " + trackingId;
    }
}

class P2_Invoice implements Printable {
    private String invoiceNumber;

    public P2_Invoice(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    @Override
    public String printLabel() {
        return "Invoice label: " + invoiceNumber;
    }
}

public class Problem2 {
    public static void printAll(Printable[] items) {
        for (Printable item : items) {
            System.out.println(item.printLabel());
        }
    }

    public static void main(String[] args) {
        P2_PackageBox p = new P2_PackageBox("TRK-88");
        System.out.println(p.printLabel());

        P2_Invoice i = new P2_Invoice("INV-42");
        System.out.println(i.printLabel());

        printAll(new Printable[]{p, i});
    }
}