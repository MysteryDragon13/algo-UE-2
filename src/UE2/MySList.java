package UE2;

import kapitel_3.tests.Student;
import kapitel_3.tests.StudentKeys;
import kapitel_3.vl.IKey;
import kapitel_3.vl.ReferenceKey;
import kapitel_3.vl.SList;

public class MySList extends kapitel_3.vl.SList{

    void printL(){ //useful for me
        Node current=head;
        while(current != null ) {  // Iterate for all nodes
            System.out.println(current.data);
            System.out.println("-");
            current = current.next; // Not found! Jump to the next node.
        }

    }

    void append(Object data){
        Node current=head;
        while(current.next != null ) {  // Iterate for all nodes
            current = current.next; // Not found! Jump to the next node.
        }
        current.next= new Node(data, null);

    }

    boolean insert(Object prev, Object data){

        //search here
        Node current=head;
        if(current == null) {
            return false;
        }

        Node temp=current.next;
        current.next=new Node(data, temp);

        return true;

    }


    public static void main(String[] args) {

        //System.out.println("Hello world!");

        //ADS-3 pdf page 56
        MySList studentList = new MySList();

        Student student = new Student("Volker", "Christian", "MTD0100001");
        studentList.prepend(student);
        Student student1 = new Student("Albert", "Einstein", "MTD0100002");
        studentList.prepend(student1);
        student = new Student("Wolfgang", "Ambros", "MTD0100003");

        //studentList.prepend(student);
        studentList.append(student);

        boolean test=studentList.insert(
                student1
                ,new Student("Alberto", "Malich", "MTD0100004")
        );
        System.out.println(test);
        studentList.printL();

        /*
        StudentKeys.SurNameKey nameKey = new StudentKeys.SurNameKey("Einstein");
        student = (Student) studentList.search(nameKey);
        if (student != null) {
            System.out.println(student);
        }
        */






    }
}