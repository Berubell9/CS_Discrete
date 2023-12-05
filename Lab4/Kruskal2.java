package Lab4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Kruskal2 {
    private static ArrayList<Graph> graph;
    private static int cnt = 0;
    private static HashMap<String, ArrayList<String>> vertex;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Plese input Number of Points : ");
        int point = sc.nextInt();
        System.out.print("Plese input Number of Lines : ");
        int line = sc.nextInt();
        graph = new ArrayList<Graph>();
        vertex = new HashMap<String, ArrayList<String>>();
        addGraph(sc, line);
        Collections.sort(graph, new ByDistance());
        addCurrentGraph();
        while(cnt < point) {
            for(int i=0;i<graph.size();i++){
                if(!graph.get(i).getConnect()){
                    isCircle(graph.get(i).getStartPoint());
                    isCircle(graph.get(i).getStopPoint());
                }
            }
        }
        printGraph();
        sc.close();
    }

    public static void addGraph(Scanner scG, int line) {
        System.out.println("Plese input elements of line");
        for(int i=0;i<line;i++){
            String start = scG.next();
            String stop = scG.next();
            int distance = scG.nextInt();
            graph.add(new Graph(start, stop, distance));
        }
    }

    public static void addCurrentGraph() {
        for(int i=0;i<graph.size();i++){
            boolean start = checkMemory(graph.get(i).getStartPoint()), stop = checkMemory(graph.get(i).getStopPoint());
            if(i==0) {
                vertex.put(graph.get(i).getStartPoint(), new ArrayList<String>());
                vertex.get(graph.get(i).getStartPoint()).add(graph.get(i).getStopPoint());
                vertex.put(graph.get(i).getStopPoint(), new ArrayList<String>());
                vertex.get(graph.get(i).getStopPoint()).add(graph.get(i).getStartPoint());
                graph.get(i).setConnect(true);
                cnt++;
            }
            else if(start && stop) {
                vertex.put(graph.get(i).getStartPoint(), new ArrayList<String>());
                vertex.get(graph.get(i).getStartPoint()).add(graph.get(i).getStopPoint());
                vertex.put(graph.get(i).getStopPoint(), new ArrayList<String>());
                vertex.get(graph.get(i).getStopPoint()).add(graph.get(i).getStartPoint());
                graph.get(i).setConnect(true);
                cnt++;
            }
            else if(start) {
                vertex.put(graph.get(i).getStartPoint(), new ArrayList<String>());
                vertex.get(graph.get(i).getStartPoint()).add(graph.get(i).getStopPoint());
                vertex.get(graph.get(i).getStopPoint()).add(graph.get(i).getStartPoint());
                graph.get(i).setConnect(true);
                cnt++;
            }
            else if(stop) {
                vertex.get(graph.get(i).getStartPoint()).add(graph.get(i).getStopPoint());
                vertex.put(graph.get(i).getStopPoint(), new ArrayList<String>());
                vertex.get(graph.get(i).getStopPoint()).add(graph.get(i).getStartPoint());
                graph.get(i).setConnect(true);
                cnt++;
            }
        }
    }

    public static boolean checkMemory(String point) {
        if(vertex.containsKey(point)){
            return !true;
        }
        return !false;
    }
    
    //error
    public static boolean isCircle(String vStart) {
        return true;
    }

    public static void printGraph() {
        for(int i=0;i<graph.size();i++){
            if(graph.get(i).getConnect()){
                System.out.printf("|  %2d  | %11s - %10s |  %3d  |     Added |\n", i+1, graph.get(i).getStartPoint(), graph.get(i).getStopPoint(), graph.get(i).getDistance());
            }
            else {
                System.out.printf("|  %2d  | %11s - %10s |  %3d  | Not Added |\n", i+1, graph.get(i).getStartPoint(), graph.get(i).getStopPoint(), graph.get(i).getDistance());
            }
        }
    }
}
/*
8 11
Minneapolis Chicago 355
Louisville Cincinnati 83
Chicago Milwaukee 74
St.Louis Louisville 242
Louisville Milwaukee 348
Louisville Nashville 151
Chicago Louisville 269
Minneapolis Nashville 695
Louisville Detroit 306
St.Louis Chicago 262
Cincinnati Detroit 230
*/