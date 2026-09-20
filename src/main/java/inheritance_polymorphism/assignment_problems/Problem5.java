class P5_GymMember {
    private static int counter = 2000;
    public final String membershipNumber;
    int monthlyFee;
    private int feesPaid = 0;

    public P5_GymMember(int monthlyFee) {
        this.monthlyFee = monthlyFee;
        counter++;
        this.membershipNumber = "GYM-" + counter;
    }

    public void payFee(int amount) {
        feesPaid += amount;
    }

    public void payFee(int amount, String mode) {
        // Record payment mode internally here if necessary, then delegate
        payFee(amount);
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public static boolean isValidReferralCode(String code) {
        if (code == null || code.length() != 4) return false;
        if (code.charAt(0) != 'G') return false;
        if (!Character.isDigit(code.charAt(1))) return false;
        if (!Character.isDigit(code.charAt(2))) return false;
        if (!Character.isUpperCase(code.charAt(3))) return false;
        return true;
    }

    public static int getMembersEnrolled() {
        return counter - 2000;
    }
}

class P5_GroupClassMember extends P5_GymMember {
    String className;

    public P5_GroupClassMember(int monthlyFee, String className) {
        super(monthlyFee);
        this.className = className;
    }
}

public class Problem5 {
    public static String processWeeklyCheckIn(P5_GymMember[] members) {
        int processed = 0;
        int nulls = 0;
        int group = 0;
        int individual = 0;

        for (P5_GymMember m : members) {
            if (m == null) {
                nulls++;
                continue;
            }
            processed++;
            if (m instanceof P5_GroupClassMember) {
                group++;
            } else {
                individual++;
            }
        }
        return processed + " processed | " + nulls + " null skipped | " + group + " group | " + individual + " individual";
    }

    public static void main(String[] args) {
        P5_GymMember m1 = new P5_GymMember(1000);
        System.out.println(m1.membershipNumber);
        System.out.println(P5_GymMember.getMembersEnrolled());

        System.out.println(P5_GymMember.isValidReferralCode("G45B"));
        System.out.println(P5_GymMember.isValidReferralCode("G4B"));
        System.out.println(P5_GymMember.isValidReferralCode("X45B"));

        m1.payFee(500);
        m1.payFee(500, "UPI");
        System.out.println(m1.getFeesPaid());

        P5_GymMember[] batch = {
            new P5_GroupClassMember(1500, "Zumba"),
            null,
            new P5_GymMember(1000)
        };
        System.out.println(processWeeklyCheckIn(batch));
    }
}