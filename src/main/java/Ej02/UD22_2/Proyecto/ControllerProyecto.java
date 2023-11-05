package Ej02.UD22_2.Proyecto;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import Ej02.UD22_2.Cientifico.Cientifico;
import Ej02.UD22_2.Connection.ConnectionSQL;

public class ControllerProyecto {
	
	private ConnectionSQL connection;
	
	public ControllerProyecto(ConnectionSQL connection) {
		
		this.connection = connection;
	}
	
	public List<Proyecto> listGetProyecto(){
		
		return connection.getProyecto();
		
	}
	
	//FUNCTION TO SEND THE QUERY TO DB FOR INSERTING DATA
	public void insertProyecto(Proyecto proyecto) {
		
		try {
			
			String query = "INSERT INTO proyecto (id, nombre, horas) VALUES (?, ?, ?)";
			
	        PreparedStatement ps = connection.connection.prepareStatement(query);
	        
	        ps.setString(1, proyecto.getId());
	        ps.setString(2, proyecto.getNombre());
	        ps.setInt(3, proyecto.getHoras());
	        ps.executeUpdate();
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	//FUNCTION TO SEND THE QUERY TO DB FOR UPDATING DATA
	public void updateProyecto(String id, String nombre, int horas) {
		
		try {
			
	        String query = "UPDATE proyecto SET id = ?, nombre = ?, horas = ?  WHERE id = ?";
	        
		       PreparedStatement ps = connection.connection.prepareStatement(query);
		       
		        ps.setString(1, id);
		        ps.setString(2, nombre);
		        ps.setInt(3, horas);
		        
		        ps.executeUpdate();
			
		} catch (SQLException e){
			System.out.println(e.getMessage());
		}
		
	}
	
	//FUNCTION TO SEND THE QUERY TO DB FOR DELETING DATA
	public void deleteProyecto(String id) {
		
		try {
			
			String query = "DELETE FROM proyecto WHERE id = ?";
			
			PreparedStatement ps = connection.connection.prepareStatement(query);
			
			ps.setString(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
	}

}