package code.problem.easy;

/**
 * 125. Valid Palindrome
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {
    String alfaNumeric ="abcdefghijklmnopqrstuvwxyz0123456789";
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int length = s.length()-1;
        int index =0;
        while(index < length){
            char left =s.charAt(index);
            char right =s.charAt(length);
            if(left==' ' || alfaNumeric.indexOf(left)==-1){
                index++;
            }else if(right==' ' || alfaNumeric.indexOf(right)==-1){
                length--;
            }else {
                if(left!= right){
                    return false;
                }
                index++;
                length--;
            }
        }
        return true;

    }
}
