package graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class Dfs {

    public static void dfsHelper(Integer node, ArrayList<ArrayList<Integer>> graphs, boolean[] visited, ArrayList<Integer> dfs){
       visited[node] = true;
       dfs.add(node);
       for(Integer it : graphs.get(node)){
        if(visited[it]!=true){
            dfsHelper(it, graphs, visited, dfs);
        } 
       }
    }



    public static ArrayList<Integer> dfs(Integer start, ArrayList<ArrayList<Integer>> graphs){
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] visited = new boolean[graphs.size()];
        dfsHelper(start, graphs, visited, dfs);
        return dfs;
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        graph.add(new ArrayList<>(Arrays.asList()));
        graph.add(new ArrayList<>(Arrays.asList(2,3)));
        graph.add(new ArrayList<>(Arrays.asList(1,4,5)));
        graph.add(new ArrayList<>(Arrays.asList(1,6,7)));
        graph.add(new ArrayList<>(Arrays.asList(2)));
        graph.add(new ArrayList<>(Arrays.asList(2,8)));
        graph.add(new ArrayList<>(Arrays.asList(3,8)));
        graph.add(new ArrayList<>(Arrays.asList(3,9)));
        graph.add(new ArrayList<>(Arrays.asList(5,6)));
        graph.add(new ArrayList<>(Arrays.asList(7)));
        System.out.println(dfs(1, graph));
    }
    
}
