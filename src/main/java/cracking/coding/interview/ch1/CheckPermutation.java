package cracking.coding.interview.ch1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given 2 String write am ethod to check  if one is permutation or others
 */
public class CheckPermutation {

    private static boolean isStringPermutation(String str1,String str2){
        //String are only permutated if they have same number of charcters
        if(str1.length() == str2.length()){
            Map<Character,Integer> charCountMap=new HashMap <>();
            for(int i =0; i < str1.length();i++){
                if(charCountMap.get(str1.charAt(i))==null){
                    charCountMap.put(str1.charAt(i),1);
                }else{
                    charCountMap.put(str1.charAt(i),charCountMap.get(str1.charAt(i))+1);
                }
            }
            for(int i =0; i < str2.length();i++){

                if(charCountMap.get(str2.charAt(i))!=null){
                    if(charCountMap.get(str2.charAt(i)) < 1){
                        return false;
                    }
                    charCountMap.put(str2.charAt(i),charCountMap.get(str2.charAt(i))-1);
                }else{
                    return false;
                }

            }
            return true;

        }

        return false;

    }

    private static boolean isStringPermutationSimple(String str1,String str2){
        //String are only permutated if they have same number of charcters
        if(str1.length() == str2.length()){
           return sort(str1).equals(sort(str2));

        }

        return false;

    }

    private static String sort(String str1){
        char[] content=str1.toCharArray();
        Arrays.sort(content);
        return new String(content);

    }

    public static void main(String[] args) {
        System.out.println(isStringPermutation("doog","good"));
        System.out.println(isStringPermutation("aaabbbffftttjuki","aafftttjukiabbbf"));
        System.out.println(isStringPermutation("aaabbbtfftttjuki","aafftttkukiabbbf"));

        System.out.println(isStringPermutationSimple("doog","good"));
        System.out.println(isStringPermutationSimple("aaabbbffftttjuki","aafftttjukiabbbf"));
        System.out.println(isStringPermutationSimple("aaabbbtfftttjuki","aafftttkukiabbbf"));
    }
}
