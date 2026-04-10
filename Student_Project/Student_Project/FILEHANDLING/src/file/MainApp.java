package file;

import java.util.*;

public class MainApp {

static Scanner sc = new Scanner(System.in);

public static void main(String[] args) {

    while (true) {
    	System.out.println("\n1 Add Student");
    	System.out.println("2 View Students");
    	System.out.println("3 Search Student");
    	System.out.println("4 Update Student");
    	System.out.println("5 Delete Student");
    	System.out.println("6 Topper");
    	System.out.println("7 Export to File");
    	System.out.println("8 Exit");
    	System.out.println("Enter Your Choice : ");

        int ch = sc.nextInt();

        switch (ch) {
        case 1: addStudent(); break;
        case 2: viewStudents(); break;
        case 3: searchStudent(); break;
        case 4: updateStudent(); break;
        case 5: deleteStudent(); break;
        case 6: showTopper(); break;
        case 7: exportToTextFile(); break;
        case 8: System.exit(0);
        }

    }
}



static void addStudent() {
    ArrayList<Student> list = FileHandler.readStudents();

    System.out.print("Enter ID: ");
    int id = sc.nextInt();

    for (Student s : list) {
        if (s.id == id) {
            System.out.println("Duplicate ID");
            return;
        }
    }

    sc.nextLine();
    System.out.print("Enter Name: ");
    String name = sc.nextLine();

    System.out.print("Enter Marks: ");
    double marks = sc.nextDouble();

    list.add(new Student(id, name, marks));
    FileHandler.writeStudents(list);

    System.out.println("Student Added");
}

static void viewStudents() {
    ArrayList<Student> list = FileHandler.readStudents();

    for (Student s : list) {
        System.out.println(s);
    }
}

static void searchStudent() {
    ArrayList<Student> list = FileHandler.readStudents();

    System.out.print("Enter ID: ");
    int id = sc.nextInt();

    for (Student s : list) {
        if (s.id == id) {
            System.out.println(s);
            return;
        }
    }

    System.out.println("Not Found");
}

static void updateStudent() {
    ArrayList<Student> list = FileHandler.readStudents();

    System.out.print("Enter ID: ");
    int id = sc.nextInt();

    for (Student s : list) {
        if (s.id == id) {
            sc.nextLine();
            System.out.print("Enter New Name: ");
            s.name = sc.nextLine();

            System.out.print("Enter New Marks: ");
            s.marks = sc.nextDouble();

            FileHandler.writeStudents(list);
            System.out.println("Updated");
            return;
        }
    }

    System.out.println("Not Found");
}

static void deleteStudent() {
    ArrayList<Student> list = FileHandler.readStudents();

    System.out.print("Enter ID: ");
    int id = sc.nextInt();

    Iterator<Student> it = list.iterator();

    while (it.hasNext()) {
        Student s = it.next();
        if (s.id == id) {
            it.remove();
            FileHandler.writeStudents(list);
            System.out.println("Deleted");
            return;
        }
    }

    System.out.println("Not Found");
}

static void showTopper() {
ArrayList<Student> list = FileHandler.readStudents();


if (list.size() == 0) {
    System.out.println("No Students Found");
    return;
}

Student topper = list.get(0);

for (Student s : list) {
    if (s.marks > topper.marks) {
        topper = s;
    }
}

System.out.println("Topper:");
System.out.println(topper);


}

static void exportToTextFile() {
ArrayList<Student> list = FileHandler.readStudents();


try {
    java.io.PrintWriter pw = new java.io.PrintWriter("students.txt");

    for (Student s : list) {
        pw.println(s.id + " " + s.name + " " + s.marks);
    }

    pw.close();
    System.out.println("Exported to students.txt");
} catch (Exception e) {
    System.out.println("Error");
}


}

}
