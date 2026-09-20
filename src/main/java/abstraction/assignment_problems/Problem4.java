abstract class P4_ClassroomDevice {
    public abstract String operate();
}

interface P4_Chargeable {
    String charge();
    String charge(int minutes);
}

class P4_Tablet extends P4_ClassroomDevice implements P4_Chargeable {
    private String assetTag;

    public P4_Tablet(String assetTag) {
        this.assetTag = assetTag;
    }

    @Override
    public String operate() {
        return "Tablet " + assetTag + " displaying lesson";
    }

    @Override
    public String charge() {
        return assetTag + " charging";
    }

    @Override
    public String charge(int minutes) {
        return assetTag + " charging for " + minutes + " minutes";
    }
}

public class Problem4 {
    public static void main(String[] args) {
        P4_Tablet t = new P4_Tablet("TAB-5");
        System.out.println(t.operate());
        System.out.println(t.charge());
        System.out.println(t.charge(30));
    }
}