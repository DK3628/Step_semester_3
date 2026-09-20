public class Student {
    String name;
    int attendance;
    
    public static String collegeName = "SRM Institute of Science and Technology";
    public static int studentCount = 0;

    public Student(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    public static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {
        Student s1 = new Student("Alice", 85);
        Student s2 = new Student("Bob", 92);
        
        System.out.println(studentCount + " Student objects created\n");
        Student.printCollegeInfo();
    }
}