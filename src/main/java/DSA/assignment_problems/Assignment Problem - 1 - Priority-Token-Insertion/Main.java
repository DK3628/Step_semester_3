/** Node with data and next fields (no java.util.LinkedList used). */
class Node {
    int data;
    Node next;
    Node(int data) { this.data = data; }
}

/**
 * Singly linked list with a head and a tail pointer.
 *
 * Complexity:
 *   addFirst(token)        O(1)  - relink head only.
 *   addLast(token)         O(1)  - the tail pointer avoids walking the list
 *                                  (O(n) if the list kept only a head pointer).
 *   insertAt(index, token) O(n)  - worst case walks to the node before the index;
 *                                  O(1) when index is 0 or size (delegates to the two above).
 * Extra space for each operation: O(1) (just the new node).
 */
class TokenList {
    private Node head, tail;
    private int size;

    public void addFirst(int token) {
        Node node = new Node(token);
        node.next = head;
        head = node;
        if (tail == null) tail = node;       // list was empty
        size++;
    }

    public void addLast(int token) {
        Node node = new Node(token);
        if (tail == null) head = tail = node;
        else { tail.next = node; tail = node; }
        size++;
    }

    /** index is 0-based, 0 <= index <= size. */
    public void insertAt(int index, int token) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index " + index + " out of range for size " + size);
        if (index == 0) { addFirst(token); return; }
        if (index == size) { addLast(token); return; }

        Node prev = head;
        for (int i = 0; i < index - 1; i++) prev = prev.next;   // node just before the index
        Node node = new Node(token);
        node.next = prev.next;     // 1) new node points to the rest of the list first
        prev.next = node;          // 2) then the previous node links to the new node
        size++;
    }

    public int size() { return size; }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node cur = head; cur != null; cur = cur.next) sb.append(cur.data).append(" -> ");
        return sb.append("null").toString();
    }
}

public class Main {
    public static void main(String[] args) {
        // Example from the problem: start = 101 -> 102 -> 103
        TokenList list = new TokenList();
        list.addLast(101);
        list.addLast(102);
        list.addLast(103);

        list.addFirst(100);
        list.addLast(104);
        list.insertAt(2, 150);
        System.out.println(list);   // 100 -> 101 -> 150 -> 102 -> 103 -> 104 -> null

        // Edge cases: empty list, insert at both ends, bad index
        TokenList empty = new TokenList();
        empty.insertAt(0, 7);
        empty.insertAt(1, 9);       // index == size -> append
        empty.insertAt(0, 5);       // index 0 -> front
        System.out.println(empty);  // 5 -> 7 -> 9 -> null
        try { empty.insertAt(5, 1); } catch (IndexOutOfBoundsException e) { System.out.println(e.getMessage()); }
    }
}
