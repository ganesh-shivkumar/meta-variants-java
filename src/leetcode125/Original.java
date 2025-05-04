package leetcode125;

public class Original {

    public static void main(String[] args) {
       String input1 = "A man, a plan, a canal: Panama";
       String input2 = "race a car";

       System.out.println(input1 + " ==>> " + isPalindrome(input1));
       System.out.println(input2 + " ==>> " + isPalindrome(input2));
    }

    public static boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while(left < right){

            char lc = Character.toLowerCase(s.charAt(left));
            if(!validate(lc)){
                left++;
                continue;
            }

            char rc = Character.toLowerCase(s.charAt(right));
            if(!validate(rc)){
                right--;
                continue;
            }

            // System.out.println("lc, rc ==>"+ lc + ":" + rc);

            if(lc != rc) return false;

            left++;
            right--;
        }
        return true;
    }

    public static boolean validate(char c){
        if((c >= 'a' && c <= 'z')  || (c >= '0' && c <= '9')){
            // System.out.println("c ==>"+ c);
            return true;
        } else {
            return false;
        }
    }
}
