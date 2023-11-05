package Ej02.UD22_2.Connection;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;

public class ViewConnect extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btnCientifico;
	public JButton btnNo;
	public JButton btnProyecto;
	public JButton btnAsignado;
	

	/**
	 * Create the frame.
	 */
	public ViewConnect() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 110);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCientifico = new JButton("CIENTIFICO");
		btnCientifico.setBounds(34, 37, 91, 23);
		btnCientifico.setForeground(Color.BLACK);
		btnCientifico.setBackground(Color.GREEN);
		contentPane.add(btnCientifico);
		this.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("CHOOSE ONE OF THESE TABLES");
		lblNewLabel.setBounds(131, 10, 166, 14);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblNewLabel);
		
		btnProyecto = new JButton("PROYECTO");
		btnProyecto.setBounds(180, 37, 87, 23);
		btnProyecto.setBackground(Color.RED);
		btnProyecto.setForeground(Color.BLACK);
		contentPane.add(btnProyecto);
		this.setVisible(true);

		btnAsignado = new JButton("ASIGNADO");
		btnAsignado.setForeground(Color.BLACK);
		btnAsignado.setBackground(Color.BLUE);
		btnAsignado.setBounds(315, 37, 87, 23);
		contentPane.add(btnAsignado);
		this.setVisible(true);
	}
	
}
