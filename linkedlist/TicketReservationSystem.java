public class TicketReservationSystem {
    static class Node {
        int ticketId;
        String customerName, movieName, seatNumber, bookingTime;
        Node next;

        Node(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
            this.ticketId = ticketId;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = bookingTime;
        }
    }

    static Node head = null, tail = null;

    static void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Node n = new Node(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = tail = n;
            n.next = head;
        } else {
            tail.next = n;
            tail = n;
            tail.next = head;
        }
    }

    static void removeTicket(int ticketId) {
        if (head == null) return;
        Node cur = head, prev = tail;
        do {
            if (cur.ticketId == ticketId) {
                if (head == tail) {
                    head = tail = null;
                } else {
                    if (cur == head) head = head.next;
                    if (cur == tail) tail = prev;
                    prev.next = cur.next;
                    tail.next = head;
                }
                return;
            }
            prev = cur;
            cur = cur.next;
        } while (cur != head);
    }

    static void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Node cur = head;
        do {
            System.out.println(cur.ticketId + " | " + cur.customerName + " | " + cur.movieName + " | Seat: " + cur.seatNumber + " | Time: " + cur.bookingTime);
            cur = cur.next;
        } while (cur != head);
    }

    static void searchTicket(String query) {
        if (head == null) return;
        Node cur = head;
        do {
            if (cur.customerName.equalsIgnoreCase(query) || cur.movieName.equalsIgnoreCase(query)) {
                System.out.println("Found: ID=" + cur.ticketId + " | " + cur.customerName + " | " + cur.movieName + " | Seat: " + cur.seatNumber);
            }
            cur = cur.next;
        } while (cur != head);
    }

    static int countTickets() {
        if (head == null) return 0;
        int count = 0;
        Node cur = head;
        do {
            count++;
            cur = cur.next;
        } while (cur != head);
        return count;
    }

    public static void main(String[] args) {
        addTicket(501, "Aarav", "Inception", "A12", "18:30");
        addTicket(502, "Priya", "Interstellar", "B04", "21:00");
        addTicket(503, "Rohan", "Inception", "A13", "18:30");

        System.out.println("--- Current Tickets ---");
        displayTickets();

        System.out.println("--- Search 'Inception' ---");
        searchTicket("Inception");

        System.out.println("Total Booked Tickets: " + countTickets());

        removeTicket(502);
        System.out.println("--- After Removing Ticket 502 ---");
        displayTickets();
        System.out.println("Total Booked Tickets: " + countTickets());
    }
}
