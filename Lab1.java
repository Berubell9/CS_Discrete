import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class GraphDegree {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Map<String, List<String>> graph = new HashMap<>();
        String[] stdin;
        System.out.println("--Graph Degree counter--\nenter q to quit");
        do {
            stdin = sc.nextLine().split(" ");
            if (stdin[0].equals("q")) {
                break;
            }
            for (int i = 0; i < 2; i++) {
                if (!graph.containsKey(stdin[i])) {
                    graph.put(stdin[i], new ArrayList<String>());
                }
                if (!graph.get(stdin[i]).contains(stdin[1 - i])){
                    graph.get(stdin[i]).add(stdin[1 - i]);
                }
            }
            System.out.println(graph);
        } while (true);
        System.out.println("-----------------------------------");
        System.out.println("Graph: " + graph);
        for (Map.Entry<String, List<String>> entry : graph.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            System.out.println("Node " + key + " has degree " + value.size());
        }
        sc.close();
    }
}