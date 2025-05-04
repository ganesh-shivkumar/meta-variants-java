package leetcode1091;

import java.util.LinkedList;
import java.util.Queue;

public class Original {

    public static void main(String[] args) {
        
        int[][] grid1 = {{0,0,0},{1,1,0},{1,1,0}};
        int[][] grid2 = {{1,0,0},{1,1,0},{1,1,0}};

        System.out.println("1 ==>> " + findShortestPath(grid1));
        System.out.println("2 ==>> " + findShortestPath(grid2));
    }

    public static int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}, {1,1}, {-1,-1}, {1,-1}, {-1,1}};

    public static int findShortestPath(int[][] grid){

        if(grid[0][0] != 0) return -1;

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    visited[i][j] = true;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[]{0,0,1});
        visited[0][0] = true;

        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int dist = current[2];

            if(row==m-1 && col==n-1){
                return dist;
            }

            for(int[] dir : directions){
                int i = row + dir[0];
                int j = col + dir[1];

                if(i>=0 && i<m && j>=0 && j<n && !visited[i][j]){
                    visited[i][j] = true;
                    queue.add(new int[]{i, j, dist+1});
                }
            }
        }
        return -1;
    }
}
