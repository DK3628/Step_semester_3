import java.util.Arrays;

class P3_GymMember {
    String memberId;
    int monthlyFee;
    private int[] lateFeeHistory = new int[10];
    private int feeCount = 0;

    public P3_GymMember(String memberId, int monthlyFee) {
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
    }

    protected void chargeLateFee(int amount) {
        if (feeCount < lateFeeHistory.length && amount > 0) {
            lateFeeHistory[feeCount++] = amount;
        }
    }

    public int[] getLateFeeHistory() {
        return Arrays.copyOf(lateFeeHistory, feeCount);
    }

    public int getTotalLateFees() {
        int sum = 0;
        for (int i = 0; i < feeCount; i++) {
            sum += lateFeeHistory[i];
        }
        return sum;
    }
}

class P3_PremiumMember extends P3_GymMember {
    String trainerName;

    public P3_PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    @Override
    protected void chargeLateFee(int amount) {
        super.chargeLateFee(amount / 2);
    }
}

public class Problem3 {
    public static void main(String[] args) {
        P3_PremiumMember p = new P3_PremiumMember("MEM5", 2000, "Coach Riya");
        p.chargeLateFee(200);
        System.out.println(p.getTotalLateFees());

        int[] history = p.getLateFeeHistory();
        history[0] = 999;
        System.out.println(Arrays.toString(p.getLateFeeHistory()));
    }
}