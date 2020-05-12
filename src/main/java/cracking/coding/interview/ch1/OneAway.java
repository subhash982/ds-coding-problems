package cracking.coding.interview.ch1;

/**
 * There are thress type of edit can be performed on a String replace,delete or insert a character. Write a function the String are one edit away
 */
public class OneAway {
    private static boolean isOneEditAway(String str1,String str2) {
        if(str1.length()==str2.length()){
            return isOneEditReplace(str1, str2);
        }else if(str1.length()+1==str2.length()){
            return isOneEditInsert(str1, str2);

        }else if(str1.length()-1==str2.length()){
            return isOneEditInsert(str2, str1);
        }else{
            return false;
        }

    }

    private static boolean isOneEditReplace(String str1,String str2) {
        boolean editFound=false;
        for(int i=0;i < str1.length();i++){
            if(str1.charAt(i)!=str2.charAt(i)){
                if(editFound){
                    return false;
                }
                editFound=true;
            }
        }
        return editFound;
    }

    private static boolean isOneEditInsert(String longString,String sortString) {

        boolean editFound=false;
        int index1=0;
        int index2=0;
        if(index1<longString.length() && index2<sortString.length()){
            if(longString.charAt(index1)!= sortString.charAt(index2)){
                if(index1!=index2){
                    return false;
                }
                index1++;
            }else{
                index1++;
                index2++;
            }

        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(isOneEditAway("pale","padle"));
    }
}
