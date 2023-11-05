package Ej02.UD22_2.Cientifico;

import java.awt.Color;
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

public class ViewCientifico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JButton btnUpdate;
	private JButton btnDelete;

	ViewCientifico viewCientifico;
	ConnectionSQL connect;
	ViewConnect viewConnect;
	ControllerCientifico controllerCientifico;
	ViewInsertCientifico viewInsertCientifico;

	/**
	 * Create the frame.
	 */
	public ViewCientifico(ConnectionSQL connect) {

		this.connect = connect;
		this.controllerCientifico = new ControllerCientifico(connect);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.setBounds(628, 12, 99, 25);
		contentPane.add(btnInsert);
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

		        viewInsertCientifico = new ViewInsertCientifico(controllerCientifico, ViewCientifico.this);
				viewInsertCientifico.setVisible(true);
			}
		});
	}

	//FUNCTION TO SHOW CIENTIFICOS ON MAIN WINDOW
	public void showCientifico(List<Cientifico> cie) {

        if(cie.isEmpty()) {

        	JOptionPane.showMessageDialog(contentPane, "No CIENTIFICOS to show");

        } else {

            panel.removeAll();
            panel.revalidate();

        	int y = 8;
        	int yy = 10;

        	for (Cientifico cientifico : cie) {

                JLabel lblCliente = new JLabel("dni: " + cientifico.getDni() + ", nomApels: " + cientifico.getNomApels());

                panel.add(lblCliente);
                lblCliente.setBounds(10, y, 500, 30);

                //BUTTON UPDATE FOR EACH CIENTIFICO
        		btnUpdate = new JButton("UPDATE");
        		btnUpdate.setBounds(550, yy, 80, 23);
        		btnUpdate.setBackground(Color.YELLOW);
                btnUpdate.setName("btnUpd" + cientifico.getDni());
        		btnUpdate.addActionListener(new ActionListener() {
        			@Override
					public void actionPerformed(ActionEvent e) {

        				String dni = cientifico.getDni();
        				ControllerCientifico controllerCientifico = new ControllerCientifico(connect);

        				ViewUpdateCientifico viewUpdate = new ViewUpdateCientifico(dni, controllerCientifico, connect, viewCientifico);
        				viewUpdate.setVisible(true);
        			}
        		});

                panel.add(btnUpdate);

        		//BUTTON DELETE FOR EACH CLIENTE
        		btnDelete = new JButton("DELETE");
        		btnDelete.setBounds(635, yy, 80, 23);
        		btnDelete.setBackground(Color.RED);
                btnDelete.setName("btnDel" + cientifico.getDni());
        		btnDelete.addActionListener(new ActionListener() {
        			@Override
					public void actionPerformed(ActionEvent e) {

        				int del = JOptionPane.showConfirmDialog(null, "Do you want to delete this cientifico?", "Confirm",
        						JOptionPane.YES_NO_OPTION);

        				if (del == JOptionPane.YES_OPTION) {

    						String dni = cientifico.getDni();
    						controllerCientifico.deleteCientifico(dni);
    						
    				        panel.remove(lblCliente);
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
