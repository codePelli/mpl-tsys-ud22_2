package Ej02.UD22_2.Asignado;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import Ej02.UD22_2.Cientifico.Cientifico;
import Ej02.UD22_2.Connection.ConnectionSQL;

public class ControllerAsignado {
	
    private ConnectionSQL connection;

    public ControllerAsignado(ConnectionSQL connection) {
    	
        this.connection = connection;
    }
    
	public List<Asignado> listGetAsignado(){

		return connection.getAsignado();

	}

    public void insertAsignado(Asignado asignado) {
    	
        try {
        	
            String query = "INSERT INTO asignado (cientifico, proyecto) VALUES (?, ?)";
            PreparedStatement ps = connection.connection.prepareStatement(query);
            ps.setString(1, asignado.getCientifico());
            ps.setString(2, asignado.getProyecto());
            ps.executeUpdate();
            
        } catch (SQLException e) {
        	
            e.printStackTrace();
        }
    }

    public void deleteAsignado(String cientifico, String proyecto) {
    	
        try {
        	
            String query = "DELETE FROM asignado WHERE cientifico = ? AND proyecto = ?";
            PreparedStatement ps = connection.connection.prepareStatement(query);
            ps.setString(1, cientifico);
            ps.setString(2, proyecto);
            ps.executeUpdate();
            
        } catch (SQLException e) {
        	
            e.printStackTrace();
        }
    }
    
    public void updateAsignado(String cientifico, String proyecto) throws SQLException {
    	
        deleteAsignado(cientifico, proyecto);

		insertAsignado(new Asignado(cientifico, proyecto));
    }
    
    
}