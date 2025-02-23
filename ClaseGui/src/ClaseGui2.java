import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.w3c.dom.css.RGBColor;

public class ClaseGui2 {
	public static void main(String[] args) {
		JFrame ventana = new JFrame("mi ventana");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(300, 400);
		ventana.getContentPane().add(createGUI(crearFiguras()));
 
		ventana.setVisible(true);
	}

	private static Component createGUI(List<Figura> figuras) {
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel botonera = new JPanel();
		botonera.setLayout(new BoxLayout(botonera, BoxLayout.LINE_AXIS));
		JPanel panelVacio = new MiPanel(figuras);
		JButton button1 = (crearBoton1(panelVacio, figuras));
		JButton button2 = crearBoton2(panelVacio,figuras);
		JButton button3 = crearBoton3(panelVacio);
		botonera.add(button1);
		botonera.add(button2);
//		botonera.add(button3);
		mainPanel.add(botonera, BorderLayout.NORTH);
		mainPanel.add(panelVacio, BorderLayout.CENTER);

		mainPanel.setBackground(Color.black);
		panelVacio.setBackground(Color.BLACK);
		return mainPanel;
	}
	public static List<Figura> crearFiguras(){
		List<Figura> figuras= new ArrayList<>();
//		figuras.add(new Circulo(50,50,60));
//		figuras.add(new Cuadrado(60,100,40));
//		figuras.add(new Circulo(30,20,10));
//		figuras.add(new Cuadrado(90,80,20));
//		figuras.add(new Estrella(100,100,50));
		
		return figuras;
		
		
		
	}

	static JButton crearBoton3(JPanel panelVacio) {

		JButton b = new JButton("button 3");
		b.addActionListener(e -> {
			JOptionPane.showMessageDialog(null, "Hola");
			
		});
		return b;
	}
	static JButton crearBoton2(JPanel panelVacio,List<Figura> figuras) {
		JButton b= new JButton("pintar");
		b.addActionListener(e->{
			for(int i=0;i<1000;i++) {
				
				figuras.add(new Rectangulo((int)(Math.random()*1920),(int)(Math.random()*1080),(int)(Math.random()*20),(int)(Math.random()*20)));
				 
			}
			 panelVacio.repaint();
		});
		return b;
	}
	static JButton crearBoton1(JPanel panelVacio,List<Figura> figuras) {
		JButton b= new JButton("Limpiar");
		b.addActionListener(e->{
			 figuras.clear();
			 panelVacio.repaint();
		});
		return b;
	}
}

class MiPanel extends JPanel {
	
	List<Figura> figuras;
	public MiPanel(List<Figura> figuras) {
		this.figuras= figuras;
	}
	// en swing cada vez que un componente (en este caso JPanel) se debe mostrar en
	// pantalla automaticamente se invoca el metodo paint

	// usando la sobreEscritura de metodos que nos provee la herencia, vamos a crear
	// una subclase de JPanel y sobreescribiremos dicho paint para implementar
	// nuestro comportamiento especial
	@Override
	public void paint(Graphics g) {
//		Al método paint() se le 
//		envía como parámetro 
//		una instancia de la clase 
//		Graphics, que es la clase 
//		que nos permitirá dibujar!
//		g.setColor(Color.red);
//		g.drawLine(10, 10, 40, 40);
//		En este caso, cambiamos 
//		el color del “lápiz” a rojo, 
//		y dibujamos una línea 
//		desde las coordenadas 
//		10,10 a la 40,40 
//		En java las coordenadas graficas comienzan en la esquina superior izquierda: el 0,0.
//		g.setColor(Color.green);
//		g.drawOval(70,80,40,40);
		super.paint(g);
		System.out.println("PAINT !");
		for(Figura f: figuras) {
			f.dibujar(g);
		}
	}

	public List<Figura> getFiguras() {
		return figuras;
	}

	public void setFiguras(List<Figura> figuras) {
		this.figuras = figuras;
	}
	

}
abstract class Figura{
	public abstract void dibujar(Graphics g);
}
class Cuadrado extends Figura{
	private int x,y,lado;
	public Cuadrado(int x,int y,int lado) {
		this.x=x;
		this.y=y;
		this.lado=lado;
		
	}
	@Override
	public void dibujar(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.getHSBColor((float) Math.random()*0.7f, (float) Math.random()*0.5f, (float) Math.random()*0.7f ));
		g.drawRect(x,y,lado,lado);
	}
	
}
class Circulo extends Figura{
	private int x,y,radio;
	public Circulo(int x,int y, int radio) {
		this.x=x;
		this.y=y;
		this.radio=radio;
	}
	@Override
	public void dibujar(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.getHSBColor((float) Math.random()*0.7f, (float) Math.random()*0.5f, (float) Math.random()*0.7f ));
		g.drawOval(x, y, x, radio);
	}
	
}
class Rectangulo extends Figura{
	private int x,y,largo,ancho;
	public Rectangulo(int x,int y,int largo,int ancho) {
		this.x=x;
		this.y=y;
		this.largo=largo;
		this.ancho=ancho;
		
	}
	@Override
	public void dibujar(Graphics g) {
		// TODO Auto-generated method stub
		 
		g.setColor(Color.getHSBColor((float) Math.random()*0.7f, (float) Math.random()*0.5f, (float) Math.random()*0.7f ));
		g.drawRect(x,y,largo,ancho);
	}
	
}
class Estrella extends Figura{
	private int x,y;
	int tamaño;
	 
	public Estrella(int x, int y, int tamaño) {
		this.x = x;
		this.y = y;
		this.tamaño = tamaño;
	}

	@Override
	public void dibujar(Graphics g) {
		int[] x= {0,2,3,4,6,4,5,3,1,2,0};
		int[] y= {2,2,0,2,2,3,6,4,6,3,2};
		 
		for(int i =0; i<x.length-1;i++) {
			g.setColor(Color.getHSBColor((float) Math.random()*0.7f, (float) Math.random()*0.5f, (float) Math.random()*0.7f ));
			g.drawLine((x[i]*tamaño)+this.x, (y[i]*tamaño)+this.y, (x[i+1]*tamaño)+this.x, (y[i+1]*tamaño)+this.y);
		}
	}
}

