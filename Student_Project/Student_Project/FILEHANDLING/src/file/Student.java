package file;

import java.io.Serializable;

public class Student implements Serializable {
int id;
String name;
double marks;


public Student(int id, String name, double marks) {
    this.id = id;
    this.name = name;
    this.marks = marks;
}

public String toString() {
    return id + " " + name + " " + marks;
}

}
