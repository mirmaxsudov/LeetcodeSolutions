package tasks;

import java.util.*;

class Graph {
    private final Map<Integer, List<Integer>> adjacencyList;
    private final boolean isDirected;

    public Graph(boolean isDirected) {
        this.adjacencyList = new HashMap<>();
        this.isDirected = isDirected;
    }

    public void addEdge(int source, int destination) {
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.putIfAbsent(destination, new ArrayList<>());

        adjacencyList.get(source).add(destination);

        if (!isDirected)
            adjacencyList.get(destination).add(source);
    }

    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        System.out.println("DFS Traversal:");
        dfsHelper(start, visited);
    }

    private void dfsHelper(int node, Set<Integer> visited) {
        if (visited.contains(node)) return;

        visited.add(node);
        System.out.print(node + " ");

        for (int neighbor : adjacencyList.getOrDefault(node, Collections.emptyList())) {
            dfsHelper(neighbor, visited);
        }
    }

    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start);

        System.out.println("\nBFS Traversal:");
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : adjacencyList.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    public void findShortestPath(int start, int end) {
        Map<Integer, Integer> predecessors = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == end) {
                printPath(predecessors, start, end);
                return;
            }

            for (int neighbor : adjacencyList.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                    predecessors.put(neighbor, current);
                }
            }
        }

        System.out.println("No path exists between " + start + " and " + end);
    }

    private void printPath(Map<Integer, Integer> predecessors, int start, int end) {
        List<Integer> path = new ArrayList<>();

        for (Integer at = end; at != null; at = predecessors.get(at))
            path.add(at);

        Collections.reverse(path);

        System.out.println("\nShortest path from " + start + " to " + end + ": " + path);
    }

    public void printGraph() {
        System.out.println("\nGraph adjacency list:");
        for (int node : adjacencyList.keySet()) {
            System.out.println(node + " -> " + adjacencyList.get(node));
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(false);

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);

        graph.printGraph();

        graph.dfs(1);
        graph.bfs(1);

        graph.findShortestPath(1, 6);
    }
}