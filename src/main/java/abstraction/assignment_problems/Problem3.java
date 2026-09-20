abstract class P3_GardenTool {
    public abstract String use();
}

class P3_CuttingTool extends P3_GardenTool {
    public P3_CuttingTool() {
        super();
    }

    @Override
    public String use() {
        return "Using the tool in the garden, blade sharpened first";
    }
}

class P3_Pruner extends P3_CuttingTool {
    public P3_Pruner() {
        super();
    }

    @Override
    public String use() {
        return super.use() + ", then trimming branches precisely";
    }
}

public class Problem3 {
    public static void main(String[] args) {
        P3_CuttingTool c = new P3_CuttingTool();
        System.out.println(c.use());

        P3_Pruner p = new P3_Pruner();
        System.out.println(p.use());
    }
}