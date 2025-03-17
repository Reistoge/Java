
import java.awt.BorderLayout;
import java.awt.Component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {
	public static void main(String[] args) {
		double time = 0;
		Scanner scan = new Scanner(System.in);
		JFrame ventana = new JFrame("mi ventana");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(300, 400);
		ventana.getContentPane().add(createGUI());
		ventana.setVisible(true);

	}

	private static JPanel createGUI() {
		// create JPanel with borderLayout
		JPanel mainPanel = new JPanel(new BorderLayout());

		JPanel botonera = new JPanel();

		botonera.setLayout(new BoxLayout(botonera, BoxLayout.LINE_AXIS));

		// al momento de crear el panel central indicaremos que su layout sera un
		// boxLayout pero vertical (page axis)
		// De esa manera a medida que se vayan agregando los JLabel estos se acomodaran verticalmente.
		JPanel panelVacio = new JPanel();
		panelVacio.setLayout(new BoxLayout(panelVacio, BoxLayout.PAGE_AXIS));

		// create three buttons
		JButton button1 = new JButton("Button 1");
		JButton button2 = new JButton("Button 2");
		JButton button3 = crearBoton3(panelVacio);
		// add buttons to the panel with borderLayout constraints
		botonera.add(button1);
		botonera.add(button2);
		botonera.add(button3);
		mainPanel.add(botonera, BorderLayout.NORTH);
		mainPanel.add(panelVacio, BorderLayout.CENTER);
		return mainPanel;

	}

	private static JButton crearBoton3(JPanel panelCentral) {
		JButton b = new JButton("Button3");
		b.addActionListener(e -> {
			System.out.println("Hago click");
			panelCentral.add(new JLabel("Hola"));
			panelCentral.revalidate();
		});
		return b;
	}

}
