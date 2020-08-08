package VisualInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import businessCode.Auxiliares;
import businessCode.Grafo;
import businessCode.GrafoJson;
import businessCode.MaxClique;
import businessCode.Vertice;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frmCliqueDePeso;
	private JTextField textPath;
	private String path;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmCliqueDePeso.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCliqueDePeso = new JFrame();
		frmCliqueDePeso.setTitle("Clique De Peso Maximo!");
		frmCliqueDePeso.setBounds(100, 100, 387, 251);
		frmCliqueDePeso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCliqueDePeso.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Auxiliares.existeGrafo(textPath.getText() ) == false) {
					JOptionPane.showMessageDialog(null, "en Archivo  '" + textPath.getText() + "'  no a sido encontrado!");
					return;
				}
				
				Grafo grafo = GrafoJson.leerJSON(textPath.getText()).getGrafo();
				ArrayList<Vertice> aux = MaxClique.solver(grafo);
				
				
				String ret = "";
				for(Vertice v: aux) {
					ret += "\n\t\t  vertice  " + v.getNumero() + "  peso:  " + v.getPeso();
				}
				
				resultado mostrar = new resultado(grafo.mostrarVertices(), grafo.getAristas(), ret );
				mostrar.setVisible(true);
//				JOptionPane.showMessageDialog(null, ret);
			}
		});
		btnNewButton.setBounds(141, 157, 89, 30);
		frmCliqueDePeso.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Grafo:");
		lblNewLabel.setBounds(30, 25, 48, 23);
		frmCliqueDePeso.getContentPane().add(lblNewLabel);
		
		textPath = new JTextField();
		textPath.setEditable(false);
		textPath.setBounds(88, 20, 244, 33);
		frmCliqueDePeso.getContentPane().add(textPath);
		textPath.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("ingresar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				textPath.setText(JOptionPane.showInputDialog("Ingresa el numero que deseas conocer"));
			}
		});
		btnNewButton_1.setBounds(243, 76, 89, 30);
		frmCliqueDePeso.getContentPane().add(btnNewButton_1);
	}
}
