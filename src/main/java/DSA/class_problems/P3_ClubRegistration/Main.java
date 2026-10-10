import java.io.*;
import java.util.*;

/** Identity is the roll number only: equals/hashCode ignore the name. */
class Student {
    private final String rollNumber;
    private final String name;

    Student(String rollNumber, String name) { this.rollNumber = rollNumber; this.name = name; }

    public String getRollNumber() { return rollNumber; }
    public String getName() { return name; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        return rollNumber.equals(((Student) o).rollNumber);
    }
    @Override public int hashCode() { return rollNumber.hashCode(); }
}

class ClubRegistry {
    private final Set<Student> members = new HashSet<>();   // O(1) average add/contains
    boolean add(Student s) { return members.add(s); }
    boolean contains(Student s) { return members.contains(s); }
    int count() { return members.size(); }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder all = new StringBuilder();
        for (String line; (line = in.readLine()) != null; ) all.append(line).append(' ');
        String[] t = all.toString().trim().split("\\s+");

        ClubRegistry club = new ClubRegistry();
        StringBuilder addOut = new StringBuilder(), containsOut = new StringBuilder();
        int i = 0;
        while (i < t.length) {
            if (t[i].equalsIgnoreCase("ADD") && i + 2 < t.length) {
                addOut.append(club.add(new Student(t[i + 1], t[i + 2])) ? "Added" : "duplicate rejected").append('\n');
                i += 3;
            } else if (t[i].equalsIgnoreCase("CONTAINS") && i + 2 < t.length) {
                containsOut.append("contains: ").append(club.contains(new Student(t[i + 1], t[i + 2]))).append('\n');
                i += 3;
            } else i++;
        }
        System.out.print(addOut);
        System.out.println("member count " + club.count());
        System.out.print(containsOut);
    }
}
