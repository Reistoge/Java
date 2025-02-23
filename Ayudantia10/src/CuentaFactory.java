import java.util.List;

public class CuentaFactory {
	
	public Cuenta crearCuenta(String[] datosCuenta) {
		String nombre=datosCuenta[0];
		String tipo=datosCuenta[1];
		double saldoInicial=Double.parseDouble(datosCuenta[2]);
		String parametroExtra=datosCuenta[3];
		Cuenta c = null;
		if("Savings".equalsIgnoreCase(tipo)) {
			c= new Ahorros(nombre, tipo, saldoInicial, parametroExtra);
		}
		else if("Checking".equalsIgnoreCase(tipo)) {
			c= new Corriente(nombre,tipo,saldoInicial, parametroExtra);
		}
		else if("Vista".equalsIgnoreCase(tipo)) {
			c= new Vista(nombre,tipo,saldoInicial,parametroExtra);
		}
		return c;
		
		
	}
	
	
	
	
}
