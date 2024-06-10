import java.util.ArrayList;

public class Vertex {
    private int data;
    private ArrayList<Edge> edges;
    private boolean isVisited;

    public Vertex(int inputData) {
        this.data = inputData;
        this.edges = new ArrayList<Edge>();
        isVisited = false;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public int getData() {
        return data;
    }

    public void addEdge(Vertex endVertex, Integer weight) {
        this.edges.add(new Edge(this, endVertex, weight));
    }

    public void removeEdge(Vertex endVertex) {
        this.edges.removeIf(edge -> edge.getEnd().equals(endVertex));
    }

    public ArrayList<Edge> getEdges(){
        return this.edges;
    }
}