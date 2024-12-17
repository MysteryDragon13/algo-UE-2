package kapitel_3;

import kapitel_3.vl.DList;

public class priorityQueue{
    //low number means high priority
    protected Node head = null; // The head of the list.
    protected Node tail = null; // The tail of the list.

    protected static class Node { // Double chained nodes - a recursive data structure.
        public Node next = null;          // Reference to the next node.
        public Node prev = null;		  // Reference to the previous node.
        public Object data = null;		  // Reference to the stored data set.
        public int priority=0;

        public Node(Node prev, Object data, Node next,int priority) { // Construct a new node by
            this.data = data;					         // storing the data set,
            this.next = next;					         // and refer the next and
            this.prev = prev;					         // previous node.
            this.priority = priority;
        }
    }

    public void insert(Object data, int priority){
        Node current=head;
        while(current!=null && current.priority<priority){
            current=current.next;
        }
        tail=new Node(null,data,current,priority);
    }
    public Object extractMin(){//deque from queue:
        head=head.next;
        return head.data;
    }


}
