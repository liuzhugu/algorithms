package leetcode.editor.cn;

import tool.Transform;

public class QueryString {
    public boolean queryString(String S, int N) {
       for(int i = 1;i <= N;i ++) {
            if (!S.contains(Transform.toBinaryString(i))){
                return false;
            }
        }
        return true;
    }

}
