import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> graph = createGraph(edges);
        Map<Integer, Boolean> visited = new HashMap<>();
        return minTimeHelper(graph, 0, hasApple, 0, visited);
    }

    public int minTimeHelper(Map<Integer, List<Integer>> graph, int node, List<Boolean> hasApple,
                             int sum, Map<Integer, Boolean> visited) {
        if (visited.getOrDefault(node, false)) {
            return 0;
        }
        visited.put(node, true);

        int childrenCost = 0;
        for (int n : graph.getOrDefault(node, new ArrayList<>())) {
            childrenCost += minTimeHelper(graph, n, hasApple, 2, visited);
        }
        if (childrenCost == 0 && !hasApple.get(node)) {
            return 0;
        }
        return childrenCost + sum;
    }

    public Map<Integer, List<Integer>> createGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < edges.length; i++) {
            List<Integer> list = graph.getOrDefault(edges[i][0], new ArrayList<>());
            list.add(edges[i][1]);
            graph.put(edges[i][0], list);
            list = graph.getOrDefault(edges[i][1], new ArrayList<>());
            list.add(edges[i][0]);
            graph.put(edges[i][1], list);
        }
        return graph;
    }
}

