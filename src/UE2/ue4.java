package UE2;

import kapitel_3.Queue;
import kapitel_3.vl.BTree;
import kapitel_3.vl.DList;
import kapitel_3.vl.SList;

class Stack extends SList {

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

//lowercase name so it doesnt clash with the proper version that is its own file (same code just copied)

class queue extends DList {

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
