import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LeaveService service = new LeaveService();
        Employee john = new FullTimeEmployee("John");
        Employee jane = new PartTimeEmployee("Jane");
        Reviewer alice = new Reviewer("Alice"), bob = new Reviewer("Bob");

        LeaveRequest johnReq = service.submit(john, LocalDate.of(2025, 1, 1), LocalDate.of(2025, 1, 5));
        service.approve(alice, johnReq);
        LeaveRequest janeReq = service.submit(jane, LocalDate.of(2025, 2, 10), LocalDate.of(2025, 2, 11));
        service.reject(bob, janeReq);
        service.changeStatus(johnReq, LeaveStatus.PENDING, null);  // blocked
    }
}
