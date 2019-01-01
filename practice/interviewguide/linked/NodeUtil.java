package practice.interviewguide.linked;

public class NodeUtil {

    public static Node buildNode(int[] nums){
        //tmpHead作为哨兵
        Node tmpHead=new Node(0);
        Node preNode=tmpHead;
        for(int num:nums){
            Node node=new Node(num);
            preNode.setNext(node);
            preNode=node;
        }
        return tmpHead.getNext();
    }

    public static void printNode(Node head){
        while(head!=null){
            System.out.print(" "+head.getValue()+" ");
            head=head.getNext();
        }
    }
}
