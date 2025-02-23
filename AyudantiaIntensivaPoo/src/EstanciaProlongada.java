
public class EstanciaProlongada implements IStrategy{

	@Override
	public void aplicarDescuento(Reserva r) {
		// TODO Auto-generated method stub
		System.out.println("APLICANDO DESCUENTO POR ESTANCIA PROLONGADA");
		if(Integer.parseInt(r.getDuracionEstadia())>=10) {
			r.setCosto(r.getCosto()*0.8f);
		 
			
		}
		
		
	}

}
