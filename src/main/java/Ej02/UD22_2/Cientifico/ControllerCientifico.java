package Ej02.UD22_2.Cientifico;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import Ej02.UD22_2.Connection.ConnectionSQL;

public class ControllerCientifico {

	private ConnectionSQL connection;

	public ControllerCientifico(ConnectionSQL connection) {

		this.connection = connection;
	}

	public List<Cientifico> listGetCientifico(){

		return connection.getCientifico();

	}

	//FUNCTION TO SEND THE QUERY TO DB FOR INSERTING DATA
	public void insertCientifico(Cientifico cientifico) {

		try {

			String query = "INSERT INTO cientifico (dni, nomApels) VALUES (?, ?)";

	        PreparedStatement ps = connection.connection.prepareStatement(query);

	        ps.setString(1, cientifico.getDni());
	        ps.setString(2, cientifico.getNomApels());
	        ps.executeUpdate();

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}
	}

	//FUNCTION TO SEND THE QUERY TO DB FOR UPDATING DATA
	public void updateCientifico(String dni, String nomApels) {

		try {

	        String query = "UPDATE cientifico SET dni = ?, nomApels = ? WHERE dni = ?";

		       PreparedStatement ps = connection.connection.prepareStatement(query);

		        ps.setString(1, dni);
		        ps.setString(2, nomApels);

		        ps.executeUpdate();

		} catch (SQLException e){
			System.out.println(e.getMessage());
		}

	}

	//FUNCTION TO SEND THE QUERY TO DB FOR DELETING DATA
	public void deleteCientifico(String dni) {

		try {

			String query = "DELETE FROM cientifico WHERE dni = ?";

			PreparedStatement ps = connection.connection.prepareStatement(query);

			ps.setString(1, dni);
			ps.executeUpdate();

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}
	}

}