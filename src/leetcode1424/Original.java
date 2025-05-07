package leetcode1424;

import java.util.*;

public class Original {

    public static void main(String[] args) {
        int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> excpected1 = Arrays.asList(1,4,2,7,5,3,8,6,9);
        System.out.println("1==>> " + excpected1 + " : actual ==>>" + diagonalTraverse(matrix1));

        int[][] matrix2 = {{1,2,3,4,5},{6,7},{8},{9,10,11},{12,13,14,15,16}};
        List<Integer> excpected2 = Arrays.asList(1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16);
        System.out.println("1==>> " + excpected2 + " : actual ==>>" + diagonalTraverse(matrix2));
    }

    public static List<Integer> diagonalTraverse(int[][] matrix){

        List<Integer> answer = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            answer.add(matrix[row][col]);

            if(col == 0 && row+1<matrix.length){
                queue.add(new int[]{row+1, col});
            }

            if(col+1<matrix[row].length){
                queue.add(new int[]{row, col+1});
            }
        }
        return answer;

    }
}
