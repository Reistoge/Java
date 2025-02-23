package Logica;

public abstract class ActividadDecorator implements ActividadComponent {
	ActividadComponent componente;

	protected ActividadDecorator(ActividadComponent c) {
		this.componente = c;

	}

}
