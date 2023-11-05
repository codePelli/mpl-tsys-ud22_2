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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ViewInsertAsignado extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tfCientificoDNI;
    private JTextField tfProyectoID;
    
    ControllerAsignado controllerAsignado;
    ViewAsignado viewAsignado;
    
    public ViewInsertAsignado(ControllerAsignado controllerAsignado, ViewAsignado viewAsignado) {
    	
    	this.controllerAsignado = controllerAsignado;
    	this.viewAsignado = viewAsignado;
        
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(Color.PINK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblCientificoDNI = new JLabel("cientifico dni:");
        lblCientificoDNI.setHorizontalAlignment(SwingConstants.LEFT);
        lblCientificoDNI.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblCientificoDNI.setBounds(10, 53, 100, 24);
        contentPane.add(lblCientificoDNI);

        JLabel lblProyectoID = new JLabel("proyecto id:");
        lblProyectoID.setHorizontalAlignment(SwingConstants.LEFT);
        lblProyectoID.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblProyectoID.setBounds(10, 88, 100, 24);
        contentPane.add(lblProyectoID);

        tfCientificoDNI = new JTextField();
        tfCientificoDNI.setColumns(10);
        tfCientificoDNI.setBounds(120, 53, 304, 20);
        contentPane.add(tfCientificoDNI);

        tfProyectoID = new JTextField();
        tfProyectoID.setColumns(10);
        tfProyectoID.setBounds(120, 88, 304, 20);
        contentPane.add(tfProyectoID);

        JButton btnInsert = new JButton("INSERT");
        btnInsert.setBackground(Color.GREEN);
        btnInsert.setBounds(177, 150, 96, 24);
        contentPane.add(btnInsert);
        btnInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                String cientificoDNI = getCientifico();
                String proyectoID = getProyecto();
                    
				controllerAsignado.insertAsignado(new Asignado(cientificoDNI, proyectoID));
    			JOptionPane.showMessageDialog(null, "ASIGNADO created");
                viewAsignado.showAsignado(controllerAsignado.listGetAsignado());
                    
                dispose();

            }
        });
    }

    public String getCientifico() {
        return tfCientificoDNI.getText();
    }
    
    public String getProyecto() {
        return tfProyectoID.getText();
    }
}