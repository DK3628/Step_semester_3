/** Node with data and next fields (no java.util.LinkedList used). */
class Node {
    int data;
    Node next;
    Node(int data) { this.data = data; }
}

public class Main {

    /**
     * Reverses the list in place and returns the new head. No new nodes are created.
     *
     * Time complexity : O(n) - each node is visited once.
     * Extra space     : O(1) - three references (prev, current, next); iterative, so no recursion stack.
     */
    public static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;   // 1) remember the rest of the list
            current.next = prev;        // 2) turn this node's link around
            prev = current;             // 3) move prev forward
            current = next;             // 4) move current forward
        }
        return prev;                    // prev is the old tail = new head (null for an empty list)
    }

    // ----- helpers for the demo -----
    static Node build(int... values) {
        Node head = null, tail = null;
        for (int v : values) {
            Node n = new Node(v);
            if (head == null) head = tail = n; else { tail.next = n; tail = n; }
        }
        return head;
    }

    static String show(Node head) {
        StringBuilder sb = new StringBuilder();
        for (Node cur = head; cur != null; cur = cur.next) sb.append(cur.data).append(" -> ");
        return sb.append("null").toString();
    }

    public static void main(String[] args) {
        System.out.println(show(reverse(build(1, 2, 3, 4))));  // 4 -> 3 -> 2 -> 1 -> null
        System.out.println(show(reverse(build(9))));           // 9 -> null
        System.out.println(show(reverse(build())));            // null (empty list)
        System.out.println(show(reverse(build(1, 2))));        // 2 -> 1 -> null

        // confirm it is in place: the old head node becomes the tail
        Node head = build(1, 2, 3);
        Node oldHead = head;
        Node newHead = reverse(head);
        System.out.println("same nodes reused: " + (oldHead.next == null && newHead.data == 3));  // true
    }
}
