package practice.interviewguide.linked;

public class LinkedTest {

    public static void main(String[] args){
        //打印链表公共部分
        int[] first=new int[]{1,3,5,7,9,222,36,78,9,0};
        int[] second=new int[]{1,3,7,9,222,36,78,9,0};
        Node firstNode=NodeUtil.buildNode(first);
        Node secondNode=NodeUtil.buildNode(second);
        PrintCommonPart.print(firstNode,secondNode);
    }
}
