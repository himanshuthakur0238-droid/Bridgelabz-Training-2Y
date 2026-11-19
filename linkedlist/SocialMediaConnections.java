import java.util.ArrayList;
import java.util.List;

public class SocialMediaConnections {
    static class Node {
        int id, age;
        String name;
        List<Integer> friends = new ArrayList<>();
        Node next;

        Node(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }
    }

    static Node head = null;

    static void addUser(int id, String name, int age) {
        Node n = new Node(id, name, age);
        n.next = head;
        head = n;
    }

    static Node getUser(int id) {
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.id == id) return cur;
        }
        return null;
    }

    static void addFriend(int id1, int id2) {
        Node u1 = getUser(id1), u2 = getUser(id2);
        if (u1 != null && u2 != null && id1 != id2) {
            if (!u1.friends.contains(id2)) u1.friends.add(id2);
            if (!u2.friends.contains(id1)) u2.friends.add(id1);
        }
    }

    static void removeFriend(int id1, int id2) {
        Node u1 = getUser(id1), u2 = getUser(id2);
        if (u1 != null && u2 != null) {
            u1.friends.remove(Integer.valueOf(id2));
            u2.friends.remove(Integer.valueOf(id1));
        }
    }

    static void findMutualFriends(int id1, int id2) {
        Node u1 = getUser(id1), u2 = getUser(id2);
        if (u1 == null || u2 == null) return;
        System.out.print("Mutual friends (" + u1.name + " & " + u2.name + "): ");
        for (int fId : u1.friends) {
            if (u2.friends.contains(fId)) {
                Node f = getUser(fId);
                System.out.print((f != null ? f.name : fId) + " ");
            }
        }
        System.out.println();
    }

    static void displayFriends(int id) {
        Node u = getUser(id);
        if (u == null) return;
        System.out.print(u.name + "'s friends: ");
        for (int fId : u.friends) {
            Node f = getUser(fId);
            System.out.print((f != null ? f.name : fId) + " ");
        }
        System.out.println();
    }

    static void searchUser(String query) {
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.name.equalsIgnoreCase(query) || String.valueOf(cur.id).equals(query)) {
                System.out.println("Found: ID=" + cur.id + ", Name=" + cur.name + ", Age=" + cur.age);
            }
        }
    }

    static void countFriendsForAll() {
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.println(cur.name + " (ID: " + cur.id + ") -> " + cur.friends.size() + " friends");
        }
    }

    public static void main(String[] args) {
        addUser(1, "Alice", 22);
        addUser(2, "Bob", 24);
        addUser(3, "Charlie", 23);
        addUser(4, "Diana", 21);

        addFriend(1, 2);
        addFriend(1, 3);
        addFriend(2, 3);
        addFriend(2, 4);

        displayFriends(1);
        findMutualFriends(1, 2);
        searchUser("Charlie");
        countFriendsForAll();

        removeFriend(1, 2);
        System.out.println("--- After Removing Connection (1 & 2) ---");
        displayFriends(1);
    }
}
