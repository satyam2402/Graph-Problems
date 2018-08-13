package graphrepresentation;

import java.util.Iterator;
import java.util.LinkedList;

class Graph {
    int v;
    LinkedList<Integer> adjlist[];
    Graph(int v) {
        this.v= v;
        adjlist= new LinkedList[v];
        for(int i=0; i<v; i++) {
            adjlist[i]= new LinkedList<Integer>();
        }
    }
}
public class Solution {
    // Adding an edge in the directed graph.
    public void addingEdge(Graph graph, int src, int dest) {
        graph.adjlist[src].add(dest);
    }

    public void printGraph(Graph graph) {
        int size= graph.v;
        for(int i=0;i<size;i++) {
            Iterator<Integer> iterator= graph.adjlist[i].iterator();
            System.out.print(i+": ");
            while(iterator.hasNext()) {
                System.out.print(iterator.next()+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]) {
        Solution solution= new Solution();
        Graph graph= new Graph(4);
        solution.addingEdge(graph, 0, 0);
        solution.addingEdge(graph, 0, 1);
        solution.addingEdge(graph, 1, 1);
        solution.addingEdge(graph, 1, 2);
        solution.addingEdge(graph, 2, 2);
        solution.addingEdge(graph, 2, 3);
        solution.addingEdge(graph, 3, 3);
        solution.addingEdge(graph, 3, 4);

        solution.printGraph(graph);
    }
}
