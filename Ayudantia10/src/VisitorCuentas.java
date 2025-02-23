import java.util.List;

public class VisitorCuentas implements IVisitor
{
	

	@Override
	public void visitar(Ahorros a) {
		a.setInteres(a.getInteresMensual()*a.getSaldo());
	}

	@Override
	public void visitar(Corriente c) {
			c.setInteres(c.getTarifaMensual()-c.getSaldo());
	}

	@Override
	public void visitar(Vista v) {
		if(v.tipoTarjeta.equalsIgnoreCase("débito")) {
			v.setInteres(v.getSaldo()*0.3f);
		}
		else if(v.tipoTarjeta.equalsIgnoreCase("crédito")) {
			v.setInteres(v.getSaldo()-200);
			
		}
	}
	
	
	
}
