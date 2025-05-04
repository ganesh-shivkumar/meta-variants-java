package leetcode1091;

import java.util.ArrayList;
import java.util.List;

public class Variant2 {

    /* This is used to get any path. It is recommended to use DFS over BFS because it could be faster than BFS.*/
    public static void main(String[] args) {

        int[][] grid1 = {{0,0,0},{1,1,0},{1,1,0}};
        int[][] grid2 = {{1,0,0},{1,1,0},{1,1,0}};

        System.out.println("1 ==>> " + findPath(grid1));
        System.out.println("2 ==>> " + findPath(grid2));
    }

    public static int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}, {1,1}, {-1,-1}, {1,-1}, {-1,1}};

    public static class Path{
        public int row;
        public int col;
        public List<String> path;

        public Path(int row, int col, List<String> path){
            this.row = row;
            this.col = col;
            this.path = path;
        }
    }

    public static String key(int row, int col){
        return row+":"+col;
    }

    public static List<String> findPath(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1) visited[i][j] = true;
            }
        }

        List<String> path = new ArrayList<>();
        if(dfs(grid, path, 0, 0, m, n, visited)){
            return path;
        } else {
            return new ArrayList<>();
        }
    }

    public static boolean dfs(int [][] grid, List<String> path, int row, int col, int m, int n, boolean[][] visited){

        if(visited[row][col]) return false;
        visited[row][col] = true;
        path.add(key(row, col));

        if(row == m-1 && col == n-1){
            return true;
        }

        for(int[] dir : directions){
            int i = row + dir[0];
            int j = col + dir[1];

            if(i>=0 && i<m && j>=0 && j<n && !visited[i][j]){
                if(dfs(grid, path, i, j, m, n, visited)){
                    return true;
                }
            }
        }
        path.remove(path.size()-1);
        return false;
    }

}
