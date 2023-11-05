package Ej02.UD22_2.Cientifico;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Ej02.UD22_2.Connection.ConnectionSQL;

public class ViewUpdateCientifico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfName;
	private JTextField tfHoras;
	JButton btnUpdate;
	
	ControllerCientifico controllerCientifico;
	ConnectionSQL connection;

	/**
	 * Create the frame.
	 */
	public ViewUpdateCientifico(String id, ControllerCientifico controllerCientifico, 
			ConnectionSQL connection, ViewCientifico viewCientifico) {

		this.controllerCientifico = new ControllerCientifico(connection);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("id:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		lblId.setBounds(10, 21, 31, 24);
		contentPane.add(lblId);
		
		JLabel lblNombre = new JLabel("nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(10, 53, 61, 24);
		contentPane.add(lblNombre);
		
		tfId = new JTextField();
		tfId.setBounds(74, 23, 350, 20);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(74, 53, 350, 20);
		contentPane.add(tfName);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setBackground(Color.YELLOW);
		btnUpdate.setBounds(177, 226, 96, 24);
		contentPane.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					updateFields();
					JOptionPane.showMessageDialog(null, "CIENTIFICO updated");
					dispose();
					
				} catch (SQLException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

	}
	//FUNCTION TO GET DATA FROM TEXTFIELD AND UPDATE THEM
	public void updateFields() throws SQLException, ParseException {
		
		String id = getId();
		String nombre = getNombre();

		controllerCientifico.updateCientifico(id, nombre);
	}
	
	public String getId() throws SQLException {
		
		return tfId.getText();
	}
	
	public String getNombre() {
		
		return tfName.getText();
	}
	
}
