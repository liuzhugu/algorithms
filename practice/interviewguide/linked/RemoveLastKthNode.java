package practice.interviewguide.linked;

public class RemoveLastKthNode {

    public Node remove(Node head,int lastKth){
        if(head==null||lastKth<1){
            return head;
        }
        Node current=head;
        while(current!=null){
            current=current.getNext();
            lastKth--;
        }
        if(lastKth==0){
            head=head.getNext();
        }
        if(lastKth<0){
            current=head;
            while(++lastKth!=0){
                current=current.getNext();
            }
            current.setNext(current.getNext().getNext());
        }
        return head;
    }

    public DoubleNode remove(DoubleNode head,int lastKth){
        if(head==null||lastKth<1){
            return head;
        }

        DoubleNode current=head;
        while (current!=null){
            current=current.getNext();
            lastKth--;
        }

        if(lastKth==0){
            head=head.getNext();
        }
        if(lastKth<0){
            current=head;
            while(++lastKth!=0){
                current=current.getNext();
            }
            current.setNext(current.getNext().getNext());
            if(current.getNext()!=null){
                current.getNext().setPre(current);
            }
        }
        return head;
    }
}
