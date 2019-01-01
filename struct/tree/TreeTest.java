package struct.tree;

public class TreeTest {

    public static void main(String[] args){
        Node root=new Node(4);

        Node left=new Node(2);
        root.setLeft(left);
        Node leftLeft=new Node(1);
        Node leftRight=new Node(3);
        left.setLeft(leftLeft);
        left.setRight(leftRight);

        Node right=new Node(6);
        root.setRight(right);
        Node rightLeft=new Node(5);
        Node rightRight=new Node(7);
        right.setLeft(rightLeft);
        right.setRight(rightRight);


        //先序访问
        //SearchTree.preOrder(root);
        //中序访问
        //SearchTree.inOrder(root);
        //后序访问
        SearchTree.postOrder(root);
    }
}
