package UE2;

import kapitel_3.tests.Student;
import kapitel_3.tests.StudentKeys;
import kapitel_3.vl.SList;

public class MySList extends kapitel_3.vl.SList{

    void append(Object data){
        Node current=head;
        while(current != null ) {  // Iterate for all nodes
            // in the list but interrupt if the object is found.
            current = current.next; // Not found! Jump to the next node.
        }

    }


    public static void main(String[] args) {

        //System.out.println("Hello world!");

        //ADS-3 pdf page 56
        SList studentList = new SList();

        Student student = new Student("Volker", "Christian", "MTD0100001");
        studentList.prepend(student);
        student = new Student("Albert", "Einstein", "MTD0100002");
        studentList.prepend(student);
        student = new Student("Wolfgang", "Ambros", "MTD0100003");
        studentList.prepend(student);

        /*
        StudentKeys.SurNameKey nameKey = new StudentKeys.SurNameKey("Einstein");
        student = (Student) studentList.search(nameKey);
        if (student != null) {
            System.out.println(student);
        }
        */






    }
}