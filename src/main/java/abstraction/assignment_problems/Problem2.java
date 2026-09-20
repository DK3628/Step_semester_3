abstract class P2_ArtPiece {
    private static int counter = 1000;
    private final String pieceId;

    public P2_ArtPiece() {
        counter++;
        this.pieceId = "ART-" + counter;
    }

    public abstract String describe();

    public String getPieceId() {
        return pieceId;
    }
}

class P2_Painting extends P2_ArtPiece {
    private String title;

    public P2_Painting(String title) {
        super();
        this.title = title;
    }

    @Override
    public String describe() {
        return "Painting: " + title + ", framed on canvas";
    }
}

class P2_Sculpture extends P2_ArtPiece {
    private String title;

    public P2_Sculpture(String title) {
        super();
        this.title = title;
    }

    @Override
    public String describe() {
        return "Sculpture: " + title + ", carved from stone";
    }
}

public class Problem2 {
    public static void main(String[] args) {
        P2_Painting p = new P2_Painting("Sunset Fields");
        System.out.println(p.describe());
        System.out.println("ID: " + p.getPieceId());

        P2_Sculpture s = new P2_Sculpture("The Thinker II");
        System.out.println(s.describe());
        System.out.println("ID: " + s.getPieceId());
    }
}