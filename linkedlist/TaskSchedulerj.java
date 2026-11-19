public class n {
    static class Node {
        int id;
        String name, priority, dueDate;
        Node next;

        Node(int id, String name, String priority, String dueDate) {
            this.id = id;
            this.name = name;
            this.priority = priority;
            this.dueDate = dueDate;
        }
    }

    static Node head = null, tail = null, current = null;

    static void addFirst(int id, String name, String priority, String dueDate) {
        Node n = new Node(id, name, priority, dueDate);
        if (head == null) {
            head = tail = current = n;
            n.next = head;
        } else {
            n.next = head;
            head = n;
            tail.next = head;
        }
    }

    static void addLast(int id, String name, String priority, String dueDate) {
        Node n = new Node(id, name, priority, dueDate);
        if (head == null) {
            addFirst(id, name, priority, dueDate);
        } else {
            tail.next = n;
            tail = n;
            tail.next = head;
        }
    }

    static void addAtPos(int pos, int id, String name, String priority, String dueDate) {
        if (pos <= 1 || head == null) { addFirst(id, name, priority, dueDate); return; }
        Node cur = head;
        for (int i = 1; i < pos - 1 && cur.next != head; i++) cur = cur.next;
        if (cur == tail) { addLast(id, name, priority, dueDate); return; }
        Node n = new Node(id, name, priority, dueDate);
        n.next = cur.next;
        cur.next = n;
    }

    static void removeById(int id) {
        if (head == null) return;
        Node cur = head, prev = tail;
        do {
            if (cur.id == id) {
                if (head == tail) {
                    head = tail = current = null;
                } else {
                    if (cur == head) head = head.next;
                    if (cur == tail) tail = prev;
                    if (cur == current) current = cur.next;
                    prev.next = cur.next;
                    tail.next = head;
                }
                return;
            }
            prev = cur;
            cur = cur.next;
        } while (cur != head);
    }

    static void viewAndNext() {
        if (current == null) {
            System.out.println("No tasks scheduled");
            return;
        }
        System.out.println("Current Task -> " + current.id + " | " + current.name + " | " + current.priority + " | " + current.dueDate);
        current = current.next;
    }

    static void displayAll() {
        if (head == null) { System.out.println("Empty list"); return; }
        Node cur = head;
        do {
            System.out.println(cur.id + " | " + cur.name + " | " + cur.priority + " | " + cur.dueDate);
            cur = cur.next;
        } while (cur != head);
    }

    static void searchByPriority(String priority) {
        if (head == null) return;
        Node cur = head;
        do {
            if (cur.priority.equalsIgnoreCase(priority)) {
                System.out.println("Found: " + cur.id + " | " + cur.name + " | " + cur.dueDate);
            }
            cur = cur.next;
        } while (cur != head);
    }

    public static void main(String[] args) {
        addFirst(1, "Design UI", "High", "2026-11-20");
        addLast(2, "Write API", "Medium", "2026-11-22");
        addAtPos(2, 3, "Setup DB", "High", "2026-11-21");

        System.out.println("--- All Tasks ---");
        displayAll();

        System.out.println("--- Round-Robin Execution ---");
        viewAndNext();
        viewAndNext();

        System.out.println("--- High Priority Tasks ---");
        searchByPriority("High");

        removeById(3);
        System.out.println("--- After Removal ---");
        displayAll();
    }
}
