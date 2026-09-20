class P1_LibraryMember {
    String memberId;
    int borrowLimit;
    int booksBorrowed = 0;

    public P1_LibraryMember(String memberId, int borrowLimit) {
        if (memberId == null || memberId.trim().isEmpty() || memberId.length() < 4) {
            throw new IllegalArgumentException("construction rejected");
        }
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
    }

    public void borrowBook() {
        booksBorrowed++;
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }
}

class P1_StudentMember extends P1_LibraryMember {
    String course;

    public P1_StudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }
}

public class Problem1 {
    public static String enrollBatch(String[] memberIds, int borrowLimit) {
        int enrolled = 0;
        int rejected = 0;
        for (String id : memberIds) {
            try {
                new P1_LibraryMember(id, borrowLimit);
                enrolled++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }
        return "Enrolled: " + enrolled + " | Rejected: " + rejected;
    }

    public static void main(String[] args) {
        try {
            new P1_LibraryMember("LB1", 3);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        P1_StudentMember s = new P1_StudentMember("STU10", 3, "CSE");
        s.borrowBook();
        s.borrowBook();
        System.out.println(s.getBooksBorrowed());

        String[] batch = {"STU1", "LB1", "STU2", " ", "STU3"};
        System.out.println(enrollBatch(batch, 3));
    }
}