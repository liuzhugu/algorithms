package practice.interviewguide.tree;

import lombok.Data;

@Data
public class TreeNode {
    public TreeNode(int value) {
        this.value = value;
    }
    private TreeNode left;
    private TreeNode right;
    private int value;
}
