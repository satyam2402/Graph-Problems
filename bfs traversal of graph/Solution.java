package bfstraversalofgraph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Graph {
    int v;
    LinkedList<Integer> adjList[];
    Graph(int v) {
        this.v= v;
        adjList= new LinkedList[v];
        for(int i=0;i<v;i++) {
            adjList[i]= new LinkedList<Integer>();
        }
    }
}

public class Solution {
    //Adding an edge in the undirected graph
    public void addEdge(Graph graph, int src, int dest) {
        graph.adjList[src].add(dest);
        graph.adjList[dest].add(src);
    }

    //TODO
    public void printgraph(Graph graph) {
        for(int i=0; i<graph.v; i++) {
            System.out.print(i+": ");
            Iterator<Integer> iterator= graph.adjList[i].iterator();
            while(iterator.hasNext()) {
                System.out.print(iterator.next()+" ");
            }
            System.out.println();
        }
    }

    public void bfsTraversal(Graph graph, int src) {
        boolean visited[]= new boolean[graph.v];
        System.out.println("BFS Traversal of Graph");
        Queue<Integer> queue= new LinkedList<>();
        queue.add(src);
        while(!queue.isEmpty()) {
            int temp= queue.remove();
            if(!visited[temp]) {
                visited[temp]=true;
                System.out.print(temp+" ");
            }
            Iterator<Integer> iterator= graph.adjList[temp].iterator();
            while(iterator.hasNext()) {
                queue.add(iterator.next());
            }
        }
    }

    public static void main(String args[]) {
        Solution solution= new Solution();
        Graph graph= new Graph(4);

        solution.addEdge(graph, 0,1);
        solution.addEdge(graph, 1,2);
        solution.addEdge(graph, 2,3);
        solution.addEdge(graph, 3,0);

        solution.printgraph(graph);

        solution.bfsTraversal(graph, 0);
    }
}
