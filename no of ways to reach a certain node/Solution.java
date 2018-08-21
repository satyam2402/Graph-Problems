package noofwaystoreachacertainnode;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

class Graph {
    int v;
    LinkedList<Integer> linkedList[];
    Graph(int v) {
        this.v=v;
        linkedList= new LinkedList[v];
        for(int i=0;i<v;i++) {
            linkedList[i] = new LinkedList<>();
        }
    }
    public void addEdge(Graph graph, int src, int dest) {
        graph.linkedList[src].add(dest);
    }
}
public class Solution {

    public int findTotalPath(Graph graph, int src, int dest) {
        boolean visited[]= new boolean[graph.v];
        Arrays.fill(visited, false);
        int pathCount=0;
        return pathUtil(graph, src, dest, visited, pathCount);
    }
    public int pathUtil(Graph graph, int src, int dest,boolean visited[], int pathCount) {
        visited[src]= true;
        if(src==dest) {
            pathCount++;
        } else {
            Iterator<Integer> iterator= graph.linkedList[src].iterator();
            while(iterator.hasNext()) {
                int temp= iterator.next();
                if(!visited[temp]) {
                    pathCount= pathUtil(graph, temp, dest, visited, pathCount);
                }
            }
        }
        visited[src]=false;
        return pathCount;
    }

    public static void main(String args[]) {
        Graph graph= new Graph(4);
        graph.addEdge(graph, 0,1);
        graph.addEdge(graph, 0, 2);
        graph.addEdge(graph, 2, 3);
        graph.addEdge(graph, 1, 3);

        Solution solution= new Solution();
        System.out.println("The number of ways to reach a vertex from source vertex is:"+solution.findTotalPath(graph,0,3));
    }
}
