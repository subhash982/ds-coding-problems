package cracking.coding.interview.ch1;

/**
 * Write a method to replace all the space with %20, Assume that string have the enough space to replace the space with %20
 */
public class URLify {

    private static String replaceSpaces(String inputStr, int trueLength){
        int currentIndex =inputStr.length()-1;
        char [] chars= new char[inputStr.length()];
        //count SPaces
        for(int i =trueLength-1; i >= 0;i--){
            if(inputStr.charAt(i)==' '){
                chars[currentIndex]='0';
                chars[currentIndex-1]='2';
                chars[currentIndex-2]='%';
                currentIndex = currentIndex-3;
            }else{
                chars[currentIndex]=inputStr.charAt(i);
                --currentIndex;
            }


        }
        return new String(chars);

    }

    public static void main(String[] args) {
        System.out.println(replaceSpaces("Mr John Smith    " , 13));
    }

}
