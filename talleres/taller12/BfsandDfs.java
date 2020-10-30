import java.util.LinkedList;
import java.util.Queue;

public class BfsandDfs {
    public static boolean bfs(Digraph graph, int first, int target, boolean[] visited, LinkedList<Integer> check)
            throws Exception {
        if (first != target) {
            visited[first] = true;
            Queue<Integer> childNodes = graph.getSuccessors(first);
            while (!childNodes.isEmpty()) {
                int node = childNodes.poll();
                if (!visited[node]) {
                    bfs(graph, node, target, visited, check);
                }
            }
        } else {
            check.addLast(1);
        }
        return !check.isEmpty();
    }

    public static boolean dfs(Digraph graph, int first, int target, LinkedList<Integer> visited) throws Exception {
        visited.addLast(first);
        if (visited.size() >= graph.size())
            return false;
        if (first == target)
            return true;
        Queue<Integer> childNodes = graph.getSuccessors(first);
        while (!childNodes.isEmpty()) {
            if (dfs(graph, childNodes.poll(), target, visited))
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        DigraphAM graphAM = new DigraphAM(8);
        graphAM.addArc(0, 4, 1);
        graphAM.addArc(1, 3, 1);
        graphAM.addArc(1, 5, 1);
        graphAM.addArc(2, 1, 1);
        graphAM.addArc(2, 4, 1);
        graphAM.addArc(4, 7, 1);
        graphAM.addArc(5, 6, 1);
        graphAM.addArc(6, 7, 1);
        graphAM.addArc(7, 6, 1);
        graphAM.printCodeForGraphViz();
        boolean[] visited = new boolean[graphAM.size()];
        LinkedList<Integer> checkBfs = new LinkedList<>(), visitedDfs = new LinkedList<>();
        System.out.println(bfs(graphAM, 2, 7, visited, checkBfs));
        System.out.println(dfs(graphAM, 2, 7, visitedDfs));

    }
}