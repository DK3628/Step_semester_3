// Note: Renamed from Employee to CompanyEmployee to avoid compilation conflict with M3.
public class CompanyEmployee {
    String empName;
    double salary;

    public static String companyName = "Bright Horizon Technologies";
    public static int employeeCount = 0;

    public CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        CompanyEmployee e1 = new CompanyEmployee("Alice", 50000);
        CompanyEmployee e2 = new CompanyEmployee("Bob", 60000);
        CompanyEmployee e3 = new CompanyEmployee("Charlie", 55000);

        CompanyEmployee.printCompanyInfo();
    }
}