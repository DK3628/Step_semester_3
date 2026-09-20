class P2_LibraryMember {
    String memberId;
    int borrowLimit;
    int booksBorrowed = 0;

    public P2_LibraryMember(String memberId, int borrowLimit) {
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
    }

    public void borrowBook() { booksBorrowed++; }
    
    public int getBooksBorrowed() { return booksBorrowed; }

    public String displayInfo() {
        return "General Member | Books Borrowed: " + booksBorrowed;
    }
}

class P2_StudentMember extends P2_LibraryMember {
    String course;

    public P2_StudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    @Override
    public String displayInfo() {
        return "Student Member | Course: " + course + " | Books Borrowed: " + booksBorrowed;
    }
}

class P2_HonorsStudentMember extends P2_StudentMember {
    int bonusLimit;

    public P2_HonorsStudentMember(String memberId, int borrowLimit, String course, int bonusLimit) {
        super(memberId, borrowLimit, course);
        this.bonusLimit = bonusLimit;
    }

    @Override
    public String displayInfo() {
        return "Honors Student Member | Course: " + course + " | Bonus Limit: " + bonusLimit + " | Books Borrowed: " + booksBorrowed;
    }
}

class P2_FacultyMember extends P2_LibraryMember {
    String department;

    public P2_FacultyMember(String memberId, int borrowLimit, String department) {
        super(memberId, borrowLimit);
        this.department = department;
    }

    @Override
    public String displayInfo() {
        return "Faculty Member | Department: " + department + " | Books Borrowed: " + booksBorrowed;
    }
}

public class Problem2 {
    public static String classifyGeneration(P2_LibraryMember member) {
        if (member instanceof P2_HonorsStudentMember) {
            return "Multilevel descendant (3 generations deep)";
        } else if (member instanceof P2_FacultyMember) {
            return "Hierarchical sibling (independent branch)";
        }
        return "Base or intermediate";
    }

    public static int getTotalBooksBorrowed(P2_LibraryMember[] members) {
        int total = 0;
        for (P2_LibraryMember m : members) {
            total += m.getBooksBorrowed();
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(new P2_LibraryMember("STU1", 3).displayInfo());
        System.out.println(new P2_StudentMember("STU2", 3, "CSE").displayInfo());
        System.out.println(new P2_HonorsStudentMember("STU3", 3, "ECE", 2).displayInfo());
        System.out.println(new P2_FacultyMember("STU4", 5, "Physics").displayInfo());

        P2_HonorsStudentMember honorsMember = new P2_HonorsStudentMember("STU3", 3, "ECE", 2);
        P2_FacultyMember facultyMember = new P2_FacultyMember("STU4", 5, "Physics");
        P2_StudentMember studentMember = new P2_StudentMember("STU2", 3, "CSE");

        System.out.println(classifyGeneration(honorsMember));
        System.out.println(classifyGeneration(facultyMember));

        studentMember.borrowBook();
        studentMember.borrowBook();
        honorsMember.borrowBook();
        facultyMember.borrowBook();
        facultyMember.borrowBook();
        facultyMember.borrowBook();

        P2_LibraryMember[] mix = {studentMember, honorsMember, facultyMember};
        System.out.println(getTotalBooksBorrowed(mix));
    }
}