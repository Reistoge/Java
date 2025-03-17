
public class ITarifaVisitor implements IVisitor{
	// esto es lo que haria el visitor de tarias o precios por noche, cambiara el
	// parametro de costo por noche de una Habitacion.
	@Override
	public void visit(Sencilla s) {
		// TODO Auto-generated method stub
		s.setPrecioPorNoche(s.getPrecioPorNoche()*1.1f);
		
	}

	@Override
	public void visit(Doble d) {
		// TODO Auto-generated method stub
		d.setPrecioPorNoche(d.getPrecioPorNoche()*1.15f);
	}

	@Override
	public void visit(Suite s) {
		// TODO Auto-generated method stub
		s.setPrecioPorNoche(s.getPrecioPorNoche()*1.2f);
	}
	
}
