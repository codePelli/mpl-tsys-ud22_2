package Ej02.UD22_2.Proyecto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Ej02.UD22_2.Cientifico.Cientifico;

public class ViewInsertProyecto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfNombre;
	private JTextField tfHoras;
	
	private ViewProyecto viewProyecto;
	private ControllerProyecto controllerProyecto;

	/**
	 * Create the frame.
	 */
	public ViewInsertProyecto(ControllerProyecto controllerProyecto, ViewProyecto viewProyecto) {
		
		this.controllerProyecto = controllerProyecto;
		this.viewProyecto = viewProyecto;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("id:");
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId.setBounds(10, 53, 61, 24);
		contentPane.add(lblId);
		
		JLabel lblNombre = new JLabel("nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(10, 88, 61, 24);
		contentPane.add(lblNombre);
		
		JLabel lblHoras = new JLabel("horas:");
		lblHoras.setHorizontalAlignment(SwingConstants.LEFT);
		lblHoras.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHoras.setBounds(10, 123, 61, 24);
		contentPane.add(lblHoras);
		
		tfId = new JTextField();
		tfId.setColumns(10);
		tfId.setBounds(74, 53, 350, 20);
		contentPane.add(tfId);
		
		tfNombre = new JTextField();
		tfNombre.setColumns(10);
		tfNombre.setBounds(74, 88, 350, 20);
		contentPane.add(tfNombre);
		
		tfHoras = new JTextField();
		tfHoras.setColumns(10);
		tfHoras.setBounds(74, 125, 350, 20);
		contentPane.add(tfHoras);
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.setBackground(Color.GREEN);
		btnInsert.setBounds(177, 226, 96, 24);
		contentPane.add(btnInsert);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = getId();
				String nombre = getNombre();
				int horas = getHoras();
				
				Proyecto proyecto = new Proyecto(id, nombre, horas);
				controllerProyecto.insertProyecto(proyecto);
				
				JOptionPane.showMessageDialog(null, "PROYECTO created");
				
				viewProyecto.showProyecto(controllerProyecto.listGetProyecto());
				dispose();
				
			}
		});
	}
	
	public String getId() {
		
		return tfId.getText();
	}
	
	public String getNombre() {
		
		return tfNombre.getText();
	}
	
	public int getHoras() {
		
		return Integer.parseInt(tfHoras.getText());
	}

}