public class Employee {
    String empId;
    double salary;

    public Employee(String empId, double salary) {
        this.empId = empId;
        this.salary = salary;
    }

    public void raiseSalary(double salary) {
        this.salary += salary;
    }

    public static void main(String[] args) {
        double[] salaries = {40000, 55000, 62000, 48000};
        Employee[] team = new Employee[salaries.length];

        for (int i = 0; i < salaries.length; i++) {
            team[i] = new Employee("E-10" + (i + 1), salaries[i]);
            team[i].raiseSalary(5000);
            System.out.println(team[i].empId + " | Final Salary: Rs " + team[i].salary);
        }
    }
}