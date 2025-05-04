package leetcode1047;

import java.util.Deque;
import java.util.LinkedList;

public class Variant {

    public static void main(String[] args) {
        String s = "azxxxzy";
        System.out.println("Test Case 1: Expected ay, Actual " + removeAllAdjacentDuplicates(s));

        s = "abbaxx";
        System.out.println("Test Case 2: Expected , Actual " + removeAllAdjacentDuplicates(s));

        s = "aabbccdd";
        System.out.println("Test Case 3: Expected , Actual " + removeAllAdjacentDuplicates(s));

        s = "aaabbaad";
        System.out.println("Test Case 4: Expected d, Actual " + removeAllAdjacentDuplicates(s));

        s = "abcdefg";
        System.out.println("Test Case 5: Expected abcdefg, Actual " + removeAllAdjacentDuplicates(s));

        s = "abbcddeff";
        System.out.println("Test Case 6: Expected ace, Actual " + removeAllAdjacentDuplicates(s));

        s = "abcdeffedcba";
        System.out.println("Test Case 7: Expected , Actual " + removeAllAdjacentDuplicates(s));

        s = "aabccddeeffbbbbbbbbbf";
        System.out.println("Test Case 8: Expected f, Actual " + removeAllAdjacentDuplicates(s));

        s = "abbbacca"; // Cannot pick and choose duplicates in the middle to delete first
        System.out.println("Test Case 9: Expected a, Actual " + removeAllAdjacentDuplicates(s));

        s = "abccba";
        System.out.println("Test Case 10: Expected , Actual " + removeAllAdjacentDuplicates(s));

        s = "abbbacxdd";
        System.out.println("Test Case 11: Expected cx, Actual " + removeAllAdjacentDuplicates(s));
    }

    public static class Letter{
        public char character;
        public int count;

        public Letter(char character, int count){
            this.character = character;
            this.count = count;
        }
    }

    public static String removeAllAdjacentDuplicates(String input){

        Deque<Letter> queue = new LinkedList<>();

        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);

            if(queue.isEmpty()){
                queue.addLast(new Letter(c, 1));
                continue;
            } else if (queue.getLast().character == c){
                queue.getLast().count++;
                continue;
            }

            if(queue.getLast().count > 1){
                queue.removeLast();
            }

            if(queue.isEmpty() || queue.getLast().character != c){
                queue.addLast(new Letter(c, 1));
            } else if (queue.getLast().character == c){
                queue.getLast().count++;
            }
        }

        if(!queue.isEmpty() && queue.getLast().count > 1){
            queue.removeLast();
        }

        StringBuilder sb = new StringBuilder();
        for(Letter letter : queue){
            sb.append(letter.character);
        }
        return sb.toString();
    }
}
