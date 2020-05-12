package code.problem.easy;

public class LengthOfLastWord {

    /**
     * Faster Solution
     * @param s
     * @return
     */
    public static int lengthOfLastWordWithoutSplit(String s) {
        s = s.trim();
        int length = s.length();

        if(s==null || s.trim().length()==0){
            return 0;
        }else{
            boolean isFound=false;
            while(length >=1){
                --length;
                if(s.charAt(length)==' '){
                    isFound=true;
                    break;
                }
            }
            if(isFound){
                return s.substring(length+1).length();
            }else{
                return s.substring(length).length();
            }
        }
    }

    /**
     * Slower Solution
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {
        if(s==null || s.trim().length()==0){
            return 0;
        }

        String [] words = s.split(" ");
        return words[words.length-1].length();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWordWithoutSplit("Hello World"));
    }
}
