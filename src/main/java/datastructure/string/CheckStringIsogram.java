package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckStringIsogram {


    static boolean isIsogramUsingJava8(String data){
        //Your code here
        long length = data.length();
        long charCount = Arrays.stream(data.split("")).distinct().count();
       return length == charCount;
    }
    static boolean isIsogram(String data){
        //Your code here
        if(data!=null){
            List<Character> chars = new ArrayList<>();
            for(int i=0; i < data.length();i++){
                if(chars.contains(data.charAt(i))){
                    return false;
                }else{
                    chars.add(data.charAt(i));
                }
            }
        }else{
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Solution 1: ");
        System.out.println(isIsogram("qwertyuiop"));
        System.out.println(isIsogram("qwertyuiope"));

        System.out.println("Solution 2: ");
        System.out.println(isIsogramUsingJava8("qwertyuiop"));
        System.out.println(isIsogramUsingJava8("qwertyuiope"));
    }
}
