package view;
import model.Subject;
import java.util.Scanner;

public class ViewSubject {
    private Subject subject;

    private void showMenu(){
        int option = -1;
        Scanner sc = new Scanner(System.in);
        while (option != 3){
            System.out.println("You must choose an option.");
            System.out.println("1 - Create a new subject");
            System.out.println("2 - Show subject");
            System.out.println("3 - Quit");
            option = sc.nextInt();
            filterOption(option);
        }
    }

    private void filterOption(Integer option){
        switch (option) {
            case 1 -> createSubject();
            case 2 -> showSubject();
        }
    }

    private void createSubject(){
        Scanner sc = new Scanner(System.in);
        System.out.println("ID: ");
        subject.setId(Integer.parseInt(sc.nextLine()));
        System.out.println("Name: ");
        subject.setName(sc.nextLine());
        System.out.println("Workload: ");
        subject.setWorkload(Integer.parseInt(sc.nextLine()));
    }

    private void showSubject(){
        System.out.println("ID: " + subject.getId());
        System.out.println("Name: " + subject.getName());
        System.out.println("Workload: " + subject.getWorkload());
    }

    public static void main(String[] args) {
        ViewSubject window = new ViewSubject();
        window.subject = new Subject();
        window.showMenu();
        System.exit(0);
    }
}
