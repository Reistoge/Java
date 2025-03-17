import java.util.ArrayList;
import java.util.List;

public class TestVisitor {
	// visitor discrimina por clase.
	// OJO:
	// se le llama visitor porque es la subclase a quien acepta el visitor con su
	// accept.

	public static void main(String[] args) {
		IVisitor visitar = new RenderizadorFiguras();
		IVisitor visitar2 = new LectorFiguras();
		List<Figura> figuras = new ArrayList<>();
		List<Triangulo> illuminati = new ArrayList<>();
		// no es asi.
//		for(Figura f : figuras) {
//			visitar.visitar(f);
//		}
		// tu solo debes instanciar el visitor.
		// aqui estamos visitando todas las figuras, pero cada figura hace algo
		// diferente .
		for (Figura f : figuras) {
			f.accept(visitar);
		}
		for (Triangulo t : illuminati) {
			// aqui estamos visitando todos los triangulo y queremos mostrarlo en forma de
			// texto
			t.accept(visitar2);
		}

	}

}

interface IVisitor {

	void visitar(Circulo circulo);

	// void mostrarInfo(Figura r);

	void visitar(Rectangulo rectangulo);

	void visitar(Triangulo triangulo);
}

class LectorFiguras implements IVisitor {
	// cada visitor hace algo diferente
	@Override
	public void visitar(Circulo circulo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitar(Rectangulo rectangulo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitar(Triangulo triangulo) {
		// TODO Auto-generated method stub

	}

}

class RenderizadorFiguras implements IVisitor {
	// cada visitor hace algo diferente
	@Override
	public void visitar(Circulo circulo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitar(Rectangulo rectangulo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitar(Triangulo triangulo) {
		// TODO Auto-generated method stub

	}

}

abstract class Figura {
	// accept es abstracto aunque de todas maneras tendra la forma de
	// r.visitar(this)
	abstract void accept(IVisitor r);
}

class Circulo extends Figura {

	@Override
	public void accept(IVisitor r) {
		r.visitar(this);
	}

}

class Rectangulo extends Figura {

	@Override
	public void accept(IVisitor r) {
		r.visitar(this);
	}

}

class Triangulo extends Figura {

	@Override
	public void accept(IVisitor r) {
		r.visitar(this);
	}

}
