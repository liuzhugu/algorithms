package practice.interviewguide.linked;

public class PrintCommonPart {

    public static void print(Node first,Node second){
        if(first==null||second==null){
            return;
        }

        while(first!=null&&second!=null){
            if(first.getValue()==second.getValue()){
                System.out.print(" "+first.getValue()+" ");
                first=first.getNext();
                second=second.getNext();
            }else if(first.getValue()>second.getValue()){
                second=second.getNext();
            }else {
                first=first.getNext();
            }
        }
    }
}
