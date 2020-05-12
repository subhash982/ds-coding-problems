package ds.dp;

public class FindLongestCommonSubsequence {

    public static int findLongestCommonSequence(String str1, String str2,boolean isUsingDP) {
        if(isUsingDP){
            int[][] lcs = new int[str1.length()+1][str2.length()+1];
            for(int i=0; i<= str1.length();i++){
                for(int j=0;j <=str2.length();j++){
                    if(i==0 || j ==0){
                        lcs[i][j] =0;
                    } else if(str1.charAt(i-1) == str2.charAt(j-1)){
                        lcs[i][j] =1+lcs[i-1][j-1];
                    } else{
                        lcs[i][j] = Math.max(lcs[i][j-1],lcs[i-1][j]);
                    }
                }

            }
            return lcs[str1.length()][str2.length()];
        }else{
            return findLongestCommonSequenceUsingRecursion(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length());
        }


    }

    public static int findLongestCommonSequenceUsingRecursion(char[] chArr1, char[] chArr2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (chArr1[m - 1] == chArr2[n - 1]) {
            return 1 + findLongestCommonSequenceUsingRecursion(chArr1, chArr2, m - 1, n - 1);
        } else {
            return Math.max(findLongestCommonSequenceUsingRecursion(chArr1, chArr2, m, n - 1), findLongestCommonSequenceUsingRecursion(chArr1, chArr2, m - 1, n));
        }
    }

    public static void main(String[] args) {
        ;

        System.out.println("Length of LCS is" + " " + findLongestCommonSequence("AGGTAB", "GXTXAYB",false));
        System.out.println("Length of LCS is" + " " + findLongestCommonSequence("AGGTAB", "GXTXAYB",true));
    }
}
