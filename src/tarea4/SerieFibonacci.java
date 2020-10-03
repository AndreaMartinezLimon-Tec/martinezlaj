package tarea4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class SerieFibonacci extends JFrame {

	private JPanel contentPane;
	private JLabel lblValor1;
	private JLabel lblValor2;
	private JLabel lblIteraciones;
	private JTextField txtValor1;
	private JTextField txtValor2;
	private JTextField txtIteraciones;
	private JButton btnCalcularSerie;
	private JTextArea txtMostrarSerie;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SerieFibonacci frame = new SerieFibonacci();
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
	public SerieFibonacci() {
		setTitle("Serie Fibonacci");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblValor1 = new JLabel("Ingrese el primer valor:");
			lblValor1.setBounds(53, 14, 137, 14);
			contentPane.add(lblValor1);
		}
		{
			lblValor2 = new JLabel("Ingrese el segundo valor:");
			lblValor2.setBounds(42, 55, 148, 14);
			contentPane.add(lblValor2);
		}
		{
			lblIteraciones = new JLabel("Ingrese cantidad de iteraciones:");
			lblIteraciones.setBounds(10, 98, 198, 14);
			contentPane.add(lblIteraciones);
		}
		{
			txtValor1 = new JTextField();
			txtValor1.setBounds(218, 11, 86, 20);
			contentPane.add(txtValor1);
			txtValor1.setColumns(10);
		}
		{
			txtValor2 = new JTextField();
			txtValor2.setBounds(218, 52, 86, 20);
			contentPane.add(txtValor2);
			txtValor2.setColumns(10);
		}
		{
			txtIteraciones = new JTextField();
			txtIteraciones.setBounds(218, 95, 86, 20);
			contentPane.add(txtIteraciones);
			txtIteraciones.setColumns(10);
		}
		{
			btnCalcularSerie = new JButton("Calcular");
			btnCalcularSerie.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int intValor1 = Integer.parseInt(txtValor1.getText());
					int intValor2 = Integer.parseInt(txtValor2.getText());
					int CantidadIteracciones = Integer.parseInt(txtIteraciones.getText());
					txtMostrarSerie.setText("Serie resultante:\n"+intValor1+"\n"+intValor2);
					for(int i=1; i<=(CantidadIteracciones-2); i++)
					{
						intValor2= intValor1+intValor2;
						intValor1= intValor2- intValor1;
			            txtMostrarSerie.setText(txtMostrarSerie.getText()+"\n"+intValor2);
					}
				}
			});
			btnCalcularSerie.setBounds(316, 67, 89, 23);
			contentPane.add(btnCalcularSerie);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 126, 414, 124);
			contentPane.add(scrollPane);
			{
				txtMostrarSerie = new JTextArea();
				scrollPane.setViewportView(txtMostrarSerie);
				txtMostrarSerie.setEditable(false);
			}
		}
	}
}
