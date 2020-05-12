package code.problem.medium;

/**
 * 6# The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"

 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string s, int numRows);
 Example 1:

 Input: s = "PAYPALISHIRING", numRows = 3
 Output: "PAHNAPLSIIGYIR"
 Example 2:

 Input: s = "PAYPALISHIRING", numRows = 4
 Output: "PINALSIGYAHRPI"
 Explanation:

 P     I    N
 A   L S  I G
 Y A   H R
 P     I
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(s==null || s.length()==0 || numRows <2){
            return s;
        }
        String [] zigZag = new String [numRows];
        boolean isIncreasing=true;
        int index =0;
        int rowCount =0;
        while(index < s.length()){
            if(zigZag[rowCount]==null){
                zigZag[rowCount] ="";
            }
            zigZag[rowCount]+= s.charAt(index);
            if(isIncreasing){
                rowCount++;
                if(rowCount==numRows){
                    isIncreasing =false;
                    rowCount=rowCount-2;
                }
            }else{
                rowCount--;
                if(rowCount<0){
                    isIncreasing =true;
                    rowCount=rowCount+2;
                }
            }

            index++;
        }
        StringBuilder builder =new StringBuilder();
        for(String str : zigZag ){
            if(str!=null){
                builder.append(str);
            }
        }
        return builder.toString();
    }
}
