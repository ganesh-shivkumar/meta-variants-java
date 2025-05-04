package leetcode1004;

public class Original {

    public static void main(String[] args) {

        int[] input1 = {1,1,1,0,0,0,1,1,1,1,0};
        int k1 = 2;

        int[] input2 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k2 = 3;

        System.out.println("input 1 ==> " + getLongest(input1, k1));
        System.out.println("input 2 ==> " + getLongest(input2, k2));
    }

    public static int getLongest(int[] input, int k) {

        int left = 0;
        int right = 0;

        int maxLen = 0;

        while (right < input.length) {
            if (input[right] == 0) {
                k--;
            }

            while (k < 0) {
                if (input[left] == 0) k++;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}
