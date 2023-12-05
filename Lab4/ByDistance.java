package Lab4;
import java.util.Comparator;

public class ByDistance implements Comparator<Graph>{
    public int compare(Graph a, Graph b){
        return a.getDistance() - b.getDistance();
    }
}
