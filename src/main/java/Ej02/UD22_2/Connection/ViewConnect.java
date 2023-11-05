package Ej02.UD22_2.Connection;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Ejercicios.UD22.Connection.ConnectionSQL;
import Ejercicios.UD22.View.Cliente.ViewCliente;
import Ejercicios.UD22.View.Video.ViewVideo;

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

	/**
	 * Create the frame.
	 */
	public ViewConnect() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 89);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnCientifico = new JButton("CLIENTE");
		btnCientifico.setForeground(Color.BLACK);
		btnCientifico.setBackground(Color.GREEN);
		contentPane.add(btnCientifico);
		this.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("CHOOSE ONE OF THESE TABLES");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblNewLabel);
		
		btnProyecto = new JButton("VIDEOS");
		btnProyecto.setBackground(Color.RED);
		btnProyecto.setForeground(Color.BLACK);
		contentPane.add(btnProyecto);
		this.setVisible(true);
	}
	
}
