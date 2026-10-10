/** Node with name and next fields (no java.util.LinkedList used). */
class Node {
    String name;
    Node next;
    Node(String name) { this.name = name; }
}

/**
 * Circular singly linked list that keeps only a tail reference; head = tail.next.
 *
 * Complexity:
 *   addLast(name)    O(1)     - new node goes after tail, then becomes the tail.
 *   printTurns(t)    O(t)     - one step per turn; the list wraps around by itself,
 *                               so it does not depend on the number of players.
 * Extra space: O(1) for addLast; printTurns builds only the output text (O(t)).
 */
class TurnCircle {
    private Node tail;

    public void addLast(String name) {
        Node node = new Node(name);
        if (tail == null) {
            node.next = node;          // single node points to itself
        } else {
            node.next = tail.next;     // new node points to the head
            tail.next = node;          // old tail points to the new node
        }
        tail = node;
    }

    /** Prints the player for each turn, space-separated, on one line. */
    public void printTurns(int turns) {
        if (tail == null || turns <= 0) { System.out.println(); return; }
        StringBuilder sb = new StringBuilder();
        Node cur = tail.next;          // head
        for (int i = 0; i < turns; i++) {
            if (i > 0) sb.append(' ');
            sb.append(cur.name);
            cur = cur.next;            // wraps from tail back to head automatically
        }
        System.out.println(sb);
    }
}

public class Main {
    public static void main(String[] args) {
        TurnCircle game = new TurnCircle();
        game.addLast("Asha");
        game.addLast("Ravi");
        game.addLast("Neha");
        game.printTurns(7);            // Asha Ravi Neha Asha Ravi Neha Asha

        // extra cases
        TurnCircle solo = new TurnCircle();
        solo.addLast("Kiran");
        solo.printTurns(3);            // Kiran Kiran Kiran

        TurnCircle two = new TurnCircle();
        two.addLast("A");
        two.addLast("B");
        two.printTurns(1);             // A
    }
}
