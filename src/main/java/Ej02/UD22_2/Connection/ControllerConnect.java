package Ej02.UD22_2.Connection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Ej02.UD22_2.Asignado.ViewAsignado;
import Ej02.UD22_2.Cientifico.ViewCientifico;
import Ej02.UD22_2.Proyecto.ViewProyecto;

public class ControllerConnect {
	
	private JButton btnSi;
	private JButton btnNo;
	private ViewConnect vc;
	public ConnectionSQL connection;
	private String DB;
	private JButton btnProyecto;
	private JButton btnCientifico;
	private JButton btnAsignado;
	
	ViewAsignado viewAsignado;
	ViewCientifico viewCientifico;
	ViewProyecto viewProyecto;

	public ControllerConnect(ViewConnect vc) {

		this.vc = vc;

		String ip = "jdbc:mysql://localhost:33060";
		String user = "root";
		String pass = "password";
		
	    connection = new ConnectionSQL(ip, user, pass);
		DB = JOptionPane.showInputDialog(null, "Name your DB:");
		
        String queryDB = "CREATE DATABASE IF NOT EXISTS " + DB;
        Statement st;
        
		try {
			
			st = connection.connection.createStatement();
			st.executeUpdate(queryDB);
			
			String ip2 = "jdbc:mysql://localhost:33060/" + DB;
			connection.connect(ip2, user, pass);
				
			String tableName = "proyecto";
			String tableSentence = "id CHAR(4) PRIMARY KEY, nombre NVARCHAR(255), horas INT";
			
			String tableName2 = "cientifico";
			String tableSentence2 = "dni VARCHAR(8) PRIMARY KEY, nomApels NVARCHAR(255)";
			
			String tableName3 = "asignado";
			String tableSentence3 = "cientifico VARCHAR(8), proyecto CHAR(4), PRIMARY KEY (cientifico, proyecto), "
					+ "FOREIGN KEY (cientifico) REFERENCES cientifico(dni), FOREIGN KEY (proyecto) REFERENCES proyecto(id)";
			
			connection.createTable(tableName, tableSentence);
			connection.createTable(tableName2, tableSentence2);
			connection.createTable(tableName3, tableSentence3);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		vc.btnCientifico.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
	            JOptionPane.showMessageDialog(null, "Showing table Cientifico");
	            vc.setVisible(false);
	            viewCientifico = new ViewCientifico(connection);
	            
	            viewCientifico.setVisible(true);
	            viewCientifico.showCientifico(connection.getCientifico());
			}
		});
		
		vc.btnProyecto.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
	            JOptionPane.showMessageDialog(null, "Showing table Proyecto");
	            vc.setVisible(false);
	            viewProyecto = new ViewProyecto(connection);
	            
	            viewProyecto.setVisible(true);
	            viewProyecto.showProyecto(connection.getProyecto());

			}
		});
		
		vc.btnAsignado.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
	            JOptionPane.showMessageDialog(null, "Showing table Asignado");
	            vc.setVisible(false);
	            viewAsignado = new ViewAsignado(connection);
	            
	            viewAsignado.setVisible(true);
	            viewAsignado.showAsignado(connection.getAsignado());

			}
		});
	}
}
