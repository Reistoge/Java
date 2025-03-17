import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {
	public static void main(String[] args) {
		// los Jframe se les pueden añadir JPanel
		JFrame ventana = new JFrame("Mi Ventana 2");
		// setea el boton de cierre.
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// tamaño de la ventana.
		ventana.setSize(300,400);		
		// se crea una lista de figuras.
		List<Figura> figuras = new ArrayList<>(); 
		// obtenemos la ventana y le añadimos un JPanel.
		ventana.getContentPane().add(createGUI(ventana,figuras));
		ventana.setVisible(true);
	}
	private static JPanel createGUI(JFrame ventana,List<Figura> figuras) {
		// create gui es un Jpanel
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel botonera= new JPanel();
		botonera.setLayout(new BoxLayout(botonera,BoxLayout.LINE_AXIS));
		JPanel panelVacio= new MiPanel(figuras);
		JButton button1= crearBoton1(ventana,figuras,panelVacio);
		JButton button2= new JButton("Button 2");
		JButton button3= new JButton("Button 3");
		
		// si los añado de forma distinta ??
		botonera.add(button1);
		botonera.add(button2);
		botonera.add(button3);
		mainPanel.add(botonera,BorderLayout.NORTH);
		mainPanel.add(panelVacio,BorderLayout.CENTER);
		return mainPanel;
		
		
		
	}
	
	private static JButton crearBoton1(JFrame ventana, List<Figura> figuras, JPanel panelCentral) {
		
		JButton b = new JButton("Nuevo Cuadrado");
		// esto es lo que hace el boton.
		b.addActionListener( e ->{
			
			DatosCuadradoDialog d = new DatosCuadradoDialog(ventana);
			boolean saveClicked = d.showDialog();
			if(!saveClicked) return;
			int[] numbers =d.getNumbers();
			figuras.add(new Cuadrado(numbers[0],numbers[1],numbers[2]));
			panelCentral.repaint();
			
		});
		return b;
		
	}

	
}
abstract class Figura{
	public abstract void dibujar (Graphics g);
}
 
class MiPanel extends JPanel{
	private List<Figura> figuras;
	public MiPanel(List<Figura> figuras) {
		this.figuras=figuras;
	}
	public void paint(Graphics g) {
		super.paint(g);
		for(Figura f : figuras ) {
			f.dibujar(g);
		}
	}
	
}

class Cuadrado extends Figura{
	private int x,y,lado;
	public Cuadrado(int i, int j, int lado) {
		// TODO Auto-gene
		this.x=i;
		this.y=j;
		this.lado=lado;
	}
	@Override
	public void dibujar(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.red);
		g.drawRect(x, y, lado, lado	);
	}
	
}
class Circulo extends Figura{
	private int x,y,radio;
	public Circulo(int x,int y,int radio) {
		this.x=x;
		this.y=y;
		this.radio=radio;
	}
	@Override
	public void dibujar(Graphics g) {
		// TODO Auto-generated method stub
		g.drawOval(x, y, radio, radio);
	}
	
	
	
}
class DatosCuadradoDialog extends JDialog
{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    private boolean saveClicked = false;
    private int[] numbers;

    public DatosCuadradoDialog(JFrame owner)
    {
        super(owner, "Nuevo Cuadrado", true); 
        initComponents();
    }

    private void initComponents()
    {
        // Create text fields
        textField1 = new JTextField(10);
        textField2 = new JTextField(10);
        textField3 = new JTextField(10);

        // Create buttons
        JButton saveButton = new JButton("Save");
        JButton cancelButton = new JButton("Cancel");

        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

        // Add components to the frame
        add(new JLabel("X:"));
        add(textField1);
        add(new JLabel("Y:"));
        add(textField2);
        add(new JLabel("Lado:"));
        add(textField3);
        add(saveButton);
        add(cancelButton);
        
        saveButton.addActionListener(e -> { saveNumbers(); });
        cancelButton.addActionListener(e -> { dispose(); });
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        addWindowListener(new EscuchadorCierreVentana());
    }

    private class EscuchadorCierreVentana extends WindowAdapter
    {
    	// escucha por si el usuario cierra la ventana.
        public void windowClosing(java.awt.event.WindowEvent windowEvent)
        {
            onCancel();
        }
    }
    private void onCancel()
    {
    	// cierra el dialogo.
        dispose();
    }

    private void saveNumbers()
    {
        try {
            int number1 = Integer.parseInt(textField1.getText());
            int number2 = Integer.parseInt(textField2.getText());
            int number3 = Integer.parseInt(textField3.getText());

            numbers = new int[] { number1, number2, number3 };
            saveClicked = true;

            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                    "Números inválidos", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean showDialog()
    {
    	// 
        pack();
        setLocationRelativeTo(getParent());
        
        // If the dialog is not already visible, this call will not 
        // return until the dialog is hidden by calling setVisible(false) 
        // or dispose(). 
        setVisible(true);

        return saveClicked;
    }

    public int[] getNumbers()
    {
        return numbers;
    }
}
