package Logica;

import java.util.ArrayList;

public class ColorDecorator extends ActividadDecorator {
	String color;
	
	public ColorDecorator(ActividadComponent c, String color) {
		super(c);
		this.color = color;
	}

	@Override
	public String getDatos() {

		return super.componente.getDatos() + "\t" + getColor();

	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return "";
	}

}
