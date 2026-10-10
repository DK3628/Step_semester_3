import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        MembershipDesk desk = new MembershipDesk();
        Member asha = new Member("Asha"), ravi = new Member("Ravi");

        desk.buy(asha, new QuarterlyPlan());
        desk.buy(ravi, new MonthlyPlan());
        desk.checkIn(asha);
        desk.freeze(asha);
        desk.checkIn(asha);
        desk.expire(ravi);
        desk.freeze(ravi);
    }
}
