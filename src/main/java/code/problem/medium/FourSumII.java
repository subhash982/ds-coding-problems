package code.problem.medium;

import java.util.HashMap;

public class FourSumII {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer,Integer> firstSum = new HashMap <>();
        HashMap<Integer,Integer> secondSum = new HashMap <>();
        int count=0;
        for(int i=0 ;i < A.length;i++) {
            for (int j = 0; j < B.length; j++) {
                if(firstSum.get(A[i]+B[j])==null){
                    firstSum.put(A[i]+B[j],1);
                }else{
                    firstSum.put(A[i]+B[j],firstSum.get(A[i]+B[j])+1);
                }
            }
        }
        for(int i=0 ;i < C.length;i++) {
            for (int j = 0; j < D.length; j++) {
                if(secondSum.get(C[i]+D[j])==null){
                    secondSum.put(C[i]+D[j],1);
                }else{
                    secondSum.put(C[i]+D[j],secondSum.get(C[i]+D[j])+1);
                }
            }
        }

        for(Integer key :firstSum.keySet()){
            if(secondSum.get(-key)!=null){
                count=count+(firstSum.get(key) * secondSum.get(-key));
            }
        }
        return count;

    }
}
