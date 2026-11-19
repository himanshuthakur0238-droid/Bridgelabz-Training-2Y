public class MovieManagementSystem {
    static class Node {
        String title, director;
        int year;
        double rating;
        Node prev, next;

        Node(String title, String director, int year, double rating) {
            this.title = title;
            this.director = director;
            this.year = year;
            this.rating = rating;
        }
    }

    static Node head = null, tail = null;

    static void addFirst(String t, String d, int y, double r) {
        Node n = new Node(t, d, y, r);
        if (head == null) head = tail = n;
        else { n.next = head; head.prev = n; head = n; }
    }

    static void addLast(String t, String d, int y, double r) {
        Node n = new Node(t, d, y, r);
        if (tail == null) head = tail = n;
        else { tail.next = n; n.prev = tail; tail = n; }
    }

    static void addAtPos(int pos, String t, String d, int y, double r) {
        if (pos <= 1 || head == null) { addFirst(t, d, y, r); return; }
        Node cur = head;
        for (int i = 1; i < pos - 1 && cur.next != null; i++) cur = cur.next;
        if (cur.next == null) { addLast(t, d, y, r); return; }
        Node n = new Node(t, d, y, r);
        n.next = cur.next; n.prev = cur;
        cur.next.prev = n; cur.next = n;
    }

    static void remove(String title) {
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.title.equalsIgnoreCase(title)) {
                if (cur == head && cur == tail) head = tail = null;
                else if (cur == head) { head = head.next; head.prev = null; }
                else if (cur == tail) { tail = tail.prev; tail.next = null; }
                else { cur.prev.next = cur.next; cur.next.prev = cur.prev; }
                return;
            }
        }
    }

    static void search(String director, double rating) {
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.director.equalsIgnoreCase(director) || cur.rating == rating)
                System.out.println("Found: " + cur.title + " (" + cur.director + ", " + cur.rating + ")");
        }
    }

    static void display(boolean reverse) {
        for (Node cur = reverse ? tail : head; cur != null; cur = reverse ? cur.prev : cur.next)
            System.out.println(cur.title + " | " + cur.director + " | " + cur.year + " | " + cur.rating);
    }

    static void updateRating(String title, double newRating) {
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.title.equalsIgnoreCase(title)) { cur.rating = newRating; return; }
        }
    }

    public static void main(String[] args) {
        addFirst("Inception", "Nolan", 2010, 8.8);
        addLast("Interstellar", "Nolan", 2014, 8.7);
        addAtPos(2, "Dune", "Villeneuve", 2021, 8.0);
        updateRating("Dune", 8.2);
        search("Nolan", 8.2);
        System.out.println("--- Forward ---");
        display(false);
        System.out.println("--- Reverse ---");
        display(true);
        remove("Dune");
    }
}
