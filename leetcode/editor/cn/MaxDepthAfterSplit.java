package leetcode.editor.cn;


/**
 * Created by liuzhugu on 2019/04/01.
 * 1111. 有效括号的嵌套深度
 * 给你一个整数数组 nums，请你将该数组升序排列。
 */
public class MaxDepthAfterSplit {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int index = 0;
        for (char c : seq.toCharArray()) {
            //连续的(应该被分配到不同组  来使得深度平衡
            //因为加入最大深度为n 要要使分配后的深度a和b中较大者最小(a + b <= n)
            //那么a和b尽可能平衡,所以连续的(被分配到不同组去的话  那么最大深度也相对平衡了
            ans[index ++] = c == '(' ? index & 1 : (index + 1) & 1;
        }
        return ans;
    }
}
