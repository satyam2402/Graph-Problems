package findingcycleinundirectedgraph;

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
        graph.adjli[dest].add(src);
    }
    public boolean DFSUtil(Graph graph, int src, Boolean visited[], int parent) {
        visited[src] = true;
        Iterator<Integer> iterator = graph.adjli[src].iterator();
        while (iterator.hasNext()) {
            int temp = iterator.next();
            if(!visited[temp]) {
                if(DFSUtil(graph, temp, visited, src)) {
                    return true;
                }
            } else if(temp!=parent) {
                return true;
            }
        }
        return false;
    }
    public void DFS(Graph graph, int src){
        Boolean visited[]= new Boolean[graph.v];
        Arrays.fill(visited, false);

        System.out.println("Cycle in graph:"+DFSUtil(graph, src, visited, 0));
    }
    public static void main(String args[]) {
        Graph graph= new Graph(4);
        Solution solution= new Solution();
        solution.addEdge(graph, 0,1);
        solution.addEdge(graph, 1,2);
        solution.addEdge(graph,2,0);
        solution.DFS(graph,0);
    }
}
