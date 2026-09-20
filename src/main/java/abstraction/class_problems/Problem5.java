abstract class P5_DeliveryNote {
    protected String trackingId;

    public P5_DeliveryNote(String trackingId) {
        this.trackingId = trackingId;
    }

    public abstract String confirmDelivery();

    public String confirmDelivery(String signature) {
        return confirmDelivery() + ", signed by " + signature;
    }
}

class P5_ParcelNote extends P5_DeliveryNote {
    public P5_ParcelNote(String trackingId) {
        super(trackingId);
    }

    @Override
    public String confirmDelivery() {
        return "Parcel " + trackingId + " delivered";
    }
}

class P5_LetterNote extends P5_DeliveryNote {
    public P5_LetterNote(String trackingId) {
        super(trackingId);
    }

    @Override
    public String confirmDelivery() {
        return "Letter " + trackingId + " delivered";
    }
}

public class Problem5 {
    public static void logAll(P5_DeliveryNote[] notes) {
        for (P5_DeliveryNote note : notes) {
            System.out.println(note.confirmDelivery());
        }
    }

    public static void main(String[] args) {
        P5_ParcelNote p = new P5_ParcelNote("TRK-1");
        System.out.println(p.confirmDelivery());
        System.out.println(p.confirmDelivery("J. Smith"));

        P5_DeliveryNote ref = p;
        P5_DeliveryNote[] notes = { ref, new P5_LetterNote("TRK-2") };
        logAll(notes);
    }
}