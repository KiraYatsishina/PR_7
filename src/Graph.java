import java.util.*;

public class Graph {
    private ArrayList<Vertex> vertices;

    private static final int INFINITY = Integer.MAX_VALUE;

    public Graph(int [][] matrix) {
        this.vertices = new ArrayList<Vertex>();
        for (int i = 0; i < matrix.length; i++) {
            this.vertices.add(new Vertex(i+1));
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    this.vertices.get(i).addEdge(this.vertices.get(j), matrix[i][j]);
                }
            }
        }
    }

    public Graph(List<String> adjacencyList) {
        this.vertices = new ArrayList<>();
        for (int i = 0; i < adjacencyList.size(); i++) {
            this.vertices.add(new Vertex(i + 1));
        }

        for (int i = 0; i < adjacencyList.size(); i++) {
            String[] edges = adjacencyList.get(i).split("->");
            if (edges.length > 1) {
                String[] neighbors = edges[1].trim().split(" ");
                for (String neighbor : neighbors) {
                    String[] parts = neighbor.split(",");
                    int neighborIndex = Integer.parseInt(parts[0].trim()) - 1; // Adjust for 1-based index
                    int weight = Integer.parseInt(parts[1].trim());
                    this.vertices.get(i).addEdge(this.vertices.get(neighborIndex), weight);
                }
            }
        }
    }

    public String getAdjacenciesList() {
        StringBuilder result = new StringBuilder();
        for (Vertex vertex : vertices) {
            result.append(vertex.getData()).append(" -> ");
            for (Edge edge : vertex.getEdges()) {
                result.append(edge.getEnd().getData()).append(",").append(edge.getWeight()).append("  ");
            }
            result.append("\n");
        }
        return result.toString();
    }

    public String getAdjacenciesMatrix() {
        int size = vertices.size();
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (Edge edge : vertices.get(i).getEdges()) {
                int j = edge.getEnd().getData() - 1; // -1, так как в списке смежности вершины нумеруются с 1
                matrix[i][j] = edge.getWeight();
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result.append(matrix[i][j]).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }

    public String BFS() {
        if (vertices.isEmpty()) return "Empty";

        StringBuilder result = new StringBuilder();
        Queue<Vertex> queue = new LinkedList<>();
        vertices.get(0).setVisited(true);
        queue.add(vertices.get(0));

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            result.append(current.getData()).append(" ");

            for (Edge edge : current.getEdges()) {
                Vertex neighbor = edge.getEnd();
                if (!neighbor.isVisited()) {
                    neighbor.setVisited(true);
                    queue.add(neighbor);
                }
            }
        }

        for (Vertex vertex : vertices) {
            vertex.setVisited(false);
        }

        return result.toString();
    }

    public String DFS() {
        if (vertices.isEmpty()) return "Empty";

        StringBuilder result = new StringBuilder();
        Stack<Vertex> stack = new Stack<>();
        vertices.get(0).setVisited(true);
        stack.push(vertices.get(0));

        while (!stack.isEmpty()) {
            Vertex current = stack.pop();
            result.append(current.getData()).append(" ");

            for (Edge edge : current.getEdges()) {
                Vertex neighbor = edge.getEnd();
                if (!neighbor.isVisited()) {
                    neighbor.setVisited(true);
                    stack.push(neighbor);
                }
            }
        }

        for (Vertex vertex : vertices) {
            vertex.setVisited(false);
        }

        return result.toString();
    }
    public Vertex addVertex(int data) {
        Vertex newVertex = new Vertex(data);
        this.vertices.add(newVertex);
        return newVertex;
    }

    public boolean graphExistVertex(int data) {
        for (Vertex vertex : vertices) {
            if (vertex.getData() == data) {
                return true;
            }
        }
        return false;
    }

    public void addEdge(Vertex vertex1, Vertex vertex2, Integer weight) {
        vertex1.addEdge(vertex2, weight);
    }

    public ArrayList<Vertex> getVertices() {
        return this.vertices;
    }
}