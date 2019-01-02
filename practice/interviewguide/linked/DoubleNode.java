package practice.interviewguide.linked;

import lombok.Data;

@Data
public class DoubleNode {

    private DoubleNode pre;
    private DoubleNode next;
    private int value;
    public DoubleNode(int value){
        this.value=value;
    }
}
