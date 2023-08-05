package view;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;


public class ViewGUI extends JFrame {

    public ViewGUI() {
        // Using the constructor of the superclass JFrame to set the title of the window.
        super("Hello, my dear world. I'm a window. I'm a JFrame. I'm a ViewGUI. And I'm a View.");

        // Using the method setLayout() to set the layout of the window.
        setLayout(new FlowLayout());

        // Using the method setSize() to set the size of the window.
        setSize(500, 300);

        // Instantiating the panels of the window and setting their layouts managers.
        JPanel panelForm = new JPanel(new GridBagLayout());
        JPanel panelButtons = new JPanel(new FlowLayout());

        // Creating the constraints for the GridBagLayout as positions variable.
        GridBagConstraints positions = new GridBagConstraints();

        // Defining the insets, which are the distances between the components.
        positions.insets = new Insets(3, 0, 3, 0);

        // Defining alignment of the components to the left
        positions.anchor = positions.LINE_START;

        // Defining the position of label for the name of the user in the grid.
        positions.gridx = 0;
        positions.gridy = 0;

        // Creating label for the name of the user and adding it in 0,0 position.
        JLabel labelUserName = new JLabel("Name: ");
        panelForm.add(labelUserName, positions);

        // Defining the position of label for the email of the user in the grid.
        positions.gridx = 0;
        positions.gridy = 1;

        // Creating label for the email of the user and adding it in 0,1 position.
        JLabel labelUserEmail = new JLabel("Email: ");
        panelForm.add(labelUserEmail, positions);

        // Defining the position of label for the civil status of the user in the grid.
        positions.gridx = 0;
        positions.gridy = 2;

        // Creating label for the civil status of the user and adding it in 0,2 position.
        JLabel labelUserCivilStatus = new JLabel("Civil Status: ");
        panelForm.add(labelUserCivilStatus, positions);

        // Defining the position of label for the interests of the user in the grid.
        positions.gridx = 0;
        positions.gridy = 3;

        // Creating label for the interests of the user and adding it in 0,3 position.
        JLabel labelUserInterests = new JLabel("Interests: ");
        panelForm.add(labelUserInterests, positions);

        // Defining alignment of the components to the right
        positions.anchor = positions.LINE_END;

        // Defining the position of the text field for the name of the user in the grid.
        positions.gridx = 1;
        positions.gridy = 0;

        // Creating text field for the name of the user and adding it in 1,0 position.
        JTextField textUserName = new JTextField(20);
        panelForm.add(textUserName, positions);

        // Defining the position of the text field for the email of the user in the grid.
        positions.gridx = 1;
        positions.gridy = 1;

        // Creating text field for the email of the user and adding it in 1,1 position.
        JTextField textUserEmail = new JTextField(20);
        panelForm.add(textUserEmail, positions);

        // Defining the position of the combo box for the civil status of the user in the grid.
        positions.gridx = 1;
        positions.gridy = 2;

        // Creating combo box for the civil status of the user and adding it in 1,2 position.
        JComboBox<String> comboBoxUserCivilStatus = new JComboBox<String>();
        comboBoxUserCivilStatus.addItem("Single");
        comboBoxUserCivilStatus.addItem("Married");
        comboBoxUserCivilStatus.addItem("Divorced");
        comboBoxUserCivilStatus.addItem("Widowed");
        panelForm.add(comboBoxUserCivilStatus, positions);

        // Defining the position of the list for the interests of the user in the grid.
        positions.gridx = 1;
        positions.gridy = 3;

        // Creating list for the interests of the user and adding it in 1,3 position.
        String[] interests = {"Sports", "Music", "Movies", "Reading", "Traveling"};
        JList<String> listUserInterests = new JList<String>(interests);
        panelForm.add(listUserInterests, positions);

        // Defining how many columns will have
        positions.gridwidth = 2;

        // Defining alignment to the center
        positions.anchor = positions.CENTER;

        // Defining positions for the newsletter check box
        positions.gridx = 0;
        positions.gridy = 4;

        // Creating check box for the newsletter and adding it in 0,4 position with 2 columns.
        JCheckBox newsletter = new JCheckBox("I want to receive the newsletter.");
        panelForm.add(newsletter, positions);

        // Starting button Submit
        JButton buttonSubmit = new JButton("Submit");

        // Adding the panels to the window.
        panelButtons.add(buttonSubmit);

        // Adding the panels to the window.
        JButton buttonClear = new JButton("Clear");
        panelButtons.add(buttonClear);

        // Adding the panels to the window.
        add(panelForm);
        add(panelButtons);
    }
    public static void main(String[] args) {
        ViewGUI window = new ViewGUI();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}