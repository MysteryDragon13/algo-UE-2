package kapitel_3;

import kapitel_3.vl.IComparator;
import kapitel_3.vl.IKey;

public class Heap extends MyBTree{
    IComparator comparator=null;//-1=<  1=>
    public Heap(IComparator comparator) {
        this.comparator = comparator;
    }

    protected void upHeap(Node leaf){
        Object leafdata=leaf.data;
        Object parentdata=leaf.parent.data;

        //if(leaf.isLeftChild() && )


        while(comparator.compare(leafdata,parentdata)<=1){//assumes its way left!! fix!!
            leaf.parent.data=leafdata;
            leaf.data=parentdata;
        }

    }
    public void insert(Object data){
        Node newNode = new Node(null, data, null);
        breadthFirstAppend(newNode);
        //couldn't just use super because I need the newnode
        upHeap(newNode);

    }

    public void remove(Object data){

    }
    protected Node heapSearch(Node current, IKey Key){
        //copied and edited
        Node foundNode = null;

        while (current != null) {
            if (Key.matches(current.data)) {
                foundNode = current;
            } else {
                if(comparator.compare(current.data,Key)<0){}
            }
        }


        return foundNode;
    }
    public Object heapSearch(IKey key){
        return null;
    }
    protected void downHeap(Node node){

    }








}
