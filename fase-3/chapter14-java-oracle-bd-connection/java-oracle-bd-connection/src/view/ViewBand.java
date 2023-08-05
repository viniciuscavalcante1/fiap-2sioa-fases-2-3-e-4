package view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import dao.BandDAO;
import model.Band;

public class ViewBand extends JFrame implements ActionListener {
    // JLabels to indicate what each field is for
    private JLabel lblId;
    private JLabel lblName;
    private JLabel lblGenre;

    // JTextFields to get the data from the user
    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtGenre;

    // JButtons to perform the actions
    private JButton btnInsert;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnSearch;

    // JPanels to organize the components
    private JPanel pnlForm;
    private JPanel pnlButtons;

    // Attributes to store data from the bands and manipulate the database
    private Band band;
    private BandDAO bandDAO;

    // Constructor
    public ViewBand() {
        // Setting the title of the window
        super("Bands");
        // Setting layout configs
        this.setLayout(new BorderLayout());
        this.setSize(400, 200);
        // Panel configs
        pnlButtons = new JPanel(new FlowLayout());
        pnlForm = new JPanel(new GridBagLayout());
        // Instantiating JLabels, JTextFields and positioning them using GridBagLayout()
        GridBagConstraints positions = new GridBagConstraints();
        positions.insets = new Insets(3,3,3,3);
        positions.anchor = positions.LINE_START;
        positions.gridx = 0;
        positions.gridy = 0;
        lblId = new JLabel("Id:");
        pnlForm.add(lblId, positions);
        positions.gridx = 0;
        positions.gridy = 1;
        lblName = new JLabel("Name:");
        pnlForm.add(lblName, positions);
        positions.gridx = 0;
        positions.gridy = 2;
        lblGenre = new JLabel("Genre:");
        pnlForm.add(lblGenre, positions);

        positions.anchor = positions.LINE_END;
        positions.gridx = 1;
        positions.gridy = 0;
        txtId = new JTextField(10);
        pnlForm.add(txtId, positions);
        positions.gridx = 1;
        positions.gridy = 1;
        txtName = new JTextField(10);
        pnlForm.add(txtName, positions);
        positions.gridx = 1;
        positions.gridy = 2;
        txtGenre = new JTextField(10);
        pnlForm.add(txtGenre, positions);

        // Instantiating JButtons and adding them to the panel with ActionListeners
        btnInsert = new JButton("Insert");
        btnInsert.addActionListener(this);
        pnlButtons.add(btnInsert);
        btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(this);
        pnlButtons.add(btnUpdate);
        btnDelete = new JButton("Delete");
        btnDelete.addActionListener(this);
        pnlButtons.add(btnDelete);
        btnSearch = new JButton("Search");
        btnSearch.addActionListener(this);
        pnlButtons.add(btnSearch);

        // Adding the panels to the window
        this.add(pnlForm, BorderLayout.CENTER);
        this.add(pnlButtons, BorderLayout.SOUTH);

        // Instantiating the band and bandDAO objects
        band = new Band();
        bandDAO = new BandDAO();
    }

    // Method that will be called when the user clicks on a button
    @Override
    public void actionPerformed(ActionEvent e) {
        // If the user clicks on the Insert button
        if (e.getSource() == btnInsert) {
            // Setting the attributes of the band object
            band.setName(txtName.getText());
            band.setGenre(txtGenre.getText());
            // Calling the insert method from the bandDAO object
            bandDAO.insert(band);
        }
        // If the user clicks on the Update button
        if (e.getSource() == btnUpdate) {
            // Setting the attributes of the band object
            band.setId(Integer.parseInt(txtId.getText()));
            band.setName(txtName.getText());
            band.setGenre(txtGenre.getText());
            // Calling the update method from the bandDAO object
            bandDAO.update(band);
        }
        // If the user clicks on the Delete button
        if (e.getSource() == btnDelete) {
            // Setting the attributes of the band object
            band.setId(Integer.parseInt(txtId.getText()));
            // Calling the delete method from the bandDAO object
            bandDAO.delete(band);
        }
        // If the user clicks on the Search button
        if (e.getSource() == btnSearch) {
            // Setting the attributes of the band object
            band.setId(Integer.parseInt(txtId.getText()));
            // Calling the search method from the bandDAO object
            bandDAO.search(band);
            // Setting the attributes of the band object
            txtName.setText(band.getName());
            txtGenre.setText(band.getGenre());
        }
    }

    public static void main(String[] args) {
        ViewBand viewBand = new ViewBand();
        viewBand.setVisible(true);
        viewBand.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
