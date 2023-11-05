package Ej02.UD22_2.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import Ej02.UD22_2.Cientifico.Cientifico;
import Ej02.UD22_2.Proyecto.Proyecto;
import Ejercicios.UD22.Controller.ControllerConnect;
import Ejercicios.UD22.Model.Cliente;
import Ejercicios.UD22.Model.Video;

import java.sql.Statement;
import java.sql.*;

public class ConnectionSQL {
	
    public Connection connection;

    public ConnectionSQL(String ip, String user, String pass) {
    	
        connect(ip, user, pass);
        
    }

    public boolean connect(String ip, String user, String pass) {
    	
        try {
        	
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(ip, user, pass);
            
            System.out.println("Connected to DB");
            
            return true;
            
        } catch (SQLException | ClassNotFoundException ex) {
        	
            System.out.println("ERROR connecting to DB");
            System.out.println(ex);
            
            return false;
        }
    }

    public void disconnect() {
    	
        try {
        	
            connection.close();
            System.out.println("You disconnected from DB");
            
        } catch (SQLException ex) {
        	
            System.out.println("ERROR when desconnecting");
        }
    }

    public void createTable(String tableName, String tableSentence) {
    	
        try {
        	
            String query = "CREATE TABLE IF NOT EXISTS " + tableName + " (" + tableSentence + ");";       
            Statement st = connection.createStatement();
            st.executeUpdate(query);
            
            System.out.println("TABLE " + tableName + " CREATED.");
            
        } catch (SQLException ex) {
        	
            System.out.println("ERROR creating table " + tableName);
            System.out.println(ex.getMessage());
        }
    }
		
    public void insert(String tableName, String columns, String values) {
    	
        try {
        	
            String query = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + values + ")";
            Statement st = connection.createStatement();
            st.executeUpdate(query);
            
            System.out.println("Datos añadidos a la tabla " + tableName);
            
        } catch (SQLException ex) {
        	
            System.out.println("ERROR al insertar datos a la tabla " + tableName);
            System.out.println(ex.getMessage());
        }
    }

    public void select(String tableName) {
    	
        try {
        	
            String query = "SELECT * FROM " + tableName;
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);

            while (resultSet.next()) {
            	
            	int codigo = resultSet.getInt("Codigo");
                String nombre = resultSet.getString("Nombre");
                
                System.out.println("Codigo: " + codigo + ", Nombre: " + nombre);
            }
            
        } catch (SQLException ex) {
        	
            System.out.println("ERROR al imprimir los datos de la tabla " + tableName);
            System.out.println(ex.getMessage());
        }
    }

    public void delete(String tableName, String condition) {
    	
        try {
        	
            String query = "DELETE FROM " + tableName + " WHERE " + condition;
            Statement st = connection.createStatement();
            int filas = st.executeUpdate(query);

            if (filas > 0) {
            	
                System.out.println("Datos de la tabla " + tableName + "eliminados");
                
            } else {
            	
                System.out.println("No hay datos en la tabla " + tableName + " para borrar");          
            }
            
        } catch (SQLException ex) {
        	
            System.out.println("ERROR al borrar datos de la tabla " + tableName);
            System.out.println(ex.getMessage());
        }
    }
    
    public void drop(String tableName) {
    	
    	try {
    		
            String query = "DROP TABLE IF EXISTS " + tableName;
            Statement st = connection.createStatement();
            st.executeUpdate(query);
            
            System.out.println("Tabla " + tableName + " borrada");

    	} catch (SQLException ex) {
    		
            System.out.println("ERROR al borrar la tabla " + tableName);
            System.out.println(ex.getMessage());
    	}

    }
    
    public List<Proyecto> getProyecto(){
    	
    	List<Proyecto> pro = new ArrayList<>();
    	
    	try {
    		
    		String query = "SELECT * FROM proyecto";
    		Statement st = connection.createStatement();
    		ResultSet rs = st.executeQuery(query);
    		
    		while(rs.next()) {
    			
    			String id = rs.getString("id");
                String nombre = rs.getString("nombre");
                int horas = rs.getInt("horas");
                
                Proyecto cientifico = new Proyecto (id, nombre, horas);
                pro.add(cientifico);
                
    		}
    		
    	} catch (SQLException e){
    		System.out.println(e.getMessage());
    	}
    	
		return pro;
    }
    
    public List<Cientifico> getCientifico(){
    	
    	List<Cientifico> cie = new ArrayList<>();
    	
    	try {
    		
    		String query = "SELECT * FROM cientifico";
    		Statement st = connection.createStatement();
    		ResultSet rs = st.executeQuery(query);
    		
    		while(rs.next()) {
    			
    			String dni = rs.getString("dni");
                String nomApels = rs.getString("nomApels");
                
                Cientifico cientifico = new Cientifico (dni, nomApels);
                cie.add(cientifico);
                
    		}
    		
    	} catch (SQLException e){
    		System.out.println(e.getMessage());
    	}
    	
		return cie;
    }
}