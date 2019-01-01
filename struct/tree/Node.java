package struct.tree;

import lombok.Data;

@Data
public class Node {

    private int data;

    private Node left;

    private Node right;

    public Node(int data){
        this.data=data;
    }
}
