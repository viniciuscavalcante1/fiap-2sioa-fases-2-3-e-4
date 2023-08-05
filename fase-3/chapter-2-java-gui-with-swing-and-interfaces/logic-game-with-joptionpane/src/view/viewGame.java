package view;
import javax.swing.JOptionPane;
import model.Player;

public class viewGame {
    public boolean startGame(){
        Player player = new Player();
        int option;

        // Show a screen requesting player name
        player.setName(JOptionPane.showInputDialog(null, "What's your name?",
                "Logic Game", JOptionPane.QUESTION_MESSAGE));

        // Show a screen requesting player age and convert it to integer
        player.setAge(Integer.parseInt(JOptionPane.showInputDialog(null,
                "How old are you?", "Logic Game", JOptionPane.QUESTION_MESSAGE)));

        JOptionPane.showMessageDialog(null, "Hello " + player.getName() + "! You're "
                        + player.getAge() + " years old, right?", "Logic Game", JOptionPane.INFORMATION_MESSAGE);
        option = JOptionPane.showConfirmDialog(null, "Do you want to start the game?", "Logic Game",
                JOptionPane.YES_NO_OPTION);

        return option == JOptionPane.YES_OPTION;
    }

    public boolean makeQuestion() {
        String[] options = {"Friday", "Saturday", "Sunday", "John"};
        int answer;
        answer = JOptionPane.showOptionDialog(null, "John's parents have five children... " +
                "Monday, Tuesday, Wednesday, Thursday... What is the name of the sixth one?","Logic Challenge",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (answer == 3) {
            JOptionPane.showMessageDialog(null, "Congratulations! You're right!", "Logic Challenge",
                    JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Sorry, you're wrong!", "Logic Challenge",
                    JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }
    public static void main(String[] args) {
        viewGame view = new viewGame();
        if (view.startGame()) {
            JOptionPane.showMessageDialog(null, "Let's start the game!", "Logic Game",
                    JOptionPane.INFORMATION_MESSAGE);
            if (view.makeQuestion()) {
                JOptionPane.showMessageDialog(null, "Congratulations! You won the game!", "Logic Game",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Sorry, you lost the game!", "Logic Game",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ok, see you later!", "Logic Game",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
