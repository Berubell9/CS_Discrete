package Lab4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    public Kruskal(){
    }
    public List<Edge> kruskal(int n, List<Edge> edges) {
        List<Edge> result = new ArrayList<>();
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Collections.sort(edges);
        for (Edge edge : edges) {
            int sourceParent = find(parent, edge.sourceVertex);
            int destParent = find(parent, edge.destinationVertex);
            if (sourceParent != destParent) {
                result.add(edge);
                parent[sourceParent] = destParent;
            }
        }
        return result;
    }
    public int find(int[] parent, int node) {
        if (parent[node] == node) {
            return node;
        }
        return find(parent, parent[node]);
    }
}
