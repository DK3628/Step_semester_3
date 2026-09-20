class P2_GymMember {
    String memberId;
    int monthlyFee;
    int sessionsAttended = 0;

    public P2_GymMember(String memberId, int monthlyFee) {
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
    }

    public void attendSession() { sessionsAttended++; }
    public int getSessionsAttended() { return sessionsAttended; }

    public String displayInfo() {
        return "Standard Member | Sessions: " + sessionsAttended;
    }
}

class P2_PremiumMember extends P2_GymMember {
    String trainerName;

    public P2_PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    @Override
    public String displayInfo() {
        return "Premium Member | Trainer: " + trainerName + " | Sessions: " + sessionsAttended;
    }
}

class P2_EliteMember extends P2_PremiumMember {
    String lockerNumber;

    public P2_EliteMember(String memberId, int monthlyFee, String trainerName, String lockerNumber) {
        super(memberId, monthlyFee, trainerName);
        this.lockerNumber = lockerNumber;
    }

    @Override
    public String displayInfo() {
        return "Elite Member | Trainer: " + trainerName + " | Locker: " + lockerNumber + " | Sessions: " + sessionsAttended;
    }
}

class P2_GroupClassMember extends P2_GymMember {
    String className;

    public P2_GroupClassMember(String memberId, int monthlyFee, String className) {
        super(memberId, monthlyFee);
        this.className = className;
    }

    @Override
    public String displayInfo() {
        return "Group Class Member | Class: " + className + " | Sessions: " + sessionsAttended;
    }
}

public class Problem2 {
    public static String classifyGeneration(P2_GymMember member) {
        if (member instanceof P2_EliteMember) {
            return "Multilevel descendant (3 generations deep)";
        } else if (member instanceof P2_GroupClassMember) {
            return "Hierarchical sibling (independent branch)";
        }
        return "Base or intermediate";
    }

    public static int getTotalSessionsAttended(P2_GymMember[] members) {
        int total = 0;
        for (P2_GymMember m : members) {
            total += m.getSessionsAttended();
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(new P2_GymMember("MEM1", 1000).displayInfo());
        System.out.println(new P2_PremiumMember("MEM2", 2000, "Coach Riya").displayInfo());
        System.out.println(new P2_EliteMember("MEM3", 3000, "Coach Arjun", "L12").displayInfo());
        System.out.println(new P2_GroupClassMember("MEM4", 1500, "Zumba").displayInfo());

        P2_PremiumMember premiumMember = new P2_PremiumMember("MEM2", 2000, "Coach Riya");
        P2_EliteMember eliteMember = new P2_EliteMember("MEM3", 3000, "Coach Arjun", "L12");
        P2_GroupClassMember groupClassMember = new P2_GroupClassMember("MEM4", 1500, "Zumba");

        System.out.println(classifyGeneration(eliteMember));
        System.out.println(classifyGeneration(groupClassMember));

        for(int i=0; i<3; i++) premiumMember.attendSession();
        for(int i=0; i<2; i++) eliteMember.attendSession();
        for(int i=0; i<4; i++) groupClassMember.attendSession();

        P2_GymMember[] mix = {premiumMember, eliteMember, groupClassMember};
        System.out.println(getTotalSessionsAttended(mix));
    }
}