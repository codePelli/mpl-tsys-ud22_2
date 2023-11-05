package Ej02.UD22_2.Asignado;

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
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import Ej02.UD22_2.Connection.ConnectionSQL;
import Ej02.UD22_2.Connection.ViewConnect;

public class ViewAsignado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
    private JPanel panel;
	private JButton btnDelete;
	
	ViewInsertAsignado viewInsertAsignado;
    ConnectionSQL connect;
    ControllerAsignado controllerAsignado;
	
	/**
	 * Create the frame.
	 */
	public ViewAsignado(ConnectionSQL connect) {
		
        this.connect = connect;
        this.controllerAsignado = new ControllerAsignado(connect);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 766, 470);
        contentPane = new JPanel();
        contentPane.setBackground(Color.PINK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("ASIGNADO");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(318, 11, 140, 26);
        contentPane.add(lblNewLabel);

        panel = new JPanel();
        panel.setBackground(Color.ORANGE);
        panel.setBounds(10, 53, 730, 367);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JButton btnInsert = new JButton("INSERT");
        btnInsert.setBounds(628, 12, 99, 25);
        contentPane.add(btnInsert);
        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	viewInsertAsignado = new ViewInsertAsignado(controllerAsignado, ViewAsignado.this);
            	viewInsertAsignado.setVisible(true);
            }
        });

        JButton btnBack = new JButton("BACK");
        btnBack.addActionListener(new ActionListener() {
            @Override
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
    }

    //FUNCTION TO SHOW ASIGNACION ON MAIN WINDOW
    public void showAsignado(List<Asignado> asign) {
    	
        if (asign.isEmpty()) {
        	
            JOptionPane.showMessageDialog(contentPane, "No ASIGNACION to show");
            
        } else {
        	
            panel.removeAll();
            panel.revalidate();

            int y = 8;
            int yy = 10;

            for (Asignado asignado : asign) {
            	
                JLabel lblAsignacion = new JLabel("Cientifico " + asignado.getCientifico() + "asignado a proyecto: " + asignado.getProyecto());
                panel.add(lblAsignacion);
                lblAsignacion.setBounds(10, y, 500, 30);

                //BUTTON DELETE FOR EACH ASIGNACION
                btnDelete = new JButton("DELETE");
                btnDelete.setBounds(550, yy, 80, 23);
                btnDelete.setBackground(Color.RED);
                btnDelete.setName("btnDel" + asignado.getCientifico() + asignado.getProyecto());
                btnDelete.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	
                    	String cientifico = asignado.getCientifico();
                    	String proyecto = asignado.getProyecto();
                    	
                    	controllerAsignado.deleteAsignado(cientifico, proyecto);
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