package Lab4;
import java.util.ArrayList;
import java.util.List;
public class lab4 {
    public static void main(String[] args) {
        int n = 5; // number of nodes
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 3, 6));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 8));
        edges.add(new Edge(1, 4, 5));
        edges.add(new Edge(2, 4, 7));
        edges.add(new Edge(3, 4, 9));
        Kruskal k = new Kruskal();
        List<Edge> minimumSpanningTree = k.kruskal(n, edges);
        System.out.println("Edges of the minimum spanning tree using Kruskal algorithm :");
        System.out.println("Source vertex    Destination vertex    Weight");
        for (Edge edge : minimumSpanningTree) {
            System.out.println("\t"+edge.sourceVertex+" \t\t "+edge.destinationVertex+" \t\t "+edge.weight);
        }
        System.out.println("===============================================");
        int sum = 0;
        for (Edge edge : minimumSpanningTree) {
            sum += edge.weight;
        }
        System.out.println("Sum of minimum spanning tree: " + sum);
    }
}
class Edge implements Comparable<Edge> {
    int sourceVertex; // starting vertex
    int destinationVertex; // ending vertex 
    int weight; 
    public Edge(int source, int destination, int weight) {
        this.sourceVertex = source;
        this.destinationVertex = destination;
        this.weight = weight;
    }
    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}

