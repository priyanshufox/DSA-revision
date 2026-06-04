package graphs;

import java.util.ArrayList;

public class NoOfProvinces {
    

    public static void dfs(ArrayList<ArrayList<Integer>> adjLs, int [] vis, int nd){
        vis[nd] = 1;
        for(int nb : adjLs.get(nd)){
            if(vis[nb]==0){                
                dfs(adjLs,vis,nb);
            }
        }
    }
    public static int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<isConnected.length;i++){
            adjList.add(new ArrayList<Integer>());
        }


        for(int i=0;i<isConnected.length;i++){
            for(int j=0; j<isConnected.length ; j++){
                if(isConnected[i][j]==1 && i!=j){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        int [] isVis = new int[isConnected.length];
        int c = 0 ;
        for(int i = 0; i < isVis.length; i++){
            if(isVis[i] == 0){
                c++;
                dfs(adjList, isVis, i);  // ✅ passing the INDEX
            }
        }
        return c;
    }

        public static void main(String[] args) {
            NoOfProvinces np = new NoOfProvinces();
            int [][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
            System.out.println(np.findCircleNum(isConnected));
        }
}

