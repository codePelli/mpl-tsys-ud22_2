package Ej02.UD22_2.Asignado;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Ej02.UD22_2.Connection.ConnectionSQL;

public class ViewUpdateAsignado extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tfCientifico;
    private JTextField tfProyecto;
    private JButton btnUpdate;
    
    private ControllerAsignado controllerAsignado;
    private ConnectionSQL connection;
    private ViewAsignado viewAsignado;
    private String cientifico;
    private String proyecto;

    /**
     * Create the frame.
     */
    public ViewUpdateAsignado(String cientifico, String proyecto, ControllerAsignado controllerAsignado, ConnectionSQL connection, ViewAsignado viewAsignado) {
        
        this.cientifico = cientifico;
        this.proyecto = proyecto;
        this.controllerAsignado = controllerAsignado;
        this.connection = connection;
        this.viewAsignado = viewAsignado;
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(Color.PINK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblCientifico = new JLabel("Cientifico:");
        lblCientifico.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblCientifico.setHorizontalAlignment(SwingConstants.LEFT);
        lblCientifico.setBounds(10, 21, 61, 24);
        contentPane.add(lblCientifico);

        JLabel lblProyecto = new JLabel("Proyecto:");
        lblProyecto.setHorizontalAlignment(SwingConstants.LEFT);
        lblProyecto.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblProyecto.setBounds(10, 53, 61, 24);
        contentPane.add(lblProyecto);

        tfCientifico = new JTextField();
        tfCientifico.setBounds(74, 23, 350, 20);
        tfCientifico.setText(cientifico);
        tfCientifico.setEnabled(false);
        contentPane.add(tfCientifico);
        tfCientifico.setColumns(10);

        tfProyecto = new JTextField();
        tfProyecto.setBounds(74, 53, 350, 20);
        tfProyecto.setText(proyecto);
        tfProyecto.setEnabled(false);
        contentPane.add(tfProyecto);
        tfProyecto.setColumns(10);

        btnUpdate = new JButton("UPDATE");
        btnUpdate.setBackground(Color.YELLOW);
        btnUpdate.setBounds(177, 226, 96, 24);
        contentPane.add(btnUpdate);
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                updateAsignado();

                dispose();
            }
        });
    }
    
	private void updateAsignado() {
		
		String cientifico = getCientifico();
		String proyecto = getProyecto();
		
		try {
			controllerAsignado.updateAsignado(cientifico, proyecto);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String getCientifico() {
		// TODO Auto-generated method stub
		return tfCientifico.getText();
	}
	
	private String getProyecto() {
		// TODO Auto-generated method stub
		return tfProyecto.getText();
	}
}

