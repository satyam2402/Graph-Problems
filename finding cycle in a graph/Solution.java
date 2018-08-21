package findingcycleinagraph;

import java.util.*;

class Graph {
    int v;
    LinkedList<Integer> adjli[];
    Graph(int v) {
        this.v= v;
        adjli= new LinkedList[v];
        for(int i=0;i<v;i++) {
            adjli[i]= new LinkedList<>();
        }
    }
}
public class Solution {
    public void addEdge(Graph graph, int src, int dest) {
        graph.adjli[src].add(dest);
    }
    public boolean DFSUtil(Graph graph, int src, Boolean visited[], Boolean rec[]) {
        if(rec[src]) {
            return true;
        }
        if(visited[src]) {
            return false;
        }
        visited[src] = true;
        rec[src] = true;
        Iterator<Integer> iterator = graph.adjli[src].iterator();
        while (iterator.hasNext()) {
            int temp = iterator.next();
            if(DFSUtil(graph, temp, visited, rec)) {
                return true;
            }
        }
        rec[src]= false;
        return false;
    }
    public void DFS(Graph graph, int src){
        Boolean visited[]= new Boolean[graph.v];
        Boolean rec[]= new Boolean[graph.v];
        Arrays.fill(visited, false);
        Arrays.fill(rec, false);

        System.out.println("Cycle in graph:"+DFSUtil(graph, src, visited, rec));
    }
    public static void main(String args[]) {
        Graph graph= new Graph(4);
        Solution solution= new Solution();
        solution.addEdge(graph, 0,1);
        solution.addEdge(graph, 1,2);
        solution.addEdge(graph,2,3);
        solution.addEdge(graph, 0, 3);
        solution.DFS(graph,0);
    }
}
