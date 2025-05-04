package leetcode125;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Variant {

    public static boolean isPalindrome(String input, List<Character> list){

        int left = 0;
        int right = input.length() - 1;

        while( left < right){
            char lc = input.charAt(left);
            if(!list.contains(lc)){
                left++;
                continue;
            }

            char rc = input.charAt(right);
            if(!list.contains(rc)){
                right--;
                continue;
            }

//            System.out.println("lc, rc ==>> " + lc + " , " + rc);

            if(lc != rc) return false;

            left++;
            right--;
        }

        return true;
    }

    public static boolean validate(char c, List<Character> list){
        return list.contains(c);
    }

    public static void main(String[] args) {
        String s = "yo banana boy!";
        List<Character> include = Arrays.asList('y', 'o', 'b', 'a', 'n');
        System.out.println("Test Number: 1, Input: s = \"" + s + "\", include = " + include + ", Expected Result: true, Actual Result: " + isPalindrome(s, include));

        s = "Yo, banana boY!";
        include = Arrays.asList('Y', 'o', 'b', 'a', 'n');
        System.out.println("Test Number: 2, Input: s = \"" + s + "\", include = " + include + ", Expected Result: true, Actual Result: " + isPalindrome(s, include));

        s = "a b c d e d c b a";
        include = Arrays.asList('a', ' ', 'b', 'c', 'd', 'e');
        System.out.println("Test Number: 3, Input: s = \"" + s + "\", include = " + include + ", Expected Result: true, Actual Result: " + isPalindrome(s, include));

        s = "a b c d e d c b a";
        include = Arrays.asList('a', 'b', 'c', 'd', 'e');
        System.out.println("Test Number: 4, Input: s = \"" + s + "\", include = " + include + ", Expected Result: true, Actual Result: " + isPalindrome(s, include));

        s = "a b c d e d c b a";
        include = Arrays.asList('a', 'b', 'e');
        System.out.println("Test Number: 5, Input: s = \"" + s + "\", include = " + include + ", Expected Result: true, Actual Result: " + isPalindrome(s, include));

        s = "Wow";
        include = Arrays.asList('W', 'o', 'w');
        System.out.println("Test Number: 6, Input: s = \"" + s + "\", include = " + include + ", Expected Result: false, Actual Result: " + isPalindrome(s, include));

        s = "WwoWWWWWWWWWWWWWow";
        include = Arrays.asList('o', 'w');
        System.out.println("Test Number: 7, Input: s = \"" + s + "\", include = " + include + ", Expected Result: true, Actual Result: " + isPalindrome(s, include));

        s = "__________________";
        include = Arrays.asList('1', '2');
        System.out.println("Test Number: 8, Input: s = \"" + s + "\", include = " + include + ", Expected Result: true, Actual Result: " + isPalindrome(s, include));

        s = "________133__________";
        include = Arrays.asList('1', '3');
        System.out.println("Test Number: 9, Input: s = \"" + s + "\", include = " + include + ", Expected Result: false, Actual Result: " + isPalindrome(s, include));

        s = "____1____133_______________";
        include = Arrays.asList('1', '3', '_');
        System.out.println("Test Number: 10, Input: s = \"" + s + "\", include = " + include + ", Expected Result: false, Actual Result: " + isPalindrome(s, include));

        s = "";
        include = Arrays.asList('1', '3', '_');
        System.out.println("Test Number: 11, Input: s = \"" + s + "\", include = " + include + ", Expected Result: true, Actual Result: " + isPalindrome(s, include));

        s = "";
        include = new ArrayList<>();
        System.out.println("Test Number: 12, Input: s = \"" + s + "\", include = " + include + ", Expected Result: true, Actual Result: " + isPalindrome(s, include));

        s = "MadaM";
        include = new ArrayList<>();
        System.out.println("Test Number: 13, Input: s = \"" + s + "\", include = " + include + ", Expected Result: true, Actual Result: " + isPalindrome(s, include));

        s = "MadaM";
        include = Arrays.asList('z', 'M', 'd');
        System.out.println("Test Number: 14, Input: s = \"" + s + "\", include = " + include + ", Expected Result: true, Actual Result: " + isPalindrome(s, include));

        s = "MadaMM";
        include = Arrays.asList('z', 'M', 'd');
        System.out.println("Test Number: 15, Input: s = \"" + s + "\", include = " + include + ", Expected Result: false, Actual Result: " + isPalindrome(s, include));

        s = "racecarX";
        include = Arrays.asList('r', 'X');
        System.out.println("Test Number: 16, Input: s = \"" + s + "\", include = " + include + ", Expected Result: false, Actual Result: " + isPalindrome(s, include));

    }
}
