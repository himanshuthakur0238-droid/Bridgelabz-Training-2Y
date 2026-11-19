public class TextEditorUndoRedo {
    static class Node {
        String content;
        Node prev, next;

        Node(String content) {
            this.content = content;
        }
    }

    static Node head = null, tail = null, current = null;
    static int size = 0;
    static final int MAX_HISTORY = 10;

    static void addState(String content) {
        Node n = new Node(content);
        if (head == null) {
            head = tail = current = n;
            size = 1;
            return;
        }

        if (current != tail) {
            current.next = null;
            tail = current;
            size = 0;
            for (Node t = head; t != null; t = t.next) size++;
        }

        tail.next = n;
        n.prev = tail;
        tail = current = n;
        size++;

        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    static void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo performed.");
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    static void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo performed.");
        } else {
            System.out.println("Nothing to redo.");
        }
    }

    static void displayCurrent() {
        System.out.println("Current Text: \"" + (current != null ? current.content : "") + "\"");
    }

    public static void main(String[] args) {
        addState("Hello");
        addState("Hello World");
        addState("Hello World!");
        displayCurrent();

        undo();
        displayCurrent();

        undo();
        displayCurrent();

        redo();
        displayCurrent();

        addState("Hello Java");
        displayCurrent();
        redo();
    }
}
