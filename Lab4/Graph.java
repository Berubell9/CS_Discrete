package Lab4;
public class Graph {
    private String startP, stopP;
    private int distance;
    private boolean connect = false;

    public Graph(String startP, String stopP, int distance){
        this.startP = startP;
        this.stopP = stopP;
        this.distance = distance;
    }

    public void setConnect(boolean connect) {
        this.connect = connect;
    }

    public String getStartPoint() {
        return this.startP;
    }
    public String getStopPoint() {
        return this.stopP;
    }
    public int getDistance() {
        return this.distance;
    }
    public boolean getConnect() {
        return this.connect;
    }

    @Override
    public String toString() {
        return String.format("| %11s - %10s | %3d |", this.startP, this.stopP, this.distance);
    }
}
