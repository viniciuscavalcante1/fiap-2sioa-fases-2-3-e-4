package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ViewEvents extends JFrame{
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JTextField txtUsername;
    private JPasswordField pwdPassword;
    private JButton btnLogin;
    private JButton btnExit;

    public ViewEvents(){
        super("Login");
        this.setLayout(new GridBagLayout());
        this.setSize(250,200);

        lblUsername = new JLabel("Username: ");
        lblPassword = new JLabel("Password: ");
        txtUsername = new JTextField(10);
        pwdPassword = new JPasswordField(10);
        btnLogin = new JButton("Login");
        btnExit = new JButton("Exit");

        //Criação de um objeto do tipo handler
        Handler handler = new Handler();
        //Agora, quem manipulará os eventos não é mais a própria classe, mas o handler que adicionamos
        pwdPassword.addActionListener(handler);
        btnLogin.addActionListener(handler);
        btnExit.addActionListener(handler);

        GridBagConstraints posicoes = new GridBagConstraints();
        posicoes.insets = new Insets(3,0,3,0);
        posicoes.anchor = posicoes.LINE_START;
        posicoes.gridx = 0;
        posicoes.gridy = 0;
        add(lblUsername, posicoes);
        posicoes.gridx = 1;
        posicoes.gridy = 0;
        add(txtUsername, posicoes);
        posicoes.gridx = 0;
        posicoes.gridy = 1;
        add(lblPassword, posicoes);
        posicoes.gridx = 1;
        posicoes.gridy = 1;
        add(pwdPassword, posicoes);
        posicoes.gridx = 0;
        posicoes.gridy = 2;
        add(btnLogin, posicoes);
        posicoes.gridx = 1;
        posicoes.gridy = 2;
        add(btnExit, posicoes);

    }
    //início da classe aninhada
    public class Handler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evento) {
            if(evento.getSource() == btnExit)
                System.exit(0);
            else if(evento.getSource() == btnLogin || evento.getSource() == pwdPassword) {
                String username = txtUsername.getText();
                String password = new String(pwdPassword.getPassword());
                if(username.equals("admin") && password.equals("admin"))
                    JOptionPane.showMessageDialog(null, "Login realizado!");
                else
                    JOptionPane.showMessageDialog(null, "Login inválido!");
            }
        }
    }

    public static void main(String[] args) {
        ViewEvents janela = new ViewEvents();
        janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
        janela.setVisible(true);

    }

}