import java.util.*;

public class BFSShortestFlights {

    static List<Integer> shortestPath(Map<Integer, List<Integer>> graph,
                                      int source,
                                      int destination) {

        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> parent = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(source);
        visited.add(source);
        parent.put(source, null);

        while (!queue.isEmpty()) {

            int current = queue.poll();

            if (current == destination)
                break;

            for (int next : graph.getOrDefault(current, new ArrayList<>())) {

                if (!visited.contains(next)) {

                    visited.add(next);
                    parent.put(next, current);
                    queue.offer(next);
                }
            }
        }

        if (!visited.contains(destination))
            return new ArrayList<>();

        LinkedList<Integer> path = new LinkedList<>();

        Integer node = destination;

        while (node != null) {

            path.addFirst(node);
            node = parent.get(node);
        }

        return path;
    }

    static void addEdge(Map<Integer, List<Integer>> graph, int u, int v) {

        graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<Integer, List<Integer>> graph = new HashMap<>();

        System.out.print("Enter number of routes: ");
        int edges = sc.nextInt();

        System.out.println("Enter route pairs:");

        for (int i = 0; i < edges; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();

            addEdge(graph, u, v);
        }

        System.out.print("Enter source city: ");
        int source = sc.nextInt();

        System.out.print("Enter destination city: ");
        int destination = sc.nextInt();

        List<Integer> path = shortestPath(graph, source, destination);

        if (path.isEmpty())
            System.out.println("No Route Found");
        else
            System.out.println("Shortest Path: " + path);
    }
}