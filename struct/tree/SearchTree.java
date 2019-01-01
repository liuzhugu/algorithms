package struct.tree;

public class SearchTree {

    //先序
    public static void preOrder(Node root){
        if(root==null)return;

        print(root);
        if(root.getLeft()!=null){
            preOrder(root.getLeft());
        }
        if(root.getRight()!=null){
            preOrder(root.getRight());
        }
    }

    //中序
    public static void inOrder(Node root){
        if(root==null)return;

        if(root.getLeft()!=null){
            inOrder(root.getLeft());
        }

        print(root);

        if(root.getRight()!=null){
            inOrder(root.getRight());
        }
    }

    //后序
    public static void postOrder(Node root){
        if(root==null)return;

        if(root.getLeft()!=null){
            postOrder(root.getLeft());
        }

        if(root.getRight()!=null){
            postOrder(root.getRight());
        }
        print(root);
    }

    public static void print(Node node){
        System.out.println("现在访问的节点的值是:"+node.getData());
    }
}
