import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 4. Програма, яка для заданого графа завдання 3, формує по списку суміжності матрицю суміжності для заданого графу.
public class task5 {

    public static void main(String[] args) {
        List<String> adjacencyList = Arrays.asList(
                "1 -> 2,2 4,8 5,6 8,3",
                "2 -> 1,2 3,2 4,6 6,7 8,3",
                "3 -> 2,2 4,9 5,6 6,4 7,1",
                "4 -> 1,8 2,6 3,9 7,5 8,3",
                "5 -> 1,6 3,6 6,7 7,1 8,4",
                "6 -> 2,7 3,4 5,7 7,3",
                "7 -> 3,1 4,5 5,1 6,3 8,6",
                "8 -> 1,3 2,3 4,3 5,4 7,6"
        );
        Graph graph = new Graph(adjacencyList);

        System.out.println("\nСписок суміжностей:");
        System.out.println(graph.getAdjacenciesList());

        System.out.println("\nМатриця суміжності з створеного графа:");
        System.out.println(graph.getAdjacenciesMatrix());


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
List<String> adjacencyList = Arrays.asList(
                "1 -> 2,7 3,5",
                "2 -> 4,5 5,2",
                "3 -> 4,9 6,3",
                "4 -> 7,8",
                "5 -> 4,1 7,3",
                "6 -> 4,1 7,4",
                "7 ->"
        );
     */

/*
List<String> adjacencyList = Arrays.asList(
               "1 -> 2,2 4,8 5,6 8,3",
               "2 -> 1,2 3,2 4,6 6,7 8,3",
               "3 -> 2,2 4,9 5,6 6,4 7,1",
               "4 -> 1,8 2,6 3,9 7,5 8,3",
               "5 -> 1,6 3,6 6,7 7,1 8,4",
               "6 -> 2,7 3,4 5,7 7,3",
               "7 -> 3,1 4,5 5,1 6,3 8,6",
               "8 -> 1,3 2,3 4,3 5,4 7,6"
        );
     */