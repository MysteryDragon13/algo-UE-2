package kapitel_3;

import kapitel_3.vl.BTree;

public class MyBTree extends BTree{

    protected void breadthFirstAppend(Node newNode){
        //copied and edited breadthFirst
        Queue queue = new Queue();			       // The helper-queue

        if (root != null) {
            queue.enqueue(root);				   // Enqueue the root of the tree
        }else{
            root = newNode;
            return;
        }
        while (!queue.empty()) {                   // Iterate as long as queue is not empty
            Node current = (Node) queue.dequeue(); // Fetch a node from the queue
            if (current.left != null) {            // If the left child of this node exists
                queue.enqueue(current.left);       // enqueue this child
            }else{
                current.left = newNode;
                return;
            }
            if (current.right != null) {           // If the right child of the node exists
                queue.enqueue(current.right);      // enqueue it also
            }else{
                current.left = newNode;
                return;
            }
        }

    }
    public void insert(Object data) {
        //copied and edited breadthFirstAppend
        Node newNode = new Node(null, data, null);
        breadthFirstAppend(newNode);
    }

    protected void remove(Node node){
        
    }
    public void remove(Object data){

    }








}

