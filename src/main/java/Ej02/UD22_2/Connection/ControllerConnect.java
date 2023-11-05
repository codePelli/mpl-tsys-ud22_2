package Ej02.UD22_2.Connection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Ej02.UD22_2.Cientifico.ViewCientifico;
import Ej02.UD22_2.Proyecto.ViewProyecto;
import Ejercicios.UD22.Connection.ConnectionSQL;
import Ejercicios.UD22.View.ViewConnect;
import Ejercicios.UD22.View.Cliente.ViewCliente;
import Ejercicios.UD22.View.Cliente.ViewUpdateCliente;
import Ejercicios.UD22.View.Video.ViewVideo;

public class ControllerConnect {
	
	private JButton btnSi;
	private JButton btnNo;
	private ViewConnect vc;
	public ConnectionSQL connection;
	private String DB;
	
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
			String tableSentence = "id INT(11) NOT NULL AUTO_INCREMENT, nombre VARCHAR(255) DEFAULT NULL, "
					+ "apellido VARCHAR(255) DEFAULT NULL, direccion VARCHAR(255) DEFAULT NULL, "
					+ "dni INT DEFAULT NULL, fecha DATE DEFAULT NULL, PRIMARY KEY (id)";
			
			String tableName2 = "cientifico";
			String tableSentence2 = "id INT(11) NOT NULL AUTO_INCREMENT, title VARCHAR(250) DEFAULT NULL, director VARCHAR(250) DEFAULT NULL, "
					+ "cli_id INT(11) DEFAULT NULL, PRIMARY KEY (id),"
					+ "CONSTRAINT videos_fk FOREIGN KEY (cli_id) REFERENCES cliente (id)";
			
			String tableName3 = "asignado";
			String tableSentence3 = "id INT(11) NOT NULL AUTO_INCREMENT, title VARCHAR(250) DEFAULT NULL, director VARCHAR(250) DEFAULT NULL, "
					+ "cli_id INT(11) DEFAULT NULL, PRIMARY KEY (id),"
					+ "CONSTRAINT videos_fk FOREIGN KEY (cli_id) REFERENCES cliente (id)";
			
			connection.createTable(tableName, tableSentence);
			connection.createTable(tableName2, tableSentence2);
			connection.createTable(tableName3, tableSentence3);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		vc.btnCientifico.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
	            JOptionPane.showMessageDialog(null, "Showing table Cliente");
	            vc.setVisible(false);
	            viewCliente = new ViewCliente(connection);
	            
	            viewCliente.setVisible(true);
	            viewCliente.showCliente(connection.getClientes());
			}
		});
		
		vc.btnProyecto.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
	            JOptionPane.showMessageDialog(null, "Showing table Videos");
	            vc.setVisible(false);
	            viewVideo = new ViewVideo(connection);
	            
	            viewVideo.setVisible(true);
	            viewVideo.showVideo(connection.getVideo());

			}
		});

	}
}
