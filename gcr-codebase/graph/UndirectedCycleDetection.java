import java.util.*;

public class UndirectedCycleDetection {

    static void addEdge(Map<Integer, List<Integer>> graph, int u, int v) {

        graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    static boolean dfs(Map<Integer, List<Integer>> graph,
                       int node,
                       int parent,
                       Set<Integer> visited) {

        visited.add(node);

        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {

            if (!visited.contains(neighbor)) {

                if (dfs(graph, neighbor, node, visited))
                    return true;

            } else if (neighbor != parent) {

                return true;
            }
        }

        return false;
    }

    static boolean hasCycle(Map<Integer, List<Integer>> graph, int vertices) {

        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < vertices; i++) {

            if (!visited.contains(i)) {

                if (dfs(graph, i, -1, visited))
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

        System.out.println("Enter edges:");

        for (int i = 0; i < edges; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();

            addEdge(graph, u, v);
        }

        if (hasCycle(graph, vertices))
            System.out.println("Cycle Detected");
        else
            System.out.println("No Cycle Found");
    }
}