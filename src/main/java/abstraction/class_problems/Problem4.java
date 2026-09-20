interface Washable {
    String clean();
}

abstract class P4_KitchenTool {
    private int speedLevel = 1; // Default fallback

    public abstract String prepare();

    public int getSpeedLevel() {
        return speedLevel;
    }

    public void setSpeedLevel(int speedLevel) {
        if (speedLevel >= 1 && speedLevel <= 5) {
            this.speedLevel = speedLevel;
        } else {
            System.out.println("rejected, speed level stays " + this.speedLevel);
        }
    }
}

class P4_Blender extends P4_KitchenTool implements Washable {
    @Override
    public String prepare() {
        return "Blending at speed " + getSpeedLevel();
    }

    @Override
    public String clean() {
        return "Blender rinsed and dried";
    }
}

public class Problem4 {
    public static void main(String[] args) {
        P4_Blender b = new P4_Blender();
        b.setSpeedLevel(3);
        System.out.println(b.getSpeedLevel());

        b.setSpeedLevel(9); // Will be rejected
        System.out.println(b.getSpeedLevel());

        System.out.println(b.prepare());
        System.out.println(b.clean());
    }
}