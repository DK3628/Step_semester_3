/** Doubly linked node (no java.util.LinkedList used). */
class Node {
    String name;
    Node prev, next;
    Node(String name) { this.name = name; }
}

/**
 * Doubly linked list with head and tail references.
 *
 * Complexity:
 *   addLast(name)            O(1) - tail reference.
 *   remove(name): finding    O(n) - linear search from the head for the first matching name.
 *   remove(name): unlinking  O(1) - once the node is found, only its two neighbours are relinked.
 *   printForward/Backward    O(n)
 * Extra space: O(1) for add/remove (printing builds an O(n) output string).
 */
class Train {
    private Node head, tail;

    public void addLast(String name) {
        Node node = new Node(name);
        if (tail == null) {
            head = tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
    }

    /** Removes the first coach with this name. @return true if a coach was removed. */
    public boolean remove(String name) {
        Node cur = head;
        while (cur != null && !cur.name.equals(name)) cur = cur.next;   // find: O(n)
        if (cur == null) return false;                                   // not found

        // unlink: O(1), fixing both neighbours with care at head and tail
        if (cur.prev != null) cur.prev.next = cur.next; else head = cur.next;
        if (cur.next != null) cur.next.prev = cur.prev; else tail = cur.prev;
        cur.prev = cur.next = null;    // detach the removed node completely
        return true;
    }

    public void printForward() {
        StringBuilder sb = new StringBuilder("Forward: ");
        for (Node cur = head; cur != null; cur = cur.next) {
            sb.append(cur.name);
            if (cur.next != null) sb.append(" <-> ");
        }
        System.out.println(sb);
    }

    public void printBackward() {
        StringBuilder sb = new StringBuilder("Backward: ");
        for (Node cur = tail; cur != null; cur = cur.prev) {
            sb.append(cur.name);
            if (cur.prev != null) sb.append(" <-> ");
        }
        System.out.println(sb);
    }
}

public class Main {
    public static void main(String[] args) {
        Train train = new Train();
        for (String c : new String[]{"Engine", "A1", "B1", "B2", "Guard"}) train.addLast(c);
        train.remove("B1");
        train.printForward();    // Forward: Engine <-> A1 <-> B2 <-> Guard
        train.printBackward();   // Backward: Guard <-> B2 <-> A1 <-> Engine

        // extra cases: remove head, remove tail, missing coach, remove the only coach
        Train t2 = new Train();
        for (String c : new String[]{"Engine", "A1", "Guard"}) t2.addLast(c);
        t2.remove("Engine");
        t2.remove("Guard");
        System.out.println("missing removed? " + t2.remove("Z9"));   // false
        t2.printForward();       // Forward: A1
        t2.printBackward();      // Backward: A1
        t2.remove("A1");
        t2.printForward();       // Forward: (nothing after the label, train is empty)
    }
}
