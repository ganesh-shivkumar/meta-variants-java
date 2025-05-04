package leetcode1004;

public class Variant2 {

    /**
     * Given an array of integers representing a year (1 for weekend, 0 for weekday),
     * and the number of PTO days you can take, find the maximum number of consecutive
     * days you can have off.
     *
     * @param year The array representing the year.
     * @param pto  The number of PTO days available.
     * @return The maximum number of consecutive days off.
     */
    public static int longestVacationTimeSecondVariant(int[] year, int pto) {
        int maxVacation = 0;
        int left = 0;
        for (int right = 0; right < year.length; right++) {
            if (year[right] == 0) {
                pto--;
            }

            while (pto < 0) {
                if (year[left] == 0) {
                    pto++;
                }
                left++;
            }

            maxVacation = Math.max(maxVacation, right - left + 1);
        }
        return maxVacation;
    }

    public static void main(String[] args) {

        int[] year1 = {0, 1, 1, 0, 0, 1, 0};
        int pto1 = 2;
        System.out.println("Test Case 1: Expected 5, Actual " + longestVacationTimeSecondVariant(year1, pto1));


        int[] year2 = {0, 0, 1, 1, 0, 0, 0};
        int pto2 = 0;
        System.out.println("Test Case 2: Expected 2, Actual " + longestVacationTimeSecondVariant(year2, pto2));

        int[] year3 = {0, 0, 1, 1, 0, 0, 0};
        int pto3 = 5;
        System.out.println("Test Case 3: Expected 7, Actual " + longestVacationTimeSecondVariant(year3, pto3));

        int[] year4 = {0, 0, 1, 1, 0, 0, 0};
        int pto4 = 10;
        System.out.println("Test Case 4: Expected 7, Actual " + longestVacationTimeSecondVariant(year4, pto4));

        int[] year5 = {1, 1, 1, 1, 1, 1, 1};
        int pto5 = 0;
        System.out.println("Test Case 5: Expected 7, Actual " + longestVacationTimeSecondVariant(year5, pto5));

        int[] year6 = {0, 1, 0, 0, 0, 1, 0, 1};
        int pto6 = 1;
        System.out.println("Test Case 6: Expected 3, Actual " + longestVacationTimeSecondVariant(year6, pto6));

        System.out.println("All test cases execution completed!");
    }

}
