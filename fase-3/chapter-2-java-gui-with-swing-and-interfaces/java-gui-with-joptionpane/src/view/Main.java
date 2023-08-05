package view;
import javax.swing.JOptionPane;
public class Main {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Hello World!", "Welcome Message", JOptionPane.INFORMATION_MESSAGE);
        int option;
        option = JOptionPane.showConfirmDialog(null, "Do you want to continue?",
                "Confirmation", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "You've chosen to continue.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "You've chosen to exit.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}