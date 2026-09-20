abstract class P1_Toy {
    private static int counter = 1000;
    private final String toyId;

    public P1_Toy() {
        counter++;
        this.toyId = "TOY-" + counter;
    }

    public abstract String makeSound();

    public String getToyId() {
        return toyId;
    }
}

class P1_ToyCar extends P1_Toy {
    private String name;

    public P1_ToyCar(String name) {
        super();
        this.name = name;
    }

    @Override
    public String makeSound() {
        return name + ": Vroom vroom!";
    }
}

class P1_ToyRobot extends P1_Toy {
    private String name;

    public P1_ToyRobot(String name) {
        super();
        this.name = name;
    }

    @Override
    public String makeSound() {
        return name + ": Beep boop!";
    }
}

public class Problem1 {
    public static void main(String[] args) {
        // P1_Toy t = new P1_Toy(); // This would fail to compile, fulfilling the requirement.

        P1_ToyCar c = new P1_ToyCar("Speedster");
        System.out.println(c.makeSound());

        P1_ToyRobot r = new P1_ToyRobot("Bolt");
        System.out.println(r.makeSound());

        System.out.println(c.getToyId());
        System.out.println(r.getToyId());
    }
}