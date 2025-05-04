package leetcode121;

public class Variant {

    public static void main(String[] args) {
        int[] departures = {8, 3, 6, 10};
        int[] returns = {10, 9, 5, 8};
        System.out.println("Test Case 1: Expected 8, Actual " + findCheapestTickets(departures, returns));

        departures = new int[]{10, 3, 10, 9, 3};
        returns = new int[]{4, 20, 6, 7, 10};
        System.out.println("Test Case 2: Expected 9, Actual " + findCheapestTickets(departures, returns));

        departures = new int[]{1, 3, 10, 9, 3};
        returns = new int[]{1, 20, 6, 7, 10};
        System.out.println("Test Case 3: Expected 7, Actual " + findCheapestTickets(departures, returns));

        departures = new int[]{1, 3, 10, 9, 3};
        returns = new int[]{1, 1, 6, 7, 10};
        System.out.println("Test Case 4: Expected 2, Actual " + findCheapestTickets(departures, returns));

        departures = new int[]{1, 3, 10, 9, 3};
        returns = new int[]{10, 9, 8, 7, 6};
        System.out.println("Test Case 5: Expected 7, Actual " + findCheapestTickets(departures, returns));

        departures = new int[]{12, 33, 44, 9, 23};
        returns = new int[]{100, 90, 80, 70, 15};
        System.out.println("Test Case 6: Expected 24, Actual " + findCheapestTickets(departures, returns));

        departures = new int[]{4, 3, 5, 11, 2};
        returns = new int[]{1, 6, 10, 2, 9};
        System.out.println("Test Case 7: Expected 5, Actual " + findCheapestTickets(departures, returns));

    }

    public static int findCheapestTickets(int[] departures, int[] returns){

        int k = 1 ; // no of days from departure when the ticked can return (i.e if i=0, the min return is 1)

        int minDepartureCost = Integer.MAX_VALUE;
        int minTotalCost = Integer.MAX_VALUE;

        for(int i=k; i<returns.length; i++){
            minDepartureCost = Math.min(minDepartureCost, departures[i-k]);
            minTotalCost = Math.min(minTotalCost, minDepartureCost + returns[i]);
        }

        return minTotalCost;
    }

}
