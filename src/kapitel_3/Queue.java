package kapitel_3;

import kapitel_3.vl.DList;

public class Queue extends DList {

    public void enqueue(Object data) {
        if(head == null){
            head = new Node(null,data, null);
            tail=head;
        }else{
            Node temp=tail;
            tail=new Node(null,data,temp);
        }
    }
    public Object dequeue(){
        head=head.next;
        return head.data;
    }
    public Object peek(){
        return head.data;
    }
    public boolean empty(){
        return head == null;
    }

}