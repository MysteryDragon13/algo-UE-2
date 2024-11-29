package UE2;

import kapitel_3.tests.Student;
import kapitel_3.tests.StudentKeys;
import kapitel_3.vl.IKey;
import kapitel_3.vl.ReferenceKey;
import kapitel_3.vl.SList;

/*
Lara Eck s2310238020
files to exclude: BTree, AVLTree,SearchTree
 */

public class MySList extends kapitel_3.vl.SList{

    void printL(){ //useful for me
        Node current=head;
        while(current != null ) {
            System.out.println(current.data);
            System.out.println("-");
            current = current.next;
        }

    }

    //Aufgabe 1
    void append(Object data){
        Node current=head;
        while(current.next != null ) {  // Iterate for all nodes
            current = current.next; // Not found! Jump to the next node.
        }
        current.next= new Node(data, null);

    }

    //Aufgabe 2
    boolean insert(Object prev, Object data){

        Node current=head;

        while(current.next != null ) {//goes through the whole list if nothing is found
            if(current.data.equals(prev)) {//checks if the node is the same
                //insterting
                Node temp=current.next;
                current.next=new Node(data, temp);
                //only inserts once
                return true;
            }
            current = current.next;
        }
        return false;

    }
    //Aufgabe 3
    SList searchAll(IKey key){
        SList list=new SList();
        Node current=search(head, key);//finds first match or null
        while(current != null ){
            list.prepend(current.data);
            current=search(current.next, key);
        }
        return list;
    }
    //I copied it and made it return a MySList so I can list it for testing
    MySList searchAll1(IKey key){
        MySList list=new MySList();
        Node current=search(head, key);//finds first match or null
        while(current != null ){
            list.prepend(current.data);
            current=search(current.next, key);
        }
        return list;
    }


    public static void main(String[] args) {

        //System.out.println("Hello world!");

        //ADS-3 pdf page 56
        MySList studentList = new MySList();

        Student student = new Student("Volker", "Christian", "MTD0100001");
        studentList.prepend(student);
        student = new Student("Albert", "Einstein", "MTD0100002");
        studentList.prepend(student);

        //aufgabe1
        student = new Student("Wolfgang", "Ambros", "MTD0100003");
        studentList.append(student);

        //aufgabe2
        StudentKeys.SurNameKey nameKey = new StudentKeys.SurNameKey("Christian");
        Student student1 = (Student) studentList.search(nameKey);

        boolean test=studentList.insert(
                student1
                ,new Student("Alberto", "Malich", "MTD0100004")
        );
        //System.out.println(test);
        //studentList.printL();

        //aufgabe3
        student = new Student("Alberto", "Einstein", "MTD0100005");
        studentList.prepend(student);
        StudentKeys.SurNameKey nameKey1 = new StudentKeys.SurNameKey("Einstein");

        //searchAll1 is the same as SearchAll (which works too) it just returns myslist instead of slist so I can print it for quick feedback
        MySList found=studentList.searchAll1(nameKey1);
        //found.printL();



        /*
        StudentKeys.SurNameKey nameKey = new StudentKeys.SurNameKey("Einstein");
        student = (Student) studentList.search(nameKey);
        if (student != null) {
            System.out.println(student);
        }
        */


    }
}