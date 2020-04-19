package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character,Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        int result = 0;
        boolean flag = false;
        for (Map.Entry<Character,Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                result = result + entry.getValue();
            } else {
                result = result + entry.getValue() - 1;
                flag = true;
            }
        }
        if (flag) {
            result = result + 1;
        }
        return result;
    }
}
