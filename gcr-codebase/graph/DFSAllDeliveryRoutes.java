import java.util.*;

public class DFSAllDeliveryRoutes {

    static void addEdge(Map<Integer, List<Integer>> graph, int u, int v) {

        graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    static void findAllRoutes(Map<Integer, List<Integer>> graph,
                              int current,
                              int destination,
                              List<Integer> path,
                              Set<Integer> visited,
                              List<List<Integer>> allRoutes) {

        path.add(current);
        visited.add(current);

        if (current == destination) {

            allRoutes.add(new ArrayList<>(path));

        } else {

            for (int next : graph.getOrDefault(current, new ArrayList<>())) {

                if (!visited.contains(next)) {

                    findAllRoutes(graph, next, destination,
                            path, visited, allRoutes);
                }
            }
        }

        path.remove(path.size() - 1);
        visited.remove(current);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<Integer, List<Integer>> graph = new HashMap<>();

        System.out.print("Enter number of roads: ");
        int edges = sc.nextInt();

        System.out.println("Enter road connections:");

        for (int i = 0; i < edges; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();

            addEdge(graph, u, v);
        }

        System.out.print("Enter source: ");
        int source = sc.nextInt();

        System.out.print("Enter destination: ");
        int destination = sc.nextInt();

        List<List<Integer>> routes = new ArrayList<>();

        findAllRoutes(graph,
                source,
                destination,
                new ArrayList<>(),
                new HashSet<>(),
                routes);

        if (routes.isEmpty())
            System.out.println("No Route Found");
        else {

            System.out.println("All Possible Routes:");

            for (List<Integer> route : routes)
                System.out.println(route);
        }
    }
}