abstract class P3_Instrument {
    public abstract String play();
}

class P3_StringInstrument extends P3_Instrument {
    public P3_StringInstrument() {
        super();
    }

    @Override
    public String play() {
        // Because the parent play() is abstract, we start the concrete message here.
        return "Strumming the strings";
    }
}

class P3_Violin extends P3_StringInstrument {
    public P3_Violin() {
        super();
    }

    @Override
    public String play() {
        // Reusing StringInstrument's message and adding the extra Violin detail
        return super.play() + ", with a bow drawn across four strings";
    }
}

public class Problem3 {
    public static void main(String[] args) {
        P3_StringInstrument s = new P3_StringInstrument();
        System.out.println(s.play());

        P3_Violin v = new P3_Violin();
        System.out.println(v.play());
    }
}