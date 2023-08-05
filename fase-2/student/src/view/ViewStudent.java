package view;
import model.Address;
import model.Student;
import java.util.Scanner;
public class ViewStudent {
    private Student student;

    private void showMenu(){
        int option = -1;
        Scanner sc = new Scanner(System.in);
        while (option != 3){
            System.out.println("You must choose an option:");
            System.out.println("1 - Create a new student");
            System.out.println("2 - Show a student");
            System.out.println("3 - Quit");
            option = sc.nextInt();
            filterOption(option);
        }
    }

    private void filterOption(Integer option){
        switch (option){
            case 1 -> createStudent();
            case 2 -> showStudent();
        }
    }

    private void createStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.println("RM:");
        student.setRm(Integer.parseInt(sc.nextLine()));
        System.out.println("Name:");
        student.setName(sc.nextLine());
        System.out.println("Email:");
        student.setEmail(sc.nextLine());
        System.out.println("Address: (street, number, zip, city and state)");
        student.setAddress(new Address(sc.nextLine(), Integer.parseInt(sc.nextLine()), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        System.out.println("CPF:");
        student.setCpf(sc.nextLine());
        System.out.println("RG:");
        student.setRg(sc.nextLine());
    }

    private void showStudent(){
        System.out.println("RM: " + student.getRm());
        System.out.println("Name: " + student.getName());
        System.out.println("Email: " + student.getEmail());
        System.out.println("Address: " + student.getAddress());
        System.out.println("CPF: " + student.getCpf());
        System.out.println("RG: " + student.getRg());
    }

    public static void main(String[] args) {
        ViewStudent window = new ViewStudent();
        window.student = new Student();
        window.showMenu();
        System.exit(0);
    }
}
