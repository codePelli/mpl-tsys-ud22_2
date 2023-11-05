package Ej02.UD22_2.Proyecto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import Ej02.UD22_2.Connection.ConnectionSQL;
import Ej02.UD22_2.Connection.ViewConnect;

public class ViewProyecto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnDelete;
	private JButton btnUpdate;
	JPanel panel;
	
	ConnectionSQL connect;
	ControllerProyecto controllerProyecto;
	ViewInsertProyecto viewInsertProyecto;
	ViewProyecto viewProyecto;

	/**
	 * Create the frame.
	 */
	public ViewProyecto(ConnectionSQL connect) {
		
		this.connect = connect;
		this.controllerProyecto = new ControllerProyecto(connect);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 470);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CIENTIFICOS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(318, 11, 89, 26);
		contentPane.add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(10, 53, 730, 367);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        ViewConnect viewConnect = new ViewConnect();
		        viewConnect.setVisible(true);
		        dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.setForeground(Color.RED);
		btnBack.setBounds(10, 13, 89, 24);
		contentPane.add(btnBack);
		
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.setBounds(628, 12, 99, 25);
		contentPane.add(btnInsert);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				viewInsertProyecto = new ViewInsertProyecto(controllerProyecto, ViewProyecto.this);
				viewInsertProyecto.setVisible(true);
			}
		});
	}
	
	//FUNCTION TO SHOW PROYECTOS ON MAIN WINDOW
	public void showProyecto(List<Proyecto> pro) {

        if(pro.isEmpty()) {
        	
        	JOptionPane.showMessageDialog(contentPane, "No PROYECTO to show");
        	
        } else {
        	
            panel.removeAll();
            panel.revalidate();
        	
        	int y = 8;
        	int yy = 10;
        	
        	for (Proyecto proyecto : pro) {
        		
                JLabel lblProyecto = new JLabel("ID: " + proyecto.getId() + ", nombre: " + proyecto.getNombre()
                		+ ", horas: " + proyecto.getHoras());
                
                panel.add(lblProyecto);
                lblProyecto.setBounds(10, y, 500, 30);
                
                //BUTTON UPDATE FOR EACH PROYECTO
        		btnUpdate = new JButton("UPDATE");
        		btnUpdate.setBounds(550, yy, 80, 23);
        		btnUpdate.setBackground(Color.YELLOW);
                btnUpdate.setName("btnUpd" + proyecto.getId());
        		btnUpdate.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				
        				String proyectoId = proyecto.getId();
        				ControllerProyecto controllerProyecto = new ControllerProyecto(connect);
        				
        				ViewUpdateProyecto viewUpdateProyecto = new ViewUpdateProyecto(proyectoId, controllerProyecto, connect, viewProyecto);
        				viewUpdateProyecto.setVisible(true);
        			}
        		});
        		
                panel.add(btnUpdate);

        		//BUTTON DELETE FOR EACH CLIENTE
        		btnDelete = new JButton("DELETE");
        		btnDelete.setBounds(635, yy, 80, 23);
        		btnDelete.setBackground(Color.RED);
                btnDelete.setName("btnDel" + proyecto.getId());
        		btnDelete.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				        				
        				int del = JOptionPane.showConfirmDialog(null, "Do you want to delete this cliente?", "Confirm",
        						JOptionPane.YES_NO_OPTION);
        				
        				if (del == JOptionPane.YES_OPTION) {
        					
    						String proyectoId = proyecto.getId();						
    						controllerProyecto.deleteProyecto(proyectoId);
    						
    				        panel.remove(lblProyecto);
                            panel.remove(btnDelete);
                            panel.revalidate();
                            panel.repaint();
            			}
        			}
        		
        		});
        		
                panel.add(btnDelete);
                
                y = y + 30;
                yy = yy + 30;
                
        	}
        }
        
        panel.revalidate();
        panel.repaint();
	}
}