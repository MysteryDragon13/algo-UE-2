package kapitel_3;

import kapitel_3.vl.SList;

public class Stack extends SList{
    public void push(Object data){
        head = new Node(data, head.next);
    }
    public Object pop(){
        Node temp = head;
        head=head.next;
        return temp.data;
    }
    public Object peek(){
        return head.data;
    }
    public boolean empty(){
        return head == null;
    }
}
