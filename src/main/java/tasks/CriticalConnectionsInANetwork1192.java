package tasks;

import java.util.*;

public class CriticalConnectionsInANetwork1192 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.criticalConnections(
                4,
                Arrays.asList(
                        Arrays.asList(0, 1),
                        Arrays.asList(1, 2),
                        Arrays.asList(2, 0),
                        Arrays.asList(1, 3)
                )
        ));

    }
}

class Solution {
    List<List<Integer>> bridges;
    ArrayList<Integer>[] graph;
    int[] ids, low;
    int id;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        bridges = new ArrayList<>();
        graph = new ArrayList[n];
        ids = new int[n];
        low = new int[n];
        id = 0;

        buildGraph(connections);

        boolean[] visited = new boolean[n];
        dfs(visited, -1, 0);

        return bridges;
    }

    private void dfs(boolean[] visited, int parent, int i) {
        visited[i] = true;
        ids[i] = low[i] = id++;

        for (int node : graph[i]) {
            if (node == parent) continue;
            if (!visited[node]) {
                dfs(visited, i, node);

                low[i] = Math.min(low[i], low[node]);
                if (ids[i] < low[node])
                    bridges.add(Arrays.asList(i, node));
            } else {
                low[i] = Math.min(low[i], ids[node]);
            }
        }
    }

    private void buildGraph(List<List<Integer>> connections) {
        for (int i = 0; i < graph.length; i++)
            graph[i] = new ArrayList<>();
        for (List<Integer> connection : connections) {
            int a = connection.get(0), b = connection.get(1);
            graph[a].add(b);
            graph[b].add(a);
        }
    }
}
