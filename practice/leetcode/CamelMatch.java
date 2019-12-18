package practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CamelMatch {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        boolean[] result = new boolean[queries.length];
        int index = 0;
        i:for (String str : queries) {
            int i = 0,j = 0;
            while (i < str.length() && j < pattern.length()) {
                if (str.charAt(i) - 'a' < 0 || str.charAt(i) - 'z' > 26){
                    if (str.charAt(i) == pattern.charAt(j)) {
                        i ++;
                        j ++;
                    }else {
                        result[index ++] = false;
                        continue i;
                    }
                }else {
                    if (str.charAt(i) == pattern.charAt(j)) {
                        i ++;
                        j ++;
                    }else {
                        i ++;
                    }
                }
            }
            if (j == pattern.length()) {
                result[index++] = true;
                if (i < str.length()){
                    while (i < str.length()) {
                        if (str.charAt(i) - 'a' < 0 || str.charAt(i) - 'z' > 26) {
                            result[index ++] = false;
                        }
                        i ++;
                    }
                }
            }else {
                result[index++] = false;
            }
        }
        List<Boolean> results = new ArrayList<>();
        for (boolean b : result) {
            results.add(b);
        }
        return results;
    }
}
