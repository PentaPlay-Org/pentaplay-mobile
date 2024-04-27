package lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.Games.Game3_IdentifyShortestPath.Logics;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class IdentifyShortestPath {
    private static final int INFINITY = Integer.MAX_VALUE;
    public int source = 0;
    public int destination = 0;
    public int[][] graph = new int[10][10];
    public void getGraph(){
        int[][] cityDistance = new int[10][10];
        for (int i = 0; i < 9 ; i++) {
            for (int j = 0; j < 9; j++) {
                int distance = getDistance();
                cityDistance[i][j] = distance;
            }
            System.out.println();
        }
        graph = cityDistance;
    }

    public int findShortestPath() {
        getSourceDestination();
        getGraph();
        int numVertices = graph.length;
        int[] distance = new int[numVertices];
        boolean[] visited = new boolean[numVertices];

        Arrays.fill(distance, INFINITY);
        distance[source] = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(v -> distance[v]));
        pq.offer(source);

        while (!pq.isEmpty()) {
            int u = pq.poll();
            visited[u] = true;

            for (int v = 0; v < numVertices; v++) {
                if (graph[u][v] != 0 && !visited[v]) {
                    int newDistance = distance[u] + graph[u][v];
                    if (newDistance < distance[v]) {
                        distance[v] = newDistance;
                        pq.offer(v);
                    }
                }
            }
        }

        return distance[destination];
    }

    private void getSourceDestination(){
        source = new Random().nextInt(8);
        destination = 0;
        while (source == destination)
            destination = new Random().nextInt(8);
    }

    private static int getDistance() {
        int distance =  new Random().nextInt(50);
        while(distance < 5)
            distance = new Random().nextInt(50);
        return distance;
    }

}
