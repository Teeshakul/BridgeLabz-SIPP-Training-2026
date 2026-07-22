import java.util.*;

public class DirectedCycleDetection {

    static void addEdge(Map<Integer, List<Integer>> graph, int u, int v) {

        graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
    }

    static boolean dfs(Map<Integer, List<Integer>> graph,
                       int node,
                       int[] state) {

        state[node] = 1;

        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {

            if (state[neighbor] == 1)
                return true;

            if (state[neighbor] == 0 &&
                    dfs(graph, neighbor, state))
                return true;
        }

        state[node] = 2;

        return false;
    }

    static boolean hasCycle(Map<Integer, List<Integer>> graph, int vertices) {

        int[] state = new int[vertices];

        for (int i = 0; i < vertices; i++) {

            if (state[i] == 0) {

                if (dfs(graph, i, state))
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<Integer, List<Integer>> graph = new HashMap<>();

        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();

        System.out.println("Enter directed edges:");

        for (int i = 0; i < edges; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();

            addEdge(graph, u, v);
        }

        if (hasCycle(graph, vertices))
            System.out.println("Directed Cycle Detected");
        else
            System.out.println("No Directed Cycle");
    }
}