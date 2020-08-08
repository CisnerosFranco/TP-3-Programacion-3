package VisualInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;

public class resultado extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					resultado frame = new resultado(null, null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public resultado(String vertices, String aristas, String maxClique) {
		setTitle("Resultados!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 953, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JTextPane txtpnConjuntoDeVertices = new JTextPane();
		txtpnConjuntoDeVertices.setBounds(0, 0, 937, 378);
		contentPane.add(txtpnConjuntoDeVertices);
		String ret = "\r\nconjunto de Vertices del Grafo  " + vertices + "  \r\n\n\nAristas del Grafo  { "+ aristas + " }\r\n \r\n\r\nClique de Peso Maximo encontrada:  " + maxClique;
		txtpnConjuntoDeVertices.setText(ret);
	}
}
