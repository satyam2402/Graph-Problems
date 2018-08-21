package findingmotherverticesinagraph;

import java.util.*;

class Graph {
    int v;
    LinkedList<Integer> adjli[];
    Graph(int v) {
        this.v=v;
        adjli= new LinkedList[v];
        for(int i=0;i<v;i++) {
            adjli[i]= new LinkedList<>();
        }
    }
    public void addEdge(int src, int des) {
        //Since it is directed graph
        adjli[src].add(des);
    }
}

public class Solution {

    public void BFSTrav(Graph graph, int src) {
        boolean visited[]= new boolean[graph.v];
        Queue<Integer> queue= new LinkedList<>();
        queue.add(src);
        visited[src]=true;
        Set<Integer> set= new HashSet<>();

        while (!queue.isEmpty()) {
            int temp= queue.remove();
            set.add(temp);
            Iterator<Integer> iterator= graph.adjli[temp].iterator();
            while(iterator.hasNext()) {
                int tempval= iterator.next();
                if(!visited[tempval]) {
                    queue.add(tempval);
                }
            }
        }
        if(set.size()==graph.v) {
            System.out.println("Mother Vertex:"+src);
        }
    }
    public static void main(String args[]) {
        Solution solution= new Solution();

        Graph graph= new Graph(3);
        graph.addEdge(1,0);
        graph.addEdge(1,2);
        for(int i=0; i<graph.v;i++) {
            solution.BFSTrav(graph, i);
        }
    }

}
