package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. Restore IP Addresses
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * <p>
 * Example:
 * <p>
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 */
public class RestoreIPAddresses {
    public List <String> restoreIpAddresses(String s) {
        List <String> result = new ArrayList <>();
        int length = s.length();
        for (int i = 1; i < length && i < 4; i++) {
            String first = s.substring(0, i);
            if (!isValid(first)) {
                continue;
            }
            for (int j = 1; i + j < length && j < 4; j++) {
                String second = s.substring(i, i+j);
                if (!isValid(second)) {
                    continue;
                }
                for(int k=1;i+j+k < length && k <4;k++){
                    String third = s.substring(i+j, i+j+k);
                    String fourth = s.substring(i+j+k);
                    if(!isValid(third) || !isValid(fourth)){
                        continue;
                    }
                    result.add(first+"."+second+"."+third+"."+fourth);

                }
            }

        }

        return result;

    }

    public boolean isValid(String s) {
        if (s.length() > 3) {
            return false;
        }
        if (s.startsWith("0") && s.length() > 1) {
            return false;
        }
        int val = Integer.parseInt(s);
        return val >= 0 && val <= 255;
    }
}
