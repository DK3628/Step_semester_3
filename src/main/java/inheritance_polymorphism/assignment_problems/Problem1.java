class P1_GymMember {
    String memberId;
    int monthlyFee;
    int sessionsAttended = 0;

    public P1_GymMember(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().isEmpty() || memberId.length() < 4) {
            throw new IllegalArgumentException("construction rejected");
        }
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
    }

    public void attendSession() {
        sessionsAttended++;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
    }
}

class P1_PremiumMember extends P1_GymMember {
    String trainerName;

    public P1_PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }
}

public class Problem1 {
    public static String signUpBatch(String[] memberIds, int monthlyFee) {
        int enrolled = 0;
        int rejected = 0;
        for (String id : memberIds) {
            try {
                new P1_GymMember(id, monthlyFee);
                enrolled++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }
        return "Signed Up: " + enrolled + " | Rejected: " + rejected;
    }

    public static void main(String[] args) {
        try {
            new P1_GymMember("GM1", 1000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        P1_PremiumMember p = new P1_PremiumMember("MEM01", 2000, "Coach Riya");
        p.attendSession();
        p.attendSession();
        System.out.println(p.getSessionsAttended());

        String[] batch = {"MEM1", "GM1", "MEM2", " ", "MEM3"};
        System.out.println(signUpBatch(batch, 1000));
    }
}