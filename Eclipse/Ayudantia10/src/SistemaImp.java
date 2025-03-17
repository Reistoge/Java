import java.util.ArrayList;
import java.util.List;

public class SistemaImp implements ISistema {
	
	List<Cuenta> cuentas;
	VisitorCuentas visitor;
	CuentaFactory factoryCuentas;
	public SistemaImp() {
		visitor = new VisitorCuentas();
		factoryCuentas= new CuentaFactory();
		cuentas = new ArrayList<Cuenta>();
	}
	public void addCuenta(String[] datos) {
		Cuenta c =factoryCuentas.crearCuenta(datos);
		cuentas.add(c);
		
	}
	public void calcularIntereses() {
		for(Cuenta c : cuentas) {
			 c.calcularInteres(visitor);
		}
	}
	public String mostrarCuentas() {
		String out="";
		for(Cuenta c : cuentas) {
			out+=c.toString()+"\n";
		}
		return out;
	}
	
	
	
	
	
}
