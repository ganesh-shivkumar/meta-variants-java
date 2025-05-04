package leetcode1047;

public class Original {

    public static void main(String[] args) {
        String input1 = "abbaca";
        System.out.println(input1 + " --->>> " + removeConsecutiveDuplicatePairs(input1));

        String input2 = "azxxzy";
        System.out.println(input2 + " --->>> " + removeConsecutiveDuplicatePairs(input2));

    }

    public static String removeConsecutiveDuplicatePairs(String input){

        StringBuilder sb = new StringBuilder();
        int len = 0;

        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            if(len !=0 && sb.charAt(len -1) == c){
                sb.deleteCharAt(len-1);
                len--;
            } else {
                sb.append(c);
                len++;
            }
        }
        return sb.toString();
    }
}
