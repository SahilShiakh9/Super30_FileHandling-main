package file;

import java.io.*;
import java.util.*;

public class FileHandler {


static final String FILE_NAME = "students.dat";

public static ArrayList<Student> readStudents() {
    ArrayList<Student> list = new ArrayList<>();
    try {
        File file = new File(FILE_NAME);
        if (!file.exists()) return list;

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        list = (ArrayList<Student>) ois.readObject();
        ois.close();
    } catch (Exception e) {}
    return list;
}

public static void writeStudents(ArrayList<Student> list) {
    try {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
        oos.writeObject(list);
        oos.close();
    } catch (Exception e) {}
}


}
