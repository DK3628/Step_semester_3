class P5_LibraryMember {
    private static int counter = 100;
    public final String memberNumber;
    int borrowLimit;
    int booksBorrowed = 0;

    public P5_LibraryMember(int borrowLimit) {
        this.borrowLimit = borrowLimit;
        counter++;
        this.memberNumber = "LIB-" + counter;
    }

    public void borrowBook() {
        booksBorrowed++;
    }

    public void borrowBook(String genre) {
        // Records genre internally here if needed, then delegates
        borrowBook();
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public static boolean isValidRenewalCode(String code) {
        if (code == null || code.length() != 4) return false;
        if (code.charAt(0) != 'R') return false;
        if (!Character.isDigit(code.charAt(1))) return false;
        if (!Character.isDigit(code.charAt(2))) return false;
        if (!Character.isUpperCase(code.charAt(3))) return false;
        return true;
    }

    public static int getMembersEnrolled() {
        return counter - 100;
    }
}

class P5_FacultyMember extends P5_LibraryMember {
    String department;

    public P5_FacultyMember(int borrowLimit, String department) {
        super(borrowLimit);
        this.department = department;
    }
}

public class Problem5 {
    public static String processNightlyAudit(P5_LibraryMember[] members) {
        int processed = 0;
        int nulls = 0;
        int faculty = 0;
        int regular = 0;

        for (P5_LibraryMember m : members) {
            if (m == null) {
                nulls++;
                continue;
            }
            processed++;
            if (m instanceof P5_FacultyMember) {
                faculty++;
            } else {
                regular++;
            }
        }
        return processed + " processed | " + nulls + " null skipped | " + faculty + " faculty | " + regular + " regular";
    }

    public static void main(String[] args) {
        P5_LibraryMember m1 = new P5_LibraryMember(3);
        System.out.println(m1.memberNumber);
        System.out.println(P5_LibraryMember.getMembersEnrolled());

        System.out.println(P5_LibraryMember.isValidRenewalCode("R12A"));
        System.out.println(P5_LibraryMember.isValidRenewalCode("R1A"));
        System.out.println(P5_LibraryMember.isValidRenewalCode("X12A"));

        m1.borrowBook();
        m1.borrowBook("Fiction");
        System.out.println(m1.getBooksBorrowed());

        P5_LibraryMember[] batch = {
            new P5_FacultyMember(5, "Physics"),
            null,
            new P5_LibraryMember(3)
        };
        System.out.println(processNightlyAudit(batch));
    }
}