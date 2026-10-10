import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        LaundryService service = new LaundryService();
        WashingMachine m1 = new WashingMachine("M1");
        WashingMachine m2 = new WashingMachine("M2");
        Student asha = new Student("Asha"), ravi = new Student("Ravi"), neha = new Student("Neha");

        service.startWash(asha, m1, new QuickWash());
        service.startWash(ravi, m1, new HeavyWash());   // M1 busy
        service.startWash(ravi, m2, new HeavyWash());
        service.completeWash(m1);
        service.startWash(neha, m1, new NormalWash());
    }
}
