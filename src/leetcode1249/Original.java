package leetcode1249;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Original {

    public static void main(String[] args) {
        String input1 = "lee(t(c)o)de)";
        String input2  = "a)b(c)d";
        String input3 = "))((";

        System.out.println(input1 + " ===>>> " + balanceParanthesesWithStack(input1));
        System.out.println(input2 + " ===>>> " + balanceParanthesesWithStack(input2));
        System.out.println(input3 + " ===>>> " + balanceParanthesesWithStack(input3));
    }

    public static String balanceParanthesesWithStack(String input){

        Set<Integer> indicesToRemove = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            if(c == '('){
                stack.push(i);
            } else if( c ==')'){
                if(stack.isEmpty()){
                    indicesToRemove.add(i);
                } else {
                    stack.pop();
                }
            }
        }

        while(!stack.isEmpty()){
            indicesToRemove.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<input.length(); i++){
            if(!indicesToRemove.contains(i)){
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }
}
