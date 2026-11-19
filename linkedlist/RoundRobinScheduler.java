public class RoundRobinScheduler {
    static class Node {
        int pid, burstTime, remainingTime, priority;
        Node next;

        Node(int pid, int burstTime, int priority) {
            this.pid = pid;
            this.burstTime = burstTime;
            this.remainingTime = burstTime;
            this.priority = priority;
        }
    }

    static Node head = null, tail = null;

    static void addProcess(int pid, int burstTime, int priority) {
        Node n = new Node(pid, burstTime, priority);
        if (head == null) {
            head = tail = n;
            n.next = head;
        } else {
            tail.next = n;
            tail = n;
            tail.next = head;
        }
    }

    static void removeProcess(int pid) {
        if (head == null) return;
        Node cur = head, prev = tail;
        do {
            if (cur.pid == pid) {
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

    static int countProcesses() {
        if (head == null) return 0;
        int count = 0;
        Node cur = head;
        do {
            count++;
            cur = cur.next;
        } while (cur != head);
        return count;
    }

    static void displayQueue() {
        if (head == null) {
            System.out.println("Queue is empty.");
            return;
        }
        Node cur = head;
        do {
            System.out.print("[P" + cur.pid + " | Rem: " + cur.remainingTime + " | Prio: " + cur.priority + "] -> ");
            cur = cur.next;
        } while (cur != head);
        System.out.println("(head)");
    }

    static void simulate(int quantum) {
        int totalProcesses = countProcesses();
        if (totalProcesses == 0) return;

        int currentTime = 0, round = 1;
        double totalWT = 0, totalTAT = 0;

        while (head != null) {
            int activeCount = countProcesses();
            Node cur = head;

            for (int i = 0; i < activeCount; i++) {
                Node nextNode = cur.next;
                int execTime = Math.min(cur.remainingTime, quantum);
                cur.remainingTime -= execTime;
                currentTime += execTime;

                if (cur.remainingTime == 0) {
                    int tat = currentTime;
                    int wt = tat - cur.burstTime;
                    totalTAT += tat;
                    totalWT += wt;
                    System.out.println("P" + cur.pid + " finished at t=" + currentTime + " (WT: " + wt + ", TAT: " + tat + ")");
                    removeProcess(cur.pid);
                }
                cur = nextNode;
            }

            System.out.print("After Round " + round++ + ": ");
            displayQueue();
        }

        System.out.printf("Average Waiting Time: %.2f\n", totalWT / totalProcesses);
        System.out.printf("Average Turn-Around Time: %.2f\n", totalTAT / totalProcesses);
    }

    public static void main(String[] args) {
        addProcess(1, 10, 2);
        addProcess(2, 4, 1);
        addProcess(3, 6, 3);

        System.out.print("Initial Queue: ");
        displayQueue();
        simulate(4);
    }
}
