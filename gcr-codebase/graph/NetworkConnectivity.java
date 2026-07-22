import java.util.*;

public class NetworkConnectivity {

    static void addEdge(Map<Integer, List<Integer>> graph, int u, int v) {

        graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    static void dfs(Map<Integer, List<Integer>> graph,
                    int node,
                    Set<Integer> visited) {

        visited.add(node);

        for (int next : graph.getOrDefault(node, new ArrayList<>())) {

            if (!visited.contains(next))
                dfs(graph, next, visited);
        }
    }

    static int countComponents(Map<Integer, List<Integer>> graph, int vertices) {

        Set<Integer> visited = new HashSet<>();

        int components = 0;

        for (int i = 0; i < vertices; i++) {

            if (!visited.contains(i)) {

                components++;

                dfs(graph, i, visited);
            }
        }

        return components;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<Integer, List<Integer>> graph = new HashMap<>();

        System.out.print("Enter number of servers: ");
        int vertices = sc.nextInt();

        System.out.print("Enter number of connections: ");
        int edges = sc.nextInt();

        System.out.println("Enter connections:");

        for (int i = 0; i < edges; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();

            addEdge(graph, u, v);
        }

        int components = countComponents(graph, vertices);

        System.out.println("Connected Components = " + components);

        if (components == 1)
            System.out.println("Network is Fully Connected");
        else
            System.out.println("Network is NOT Fully Connected");
    }
}