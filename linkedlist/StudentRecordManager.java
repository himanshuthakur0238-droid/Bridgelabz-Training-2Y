import java.util.Scanner;

public class StudentRecordManager {
    static class Node {
        int roll, age;
        String name, grade;
        Node next;

        Node(int roll, String name, int age, String grade) {
            this.roll = roll;
            this.name = name;
            this.age = age;
            this.grade = grade;
        }
    }

    static Node head = null;

    static void addFirst(int roll, String name, int age, String grade) {
        Node n = new Node(roll, name, age, grade);
        n.next = head;
        head = n;
    }

    static void addLast(int roll, String name, int age, String grade) {
        Node n = new Node(roll, name, age, grade);
        if (head == null) {
            head = n;
            return;
        }
        Node t = head;
        while (t.next != null) t = t.next;
        t.next = n;
    }

    static void addAtPos(int pos, int roll, String name, int age, String grade) {
        if (pos <= 1) {
            addFirst(roll, name, age, grade);
            return;
        }
        Node n = new Node(roll, name, age, grade), t = head;
        for (int i = 1; i < pos - 1 && t != null; i++) t = t.next;
        if (t == null) {
            System.out.println("Invalid position");
            return;
        }
        n.next = t.next;
        t.next = n;
    }

    static void delete(int roll) {
        if (head == null) return;
        if (head.roll == roll) {
            head = head.next;
            return;
        }
        Node t = head;
        while (t.next != null && t.next.roll != roll) t = t.next;
        if (t.next != null) t.next = t.next.next;
        else System.out.println("Not found");
    }

    static void search(int roll) {
        for (Node t = head; t != null; t = t.next) {
            if (t.roll == roll) {
                System.out.println(t.roll + " | " + t.name + " | " + t.age + " | " + t.grade);
                return;
            }
        }
        System.out.println("Not found");
    }

    static void display() {
        if (head == null) System.out.println("Empty list");
        for (Node t = head; t != null; t = t.next) {
            System.out.println(t.roll + " | " + t.name + " | " + t.age + " | " + t.grade);
        }
    }

    static void updateGrade(int roll, String grade) {
        for (Node t = head; t != null; t = t.next) {
            if (t.roll == roll) {
                t.grade = grade;
                return;
            }
        }
        System.out.println("Not found");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1.AddFirst 2.AddLast 3.AddPos 4.Delete 5.Search 6.Display 7.Update 8.Exit");
            int ch = sc.nextInt();
            if (ch == 8) break;

            if (ch >= 1 && ch <= 3) {
                int pos = (ch == 3) ? sc.nextInt() : 0;
                int r = sc.nextInt();
                String n = sc.next();
                int a = sc.nextInt();
                String g = sc.next();
                if (ch == 1) addFirst(r, n, a, g);
                else if (ch == 2) addLast(r, n, a, g);
                else addAtPos(pos, r, n, a, g);
            } else if (ch == 4) {
                delete(sc.nextInt());
            } else if (ch == 5) {
                search(sc.nextInt());
            } else if (ch == 6) {
                display();
            } else if (ch == 7) {
                updateGrade(sc.nextInt(), sc.next());
            }
        }
        sc.close();
    }
}
