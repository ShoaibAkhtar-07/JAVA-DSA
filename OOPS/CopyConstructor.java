package OOPS;

public class CopyConstructor {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "shoaib";
        s1.rollNo = 1;
        s1.password = "adcs";
        s1.marks[0] = 100;
        s1.marks[1] = 90;
        s1.marks[2] = 80;

        Student s2 = new Student(s1);
        s2.password = "amkmm";
        s1.marks[2] = 1000;

        for (int i = 0; i < s2.marks.length; i++) {
            System.out.println(s2.marks[i]);
        }
    }
}

class Student {
    String name;
    int rollNo;
    int marks[];
    String password;

    // //Shallow copy
    // Student(Student s1) {
    // this.marks = new int[3];
    // this.name = s1.name;
    // this.rollNo = s1.rollNo;
    // this.marks = s1.marks;
    // }

    // Deep copy
    Student(Student s1) {
        this.marks = new int[3];
        this.name = s1.name;
        this.rollNo = s1.rollNo;
        for (int i = 0; i < marks.length; i++) {
            this.marks[i] = s1.marks[i];
        }
    }

    Student() {
        System.out.println("--constructor is called---");
        this.marks = new int[3];
    }

    Student(String name) {
        this.name = name;
        this.marks = new int[3];
    }

    Student(int rollNo) {
        this.rollNo = rollNo;
        this.marks = new int[3];
    }
}
