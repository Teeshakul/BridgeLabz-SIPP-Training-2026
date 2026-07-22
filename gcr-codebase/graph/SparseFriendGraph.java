import java.util.*;

public class SparseFriendGraph {

    static Map<Integer, Set<Integer>> graph = new HashMap<>();

    static void addFriendship(int u, int v) {

        graph.computeIfAbsent(u, k -> new HashSet<>()).add(v);
        graph.computeIfAbsent(v, k -> new HashSet<>()).add(u);
    }

    static boolean isFriend(int u, int v) {

        return graph.getOrDefault(u, Collections.emptySet()).contains(v);
    }

    static void display() {

        for (int user : graph.keySet())
            System.out.println(user + " -> " + graph.get(user));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of friendships: ");
        int n = sc.nextInt();

        System.out.println("Enter friendship pairs:");

        for (int i = 0; i < n; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();

            addFriendship(u, v);
        }

        System.out.println("\nFriend Graph:");

        display();

        System.out.print("\nEnter two users to check friendship: ");

        int u = sc.nextInt();
        int v = sc.nextInt();

        if (isFriend(u, v))
            System.out.println("They are friends.");
        else
            System.out.println("They are not friends.");
    }
}