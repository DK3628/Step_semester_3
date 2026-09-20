import java.util.Arrays;

class P3_LibraryMember {
    String memberId;
    int borrowLimit;
    private int[] fineHistory = new int[10];
    private int fineCount = 0;

    public P3_LibraryMember(String memberId, int borrowLimit) {
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
    }

    protected void chargeFine(int amount) {
        if (fineCount < fineHistory.length && amount > 0) {
            fineHistory[fineCount++] = amount;
        }
    }

    public int[] getFineHistory() {
        return Arrays.copyOf(fineHistory, fineCount);
    }

    public int getTotalFine() {
        int sum = 0;
        for (int i = 0; i < fineCount; i++) {
            sum += fineHistory[i];
        }
        return sum;
    }
}

class P3_StudentMember extends P3_LibraryMember {
    String course;

    public P3_StudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    @Override
    protected void chargeFine(int amount) {
        super.chargeFine(amount / 2);
    }
}

public class Problem3 {
    public static void main(String[] args) {
        P3_StudentMember s = new P3_StudentMember("STU5", 3, "CSE");
        s.chargeFine(100);
        System.out.println(s.getTotalFine());

        int[] history = s.getFineHistory();
        history[0] = 999; 
        System.out.println(Arrays.toString(s.getFineHistory()));
    }
}