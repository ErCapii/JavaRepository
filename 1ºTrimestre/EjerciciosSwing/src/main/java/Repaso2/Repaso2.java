package Repaso2;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Repaso2 {

	private JFrame frame;
	private JTextField tfEdad;
	private JCheckBox JCheckCondiciones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Repaso2 window = new Repaso2();
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
	public Repaso2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JCheckBox JCheckCondiciones_1 = new JCheckBox("Acepto la política de privacidad");
		JCheckCondiciones_1.setBounds(6, 43, 173, 23);
		frame.getContentPane().add(JCheckCondiciones_1);

		JCheckCondiciones_1.setSelected(true);
		JCheckCondiciones_1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (JCheckCondiciones_1.isSelected()) {
					tfEdad.setEnabled(true);
				} else {
					tfEdad.setEnabled(false);
				}
			}
		});

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(6, 11, 50, 25);
		lblEdad.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdad.setPreferredSize(new Dimension(50, 25));
		frame.getContentPane().add(lblEdad);

		tfEdad = new JTextField();
		tfEdad.setBounds(66, 11, 86, 25);
		tfEdad.setPreferredSize(new Dimension(50, 25));
		frame.getContentPane().add(tfEdad);
		tfEdad.setColumns(10);
		tfEdad.setEnabled(true);

		tfEdad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (tfEdad.isEnabled()) {
					if (e.getKeyCode() == KeyEvent.VK_UP) {
						if (tfEdad.getText().isEmpty()) {
							tfEdad.setText("0");
						}
						String lblString = tfEdad.getText();
						Integer numero = Integer.parseInt(lblString);
						numero = numero + 1;
						tfEdad.setText(numero.toString());
					} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
						if (tfEdad.getText().isEmpty()) {
							tfEdad.setText("1");
						}
						String lblString = tfEdad.getText();
						Integer numero = Integer.parseInt(lblString);
						if (numero > 1) {
							numero = numero - 1;
							tfEdad.setText(numero.toString());
						}
					}
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
				
			}
		});
	}
}
