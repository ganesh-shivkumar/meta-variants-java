package leetcode1249;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Variant1 {

    public static void main(String[] args) {
        String s = "[lee(t(c)o))))d[[e)(({{}}}";
        System.out.println(s+"   Test Case 1: Expected lee(t(c)o)de{{}}, Actual " + deleteLeastParentheses(s));

        s = "(()))))minmer((((()([][[{{}";
        System.out.println(s+"   Test Case 2: Expected (())minmer()[]{}}, Actual " + deleteLeastParentheses(s));

        s = "(()))()";
        System.out.println(s+"   Test Case 3: Expected (())(), Actual " + deleteLeastParentheses(s));

        s = "{[({)]}}";
        System.out.println(s+"   Test Case 4: Expected {[({)]}}, Actual " + deleteLeastParentheses(s));

        s = ")))";
        System.out.println(s+"   Test Case 5: Expected , Actual " + deleteLeastParentheses(s));

        s = "((((";
        System.out.println(s+"   Test Case 6: Expected , Actual " + deleteLeastParentheses(s));

        s = "({({([}";
        System.out.println(s+"   Test Case 7: Expected {}, Actual " + deleteLeastParentheses(s));

        s = "([)]";
        System.out.println(s+"   Test Case 8: Expected ([)], Actual " + deleteLeastParentheses(s));

        s = "([)";
        System.out.println(s+"   Test Case 9: Expected (), Actual " + deleteLeastParentheses(s));

        s = "))((ab()c)(";
        System.out.println(s+"   Test Case 10: Expected ((ab)c), Actual " + deleteLeastParentheses(s));

        s = "((ab((()))c)(";
        System.out.println(s+"   Test Case 11: Expected ((ab(()))c), Actual " + deleteLeastParentheses(s));

    }

    public static String deleteLeastParentheses(String input){

        Map<Character, Character> closeBrackets = new HashMap<>();
        closeBrackets.put(')', '(');
        closeBrackets.put('}', '{');
        closeBrackets.put(']', '[');

        Map<Character, Integer> totalOpenBracketCount = new HashMap<>();
        totalOpenBracketCount.put('(', 0);
        totalOpenBracketCount.put('{', 0);
        totalOpenBracketCount.put('[', 0);

        Map<Character, Integer> extraOpenBracketCount = new HashMap<>();
        extraOpenBracketCount.put('(', 0);
        extraOpenBracketCount.put('{', 0);
        extraOpenBracketCount.put('[', 0);

        Map<Character, Integer> keepOpenBracketCount = new HashMap<>();
        keepOpenBracketCount.put('(', 0);
        keepOpenBracketCount.put('{', 0);
        keepOpenBracketCount.put('[', 0);

        StringBuilder balanceCloseBrackets = new StringBuilder();
        for(char c : input.toCharArray()){
            if(closeBrackets.containsKey(c)){
                char openBrack = closeBrackets.get(c);
                if (extraOpenBracketCount.get(openBrack) > 0) { // Corrected condition
                    extraOpenBracketCount.put(openBrack, extraOpenBracketCount.get(openBrack) - 1);
                    balanceCloseBrackets.append(c);
                }
            } else if(totalOpenBracketCount.containsKey(c)){
                extraOpenBracketCount.put(c, extraOpenBracketCount.get(c)+1);
                totalOpenBracketCount.put(c, totalOpenBracketCount.get(c)+1);
                balanceCloseBrackets.append(c);
            } else {
                balanceCloseBrackets.append(c);
            }
        }

        for(Character c : keepOpenBracketCount.keySet()){
            keepOpenBracketCount.put(c, totalOpenBracketCount.get(c) - extraOpenBracketCount.get(c));
        }

        StringBuilder balanceOpenBrackets = new StringBuilder();
        for(char c : balanceCloseBrackets.toString().toCharArray()){
            if(keepOpenBracketCount.containsKey(c)){
                if(keepOpenBracketCount.get(c) == 0){
                    continue;
                }
                balanceOpenBrackets.append(c);
                keepOpenBracketCount.put(c, keepOpenBracketCount.get(c)-1);

            } else {
                balanceOpenBrackets.append(c);
            }
        }


        return balanceOpenBrackets.toString();
    }
}
