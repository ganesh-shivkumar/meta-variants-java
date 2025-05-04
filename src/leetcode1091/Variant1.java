package leetcode1091;

import java.util.*;

public class Variant1 {

    public static void main(String[] args) {

        int[][] grid1 = {{0,0,0},{1,1,0},{1,1,0}};
        int[][] grid2 = {{1,0,0},{1,1,0},{1,1,0}};

        System.out.println("1 ==>> " + findShortestPath(grid1));
        System.out.println("2 ==>> " + findShortestPath(grid2));
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

    public static List<String> findShortestPath(int[][] grid){

        if(grid[0][0] != 0) return new ArrayList<>();

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

        Queue<Path> queue = new LinkedList<Path>();
        queue.add(new Path(0,0, Arrays.asList(key(0,0))));
        visited[0][0] = true;

        while (!queue.isEmpty()){
            Path current = queue.poll();
            int row = current.row;
            int col = current.col;
            List<String> path = current.path;

            if(row==m-1 && col==n-1){
                return path;
            }

            for(int[] dir : directions){
                int i = row + dir[0];
                int j = col + dir[1];

                if(i>=0 && i<m && j>=0 && j<n && !visited[i][j]){
                    visited[i][j] = true;
                    List<String> newPath = new ArrayList(path);
                    newPath.add(key(i,j));
                    queue.add(new Path(i, j, newPath));
                }
            }
        }
        return new ArrayList<>();
    }
}
