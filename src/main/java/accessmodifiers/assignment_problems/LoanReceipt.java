import java.util.Arrays;

// Note: Removed 'final' modifier from class signature to allow ReferenceOnlyLoanReceipt 
// to extend it (as requested in the prompt). Fields remain strictly final and defensively copied.
public class LoanReceipt {
    private final String memberId;
    private final String[] bookIds;

    public LoanReceipt(String memberId, String[] bookIds) {
        this.memberId = memberId;
        this.bookIds = bookIds != null ? Arrays.copyOf(bookIds, bookIds.length) : new String[0];
    }

    public String[] getBookIds() {
        return Arrays.copyOf(bookIds, bookIds.length);
    }

    public String getMemberId() {
        return memberId;
    }

    public LoanReceipt withCorrectedBookId(int index, String newId) {
        String[] updatedIds = getBookIds();
        if (index >= 0 && index < updatedIds.length) {
            updatedIds[index] = newId;
        }
        return new LoanReceipt(this.memberId, updatedIds);
    }
}