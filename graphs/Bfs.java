package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;



public class Bfs{

    public static ArrayList<Integer> bfs(Integer start, ArrayList<ArrayList<Integer>> graphs){
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[graphs.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            Integer node  = queue.poll();
            bfs.add(node);
            for(Integer it : graphs.get(node)){
                if(visited[it]!=true){
                    visited[it]=true;
                    queue.add(it);
                }
            } 
        }

        return bfs;
    }


    public static void main(String[] args){
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
        System.out.println(bfs(3, graph));
    }
}