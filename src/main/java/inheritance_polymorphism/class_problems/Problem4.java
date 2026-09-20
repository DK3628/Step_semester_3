class P4_LibraryMember {
    String memberId;
    int borrowLimit;
    int booksBorrowed = 0;

    public P4_LibraryMember(String memberId, int borrowLimit) {
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
    }

    public String displayInfo() {
        return "General | Books: " + booksBorrowed;
    }
}

class P4_StudentMember extends P4_LibraryMember {
    String course;

    public P4_StudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public String displayInfo() {
        return "Student | Course: " + course + " | Books: " + booksBorrowed;
    }
}

public class Problem4 {
    public static String batchPrint(P4_LibraryMember[] members) {
        StringBuilder sb = new StringBuilder();
        for (P4_LibraryMember m : members) {
            sb.append(m.displayInfo());
            if (m instanceof P4_StudentMember) {
                P4_StudentMember sm = (P4_StudentMember) m;
                sb.append(" [Course via downcast: ").append(sm.getCourse()).append("]");
            }
            sb.append(" | ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        P4_LibraryMember[] mix = {
            new P4_LibraryMember("LB5", 3),
            new P4_StudentMember("STU6", 3, "ECE")
        };
        System.out.println(batchPrint(mix));

        try {
            P4_LibraryMember plain = new P4_LibraryMember("LB6", 3);
            P4_StudentMember bad = (P4_StudentMember) plain; // Will throw ClassCastException
        } catch (ClassCastException e) {
            System.out.println("ClassCastException at runtime");
        }
    }
}