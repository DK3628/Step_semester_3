/** Node with data and next fields (no java.util.LinkedList used). */
class Node {
    int data;
    Node next;
    Node(int data) { this.data = data; }
    Node(int data, Node next) { this.data = data; this.next = next; }
}

public class Main {

    /**
     * Removes every node whose data equals code and returns the (possibly new) head.
     *
     * Time complexity : O(n) - each node is visited once.
     * Extra space     : O(1) - only a few references; the list is modified in place.
     */
    public static Node removeAll(Node head, int code) {
        // Step 1: drop matching nodes from the front by moving head
        while (head != null && head.data == code) head = head.next;

        // Step 2: walk with a previous reference and skip matching nodes
        Node prev = head;
        while (prev != null && prev.next != null) {
            if (prev.next.data == code) prev.next = prev.next.next;   // unlink, stay on prev
            else prev = prev.next;
        }
        return head;
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
        System.out.println(show(removeAll(build(5, 3, 5, 8, 5), 5)));  // 3 -> 8 -> null
        System.out.println(show(removeAll(build(5, 5, 5), 5)));        // null
        // extra cases
        System.out.println(show(removeAll(build(), 5)));               // null (empty list)
        System.out.println(show(removeAll(build(1, 2, 3), 9)));        // 1 -> 2 -> 3 -> null (no match)
        System.out.println(show(removeAll(build(1, 5, 5, 2, 5), 5)));  // 1 -> 2 -> null (consecutive + tail)
    }
}
