package topologicalsorting;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

class Graph {
    int v;
    LinkedList<Integer> linkedList[];
    Graph(int v) {
        this.v=v;
        linkedList= new LinkedList[v];
        for(int i=0;i<v;i++) {
            linkedList[i]= new LinkedList<>();
        }
    }
}
public class Solution {
    public void addEdge(Graph graph, int src, int dest) {
        graph.linkedList[src].add(dest);
    }

    public void DFSUtilTopological(Graph graph, int src, boolean visited[], Stack<Integer> stack) {
        visited[src]= true;
        Iterator<Integer> iterator= graph.linkedList[src].iterator();
        while(iterator.hasNext()) {
            int temp= iterator.next();
            if(!visited[temp]) {
                DFSUtilTopological(graph, temp, visited, stack);
            }
        }
        stack.push(src);
    }
    public void DFS(Graph graph, int src) {
        boolean visited[]= new boolean[graph.v];
        Arrays.fill(visited, false);

        Stack<Integer> stack= new Stack<>();
        DFSUtilTopological(graph, 0, visited, stack);
        while(!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }
    }

    public static void main(String args[]) {
        Graph graph= new Graph(4);
        Solution solution= new Solution();
        solution.addEdge(graph, 0,1);
        solution.addEdge(graph, 0,2);
        solution.addEdge(graph, 1,3);
        solution.addEdge(graph, 2,3);

        solution.DFS(graph, 0);

    }
}
