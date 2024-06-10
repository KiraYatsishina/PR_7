import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
    private static final int INFINITY = Integer.MAX_VALUE;

    public static Result dijkstra(Graph graph, int source) {
        int size = graph.getVertices().size();
        int[] dist = new int[size];
        Vertex[] prev = new Vertex[size];
        PriorityQueue<VertexDistancePair> queue = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.distance));

        for (int i = 0; i < size; i++) {
            dist[i] = INFINITY;
            prev[i] = null;
        }

        dist[source - 1] = 0;
        queue.offer(new VertexDistancePair(source - 1, 0));

        while (!queue.isEmpty()) {
            VertexDistancePair currentPair = queue.poll();
            int u = currentPair.vertex;

            Vertex currentVertex = graph.getVertices().get(u);

            for (Edge edge : currentVertex.getEdges()) {
                Vertex neighbor = edge.getEnd();
                int v = neighbor.getData() - 1;
                int weight = edge.getWeight();
                int tempDist = dist[u] + weight;

                if (tempDist < dist[v]) {
                    dist[v] = tempDist;
                    prev[v] = currentVertex;
                    queue.offer(new VertexDistancePair(v, tempDist));
                }
            }
        }

        return new Result(dist, prev);
    }

    public static void printResult(Result result, Graph graph) {
        for (int i = 0; i < result.dist.length; i++) {
            if (result.dist[i] != INFINITY) {
                System.out.print("до вершини " + (i + 1) + ": ");
                printPath(result.prev, i);
                System.out.println(" -> " + result.dist[i]);
            } else {
                System.out.println("до вершини " + (i + 1) + ": No path");
            }
        }
    }

    private static void printPath(Vertex[] prev, int vertexIndex) {
        if (prev[vertexIndex] != null) {
            printPath(prev, prev[vertexIndex].getData() - 1);
            System.out.print("-" + (vertexIndex + 1));
        } else {
            System.out.print((vertexIndex + 1));
        }
    }
    public static class Result {
        public int[] dist;
        public Vertex[] prev;

        public Result(int[] dist, Vertex[] prev) {
            this.dist = dist;
            this.prev = prev;
        }
    }

    private static class VertexDistancePair {
        public int vertex;
        public int distance;

        public VertexDistancePair(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
}