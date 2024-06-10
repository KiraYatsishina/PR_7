import java.util.Scanner;
// 3. Програма, яка для заданого графа завдання 2, створює список суміжності по матриці суміжності.
// 5. Програма обходу графа в ширину та глибину, а також пошуку найкоротшого шляху між вершинами.
public class task3 {
    // 7 лр
    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
                {0, 2, 0, 8, 6, 0, 0, 3},
                {2, 0, 2, 6, 0, 7, 0, 3},
                {0, 2, 0, 9, 6, 4, 1, 0},
                {8, 6, 9, 0, 0, 0, 5, 3},
                {6, 0, 6, 0, 0, 7, 1, 4},
                {0, 7, 4, 0, 7, 0, 3, 0},
                {0, 0, 1, 5, 1, 3, 0, 6},
                {3, 3, 0, 3, 4, 0, 6, 0}
        };
        Graph graph = new Graph(adjacencyMatrix);
        System.out.println("\nМатриця суміжності з створеного графа:");
        System.out.println(graph.getAdjacenciesMatrix());


        System.out.println("\nСписок суміжностей:");
        System.out.println(graph.getAdjacenciesList());



        System.out.println("BFS:");
        System.out.println(graph.BFS());

        System.out.println("\nDFS:");
        System.out.println(graph.DFS());

        System.out.println("\nПошук найкоротшого шляху. Алгоритм Дейкстри");

        Scanner scanner = new Scanner(System.in);
        int vertexStart = 0;
        do {
            System.out.print("Введіть першу вершину: ");
            vertexStart = scanner.nextInt();
            if(!graph.graphExistVertex(vertexStart)) System.out.println("У графа немає такої вершини.");
        }while (!graph.graphExistVertex(vertexStart));

        System.out.println("Найкоротші шляхи: ");
        DijkstraAlgorithm.Result shortestPaths = DijkstraAlgorithm.dijkstra(graph, vertexStart);
        DijkstraAlgorithm.printResult(shortestPaths, graph);
    }
}
    /*
int[][] adjacencyMatrix = {
                {0, 7, 5, 0, 0, 0, 0},
                {0, 0, 0, 5, 2, 0, 0},
                {0, 0, 0, 9, 0, 3, 0},
                {0, 0, 0, 0, 0, 0, 8},
                {0, 0, 0, 1, 0, 0, 3},
                {0, 0, 0, 1, 0, 0, 4},
                {0, 0, 0, 0, 0, 0, 0}
        };
     */

/*
int[][] adjacencyMatrix = {
                {0, 2, 0, 8, 6, 0, 0, 3},
                {2, 0, 2, 6, 0, 7, 0, 3},
                {0, 2, 0, 9, 6, 4, 1, 0},
                {8, 6, 9, 0, 0, 0, 5, 3},
                {6, 0, 6, 0, 0, 7, 1, 4},
                {0, 7, 4, 0, 7, 0, 3, 0},
                {0, 0, 1, 5, 1, 3, 0, 6},
                {3, 3, 0, 3, 4, 0, 6, 0}
        };
     */