public class LibraryManagementSystem {
    static class Node {
        int id;
        String title, author, genre;
        boolean available;
        Node prev, next;

        Node(int id, String title, String author, String genre, boolean available) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.available = available;
        }
    }

    static Node head = null, tail = null;

    static void addFirst(int id, String title, String author, String genre, boolean available) {
        Node n = new Node(id, title, author, genre, available);
        if (head == null) head = tail = n;
        else { n.next = head; head.prev = n; head = n; }
    }

    static void addLast(int id, String title, String author, String genre, boolean available) {
        Node n = new Node(id, title, author, genre, available);
        if (tail == null) head = tail = n;
        else { tail.next = n; n.prev = tail; tail = n; }
    }

    static void addAtPos(int pos, int id, String title, String author, String genre, boolean available) {
        if (pos <= 1 || head == null) { addFirst(id, title, author, genre, available); return; }
        Node cur = head;
        for (int i = 1; i < pos - 1 && cur.next != null; i++) cur = cur.next;
        if (cur.next == null) { addLast(id, title, author, genre, available); return; }
        Node n = new Node(id, title, author, genre, available);
        n.next = cur.next; n.prev = cur;
        cur.next.prev = n; cur.next = n;
    }

    static void removeById(int id) {
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.id == id) {
                if (cur == head && cur == tail) head = tail = null;
                else if (cur == head) { head = head.next; head.prev = null; }
                else if (cur == tail) { tail = tail.prev; tail.next = null; }
                else { cur.prev.next = cur.next; cur.next.prev = cur.prev; }
                return;
            }
        }
    }

    static void search(String query) {
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.title.equalsIgnoreCase(query) || cur.author.equalsIgnoreCase(query)) {
                System.out.println("Found: " + cur.id + " | " + cur.title + " | " + cur.author + " | Available: " + cur.available);
            }
        }
    }

    static void updateAvailability(int id, boolean status) {
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.id == id) { cur.available = status; return; }
        }
    }

    static void display(boolean reverse) {
        for (Node cur = reverse ? tail : head; cur != null; cur = reverse ? cur.prev : cur.next) {
            System.out.println(cur.id + " | " + cur.title + " | " + cur.author + " | " + cur.genre + " | Available: " + cur.available);
        }
    }

    static int countBooks() {
        int count = 0;
        for (Node cur = head; cur != null; cur = cur.next) count++;
        return count;
    }

    public static void main(String[] args) {
        addFirst(101, "1984", "George Orwell", "Dystopian", true);
        addLast(102, "Dune", "Frank Herbert", "Sci-Fi", true);
        addAtPos(2, 103, "The Hobbit", "J.R.R. Tolkien", "Fantasy", false);

        updateAvailability(103, true);
        search("Frank Herbert");

        System.out.println("--- Forward ---");
        display(false);
        System.out.println("--- Reverse ---");
        display(true);

        System.out.println("Total Books: " + countBooks());
        removeById(101);
        System.out.println("Total Books after removal: " + countBooks());
    }
}
