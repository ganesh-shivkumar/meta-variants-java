package leetcode1424;

import java.util.*;

public class Variant1 {

    public static void main(String[] args) {
        int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> excpected1 = Arrays.asList(1, 2, 4, 3, 5, 7, 6, 8, 9);
        System.out.println("1==>> " + excpected1 + " : actual ==>>" + antidiagonalTraverse(matrix1));

        int[][] matrix2 = {{1,2,3,4,5},{6,7},{8},{9,10,11},{12,13,14,15,16}};
        List<Integer> excpected2 = Arrays.asList(1, 2, 6, 3, 7, 8, 4, 9, 5, 10, 12, 11, 13, 14, 15, 16);
        System.out.println("1==>> " + excpected2 + " : actual ==>>" + antidiagonalTraverse(matrix2));
    }

    public static List<Integer> antidiagonalTraverse(int[][] matrix) {

        List<Integer> answer = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            answer.add(matrix[row][col]);

            if(col+1<matrix[row].length){
                queue.add(new int[]{row, col+1});
            }

            if(col ==0 && row+1<matrix.length){
                queue.add(new int[]{row+1, col});
            }
        }
        return answer;
    }
}
