package leetcode121;

public class Original {

    public static void main(String[] args) {
        int[] prices1 = {7,1,5,3,6,4};
        int[] prices2 = {7,6,4,3,1};

        System.out.println("1 ==>> " + getMaxProfit(prices1));
        System.out.println("2 ==>> " + getMaxProfit(prices2));
    }

    public static int getMaxProfit(int[] prices){

        int minCost = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;

        for(int price : prices){
            minCost = Math.min(minCost, price);
            maxProfit = Math.max(maxProfit, price - minCost);
        }

        return maxProfit;
    }
}
