package Ejercicio4;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ejercicio4 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio4 window = new Ejercicio4();
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
	public Ejercicio4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblClick = new JLabel("Haz click en algun boton");
		
		JButton btn1 = new JButton("1");
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn1.setBackground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn1.setBackground(null);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				btn1.setText(btn1.getText()+"!");
			}
		});
		frame.getContentPane().add(btn1);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblClick.setText("Has hecho click en el boton 1");
			}
			
		});

		JButton btn2 = new JButton("2");
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn2.setBackground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn2.setBackground(null);
			}
			public void mouseClicked(MouseEvent e) {
				btn2.setText(btn2.getText()+"!");
			}
		});
		frame.getContentPane().add(btn2);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblClick.setText("Has hecho click en el boton 2");
			}
		});

		JButton btn3 = new JButton("3");
		btn3.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btn3.setBackground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn3.setBackground(null);
			}
			public void mouseClicked(MouseEvent e) {
				btn3.setText(btn3.getText()+"!");
			}
		});
		frame.getContentPane().add(btn3);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblClick.setText("Has hecho click en el boton 3");
			}
		});

		frame.getContentPane().add(lblClick);
	}

}
