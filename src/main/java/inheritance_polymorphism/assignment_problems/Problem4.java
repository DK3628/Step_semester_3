class P4_GymMember {
    String memberId;
    int monthlyFee;
    int sessionsAttended = 0;

    public P4_GymMember(String memberId, int monthlyFee) {
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
    }

    public String displayInfo() {
        return "Standard | Sessions: " + sessionsAttended;
    }
}

class P4_PremiumMember extends P4_GymMember {
    String trainerName;

    public P4_PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    public String getTrainerName() {
        return trainerName;
    }

    @Override
    public String displayInfo() {
        return "Premium | Trainer: " + trainerName + " | Sessions: " + sessionsAttended;
    }
}

public class Problem4 {
    public static String batchPrint(P4_GymMember[] members) {
        StringBuilder sb = new StringBuilder();
        for (P4_GymMember m : members) {
            sb.append(m.displayInfo());
            if (m instanceof P4_PremiumMember) {
                P4_PremiumMember pm = (P4_PremiumMember) m;
                sb.append(" [Trainer via downcast: ").append(pm.getTrainerName()).append("]");
            }
            sb.append(" | ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        P4_GymMember[] mix = {
            new P4_GymMember("MEM6", 1000),
            new P4_PremiumMember("MEM7", 2000, "Coach Riya")
        };
        System.out.println(batchPrint(mix));

        try {
            P4_GymMember plain = new P4_GymMember("MEM8", 1000);
            P4_PremiumMember bad = (P4_PremiumMember) plain;
        } catch (ClassCastException e) {
            System.out.println("ClassCastException at runtime");
        }
    }
}