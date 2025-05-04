package leetcode1004;

public class Variant1 {

    public static void main(String[] args) {

        char[] days1 = {'W', 'W', 'H', 'H', 'W', 'W', 'W'};
        int pto1 = 0;
        System.out.println("1 ==>> " + getLongestVacation(days1, pto1));

        char[] days2 = {'W', 'W', 'H', 'H', 'W', 'W', 'W'};
        int pto2 = 5;
        System.out.println("2 ==>> " + getLongestVacation(days2, pto2));

        char[] days3 = {'W', 'W', 'H', 'H', 'W', 'W', 'W'};
        int pto3 = 10;
        System.out.println("3 ==>> " + getLongestVacation(days3, pto3));

        char[] days4 = {'H', 'H', 'H', 'H', 'H', 'H', 'H'};
        int pto4 = 0;
        System.out.println("4 ==>> " + getLongestVacation(days4, pto4));

        char[] days5 = {'W', 'H', 'W', 'W', 'W', 'H', 'W', 'H'};
        int pto5 = 1;
        System.out.println("5 ==>> " + getLongestVacation(days5, pto5));
    }

    public static int getLongestVacation(char[] days, int pto){

        int maxLen = 0;

        int left = 0;
        int right = 0;

        while(right < days.length){
            if(days[right] == 'W') {
                pto--;
            }

            while(pto < 0){
                if(days[left] == 'W'){
                    pto++;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}
