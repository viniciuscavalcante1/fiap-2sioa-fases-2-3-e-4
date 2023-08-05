package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import model.Student;
import model.StudentPostGraduate;

public class Main {
    public static void main(String[] args) {
        var students = new ArrayList<Student>();
        var sc = new Scanner(System.in);
        int option = -1;
        while(option != 0){
            System.out.println("Add student name:");
            String name = sc.nextLine();

            System.out.println("Add student rm:");
            int rm = sc.nextInt();

            System.out.println("Add student school:");
            String school = sc.nextLine();

            StudentPostGraduate student = new StudentPostGraduate(rm, name, school);
            students.add(student);

            System.out.println("Add another student? 1 - Yes, 0 - No");
            option = sc.nextInt();
        }

        Collections.sort(students);

        for (Student student : students) {
            System.out.println(student);
        }

    }
}