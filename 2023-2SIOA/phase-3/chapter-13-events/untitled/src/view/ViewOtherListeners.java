package view;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ViewOtherListeners extends JFrame{
    private JTextField txtTeste;
    private JComboBox<String> cmbTeste;

    public ViewOtherListeners() {
        super("Teste");
        setSize(300,300);
        setLayout(new FlowLayout());

        txtTeste = new JTextField(10);
        cmbTeste = new JComboBox<String>();
        cmbTeste.addItem("Item 1");
        cmbTeste.addItem("Item 2");
        cmbTeste.addItem("Item 3");
        cmbTeste.addItem("Item 4");

        KeyHandler keyHandler = new KeyHandler();
        ItemHandler itemHandler = new ItemHandler();

        txtTeste.addKeyListener(keyHandler);
        cmbTeste.addItemListener(itemHandler);
        add(txtTeste);
        add(cmbTeste);


    }

    public class ItemHandler implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent evento) {
            JOptionPane.showMessageDialog(null, "O item selecionado foi: " + evento.getItem());

        }

    }

    public class KeyHandler implements KeyListener{

        @Override
        public void keyPressed(KeyEvent evento) {
            JOptionPane.showMessageDialog(null, "A tecla pressionada foi : " + evento.getKeyChar() + " que tem o código " + evento.getKeyCode());

        }

        @Override
        public void keyReleased(KeyEvent arg0) {
            //Instruções para quando a tecla for solta

        }

        @Override
        public void keyTyped(KeyEvent arg0) {
            //Instruções para cada tecla digitada

        }

    }

    public static void main(String[] args) {
        ViewOtherListeners janela = new ViewOtherListeners();
        janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
        janela.setVisible(true);
    }

}