package Repaso1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

public class Repaso1 {

    private JFrame frame;
    private JTextField tfEdad;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Repaso1 window = new Repaso1();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Repaso1() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 5, 100);
        frame.getContentPane().setLayout(flowLayout);

        // Cambiar tamaño del JLabel
        JLabel lblEdad = new JLabel("Edad");
        lblEdad.setHorizontalAlignment(SwingConstants.CENTER);
        lblEdad.setPreferredSize(new Dimension(50, 25)); // Anchura 50, altura 25
        lblEdad.setFont(new Font("Arial", Font.PLAIN, 12)); // Cambiar tamaño de la fuente
        frame.getContentPane().add(lblEdad);

        // Cambiar tamaño del JTextField
        tfEdad = new JTextField();
        tfEdad.setPreferredSize(new Dimension(50, 25)); // Ajustar tamaño del campo de texto
        tfEdad.setFont(new Font("Arial", Font.PLAIN, 12)); // Cambiar tamaño de la fuente
        frame.getContentPane().add(tfEdad);
        tfEdad.setColumns(10);

        // Añadir funcionalidad al JTextField
        tfEdad.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
            	Integer numero = null;
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    if (tfEdad.getText().isEmpty()) {
                        tfEdad.setText("0");
                    }
                    String lblString = tfEdad.getText();
                    numero = Integer.parseInt(lblString);
                    numero = numero + 1;
                    tfEdad.setText(numero.toString());
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (tfEdad.getText().isEmpty()) {
                        tfEdad.setText("1");
                    }
                    String lblString = tfEdad.getText();
                    numero = Integer.parseInt(lblString);
                    if (numero > 1) {
                        numero = numero - 1;
                        tfEdad.setText(numero.toString());
                    }
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
                if (Character.isLetter(e.getKeyChar())) {
                    e.consume();
                }
            }
        });
    }
}
