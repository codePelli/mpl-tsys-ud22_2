package Ej02.UD22_2.Cientifico;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ViewInsertCientifico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfDni;
	private JTextField tfNomApels;
	
	ViewCientifico viewCientifico;
	ControllerCientifico controllerCientifico;
	
	/**
	 * Create the frame.
	 */
	public ViewInsertCientifico(ControllerCientifico controllerCientifico, ViewCientifico viewCientifico) {

		this.controllerCientifico = controllerCientifico;
		this.viewCientifico = viewCientifico;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("dni:");
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId.setBounds(10, 53, 61, 24);
		contentPane.add(lblId);
		
		JLabel lblNombre = new JLabel("nomApels:");
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(10, 88, 61, 24);
		contentPane.add(lblNombre);
		
		tfDni = new JTextField();
		tfDni.setColumns(10);
		tfDni.setBounds(74, 53, 350, 20);
		contentPane.add(tfDni);
		
		tfNomApels = new JTextField();
		tfNomApels.setColumns(10);
		tfNomApels.setBounds(74, 88, 350, 20);
		contentPane.add(tfNomApels);
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.setBackground(Color.GREEN);
		btnInsert.setBounds(177, 226, 96, 24);
		contentPane.add(btnInsert);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String dni = getDni();
				String nomApels = getNomApels();
				
				Cientifico cientifico = new Cientifico(dni, nomApels);
				controllerCientifico.insertCientifico(cientifico);
				
				JOptionPane.showMessageDialog(null, "CIENTIFICO created");
				
				viewCientifico.showCientifico(controllerCientifico.listGetCientifico());
				dispose();

			}
		});
	}
	
	public String getDni() {
		
		return tfDni.getText();
	}
	
	public String getNomApels() {
		
		return tfNomApels.getText();
	}

}