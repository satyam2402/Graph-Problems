package dfstraversalofagraphrecursion;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Graph {
    int v;
    LinkedList<Integer> adjlist[];
    Graph(int v) {
        this.v=v;
        adjlist= new LinkedList[v];
        for(int i=0;i<v;i++) {
            adjlist[i]=  new LinkedList<>();
        }
    }

    public void addEdge(int src, int des) {
        //Since it is undirected graph
        adjlist[src].add(des);
        adjlist[des].add(src);
    }

}

public class Solution {

    public void BFS(Graph graph, int src) {
        Queue<Integer> queue= new LinkedList<>();
        queue.add(src);
        boolean visited[]= new boolean[graph.v];
        visited[src]=true;
        while(!queue.isEmpty()) {
            int temp= queue.remove();
            System.out.print(temp+" ");
            Iterator<Integer> iterator= graph.adjlist[temp].iterator();
            while(iterator.hasNext()) {
                int tempval=iterator.next();
                if(!visited[tempval]) {
                    visited[tempval]=true;
                    queue.add(tempval);
                }
            }
        }
    }

    public void DFS(Graph graph, int src, boolean visited[]) {
        visited[src]=true;
        System.out.print(src+" ");
        Iterator<Integer> iterator= graph.adjlist[src].iterator();
        while (iterator.hasNext()) {
            int temp= iterator.next();
            if(!visited[temp]) {
                DFS(graph, temp, visited);
            }
        }

    }

    public void DFSutil(Graph graph, int src) {
        boolean visited[]= new boolean[graph.v];
        DFS(graph, src, visited);
    }

    public void DFSUsingStack(Graph graph, int src) {
        Stack<Integer> stack= new Stack<>();
        stack.push(src);
        boolean visited[]= new boolean[graph.v];
        visited[src]=true;
        while(!stack.isEmpty()) {
            int temp= stack.pop();
            System.out.print(temp+" ");
            LinkedList<Integer> linkedList= graph.adjlist[temp];
            for(int i=linkedList.size()-1;i>=0;i--) {
                if(!visited[linkedList.get(i)]) {
                    visited[linkedList.get(i)]=true;
                    stack.push(linkedList.get(i));
                }
            }
        }
    }

    public static void main(String args[]) {
        Solution solution= new Solution();

        Graph graph= new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(4,1);
        solution.BFS(graph,0);
        System.out.println();
        solution.DFSutil(graph, 0);
        System.out.println();
        solution.DFSUsingStack(graph, 0);
    }
}
