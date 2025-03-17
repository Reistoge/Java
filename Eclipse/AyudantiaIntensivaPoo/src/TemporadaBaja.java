
public class TemporadaBaja implements IStrategy{

	@Override
	public void aplicarDescuento(Reserva r) {
		// TODO Auto-generated method stub
		System.out.println("APLICANDO DESCUENTO POR TEMPORADA BAJA");
		r.setCosto(r.getCosto()*0.85f);
	}

}
