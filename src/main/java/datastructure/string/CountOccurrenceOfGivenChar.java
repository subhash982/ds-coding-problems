package string;

import org.apache.commons.lang3.StringUtils;

public class CountOccurrenceOfGivenChar {

    public static int countOccurrenceOfChar(String input, char ch){
        int count =0;
        if(StringUtils.isEmpty(input)){
            return count;
        }
        for (char c: input.toCharArray()) {
            if(ch==c){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
    System.out.println(countOccurrenceOfChar("subssshash" , 's'));
    }
}
