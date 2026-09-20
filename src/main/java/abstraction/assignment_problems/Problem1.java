interface P1_Ringable {
    String ring();
}

class P1_AlarmClock implements P1_Ringable {
    private String time;

    public P1_AlarmClock(String time) {
        this.time = time;
    }

    @Override
    public String ring() {
        return "Alarm ringing for " + time;
    }
}

class P1_Doorbell implements P1_Ringable {
    private String location;

    public P1_Doorbell(String location) {
        this.location = location;
    }

    @Override
    public String ring() {
        return "Doorbell ringing at " + location;
    }
}

public class Problem1 {
    public static void ringAll(P1_Ringable[] devices) {
        for (P1_Ringable device : devices) {
            System.out.println(device.ring());
        }
    }

    public static void main(String[] args) {
        P1_AlarmClock a = new P1_AlarmClock("7:00 AM");
        System.out.println(a.ring());

        P1_Doorbell d = new P1_Doorbell("Front Door");
        System.out.println(d.ring());

        System.out.println("--- Batch Ring ---");
        ringAll(new P1_Ringable[]{a, d});
    }
}