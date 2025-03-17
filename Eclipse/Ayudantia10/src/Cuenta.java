
public abstract class Cuenta {
	
	String nombreTitular;
	String tipoCuenta;
	double saldo;
	double interes;
	abstract void calcularInteres(IVisitor v);
	public String getNombreTitular() {
		return nombreTitular;
	}
	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}
	public String getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public double getInteres() {
		return interes;
	}
	public void setInteres(double interes) {
		this.interes = interes;
	}
	
}
class Ahorros extends Cuenta{
	
	double interesMensual;
	public Ahorros(String nombre, String tipo, double saldoInicial, String parametroExtra) {
		this.nombreTitular= nombre;
		this.tipoCuenta= tipo;
		this.saldo= saldoInicial;
		this.interes=0D;
		this.interesMensual= Double.parseDouble(parametroExtra);
	}
	public double getInteresMensual() {
		return interesMensual;
	}
	public void setInteresMensual(double interesMensual) {
		this.interesMensual = interesMensual;
	}
	@Override
	public String toString() {
		return "Ahorros [interesMensual=" + interesMensual + ", nombreTitular=" + nombreTitular + ", tipoCuenta="
				+ tipoCuenta + ", saldo=" + saldo + ", interes=" + interes + "]";
	}
	@Override
	void calcularInteres(IVisitor v) {
		// TODO Auto-generated method stub
		v.visitar(this);
	}


	
	 

}
class Corriente extends Cuenta{
	public Corriente(String nombre, String tipo, double saldoInicial, String parametroExtra) {
		this.nombreTitular= nombre;
		this.tipoCuenta= tipo;
		this.saldo= saldoInicial;
		this.interes=0D;
		this.tarifaMensual= Double.parseDouble(parametroExtra);
	}

	double tarifaMensual;

	@Override
	public String toString() {
		return "Corriente [tarifaMensual=" + tarifaMensual + ", nombreTitular=" + nombreTitular + ", tipoCuenta="
				+ tipoCuenta + ", saldo=" + saldo + ", interes=" + interes + "]";
	}

	public double getTarifaMensual() {
		return tarifaMensual;
	}

	public void setTarifaMensual(double tarifaMensual) {
		this.tarifaMensual = tarifaMensual;
	}

	@Override
	void calcularInteres(IVisitor v) {
		v.visitar(this);
	}
	 

}
class Vista extends Cuenta{
	 
	String tipoTarjeta;
	public Vista(String nombre, String tipo, double saldoInicial, String parametroExtra) {
		this.nombreTitular= nombre;
		this.tipoCuenta= tipo;
		this.saldo= saldoInicial;
		this.interes=0D;
		this.tipoTarjeta= (parametroExtra);
	}
	@Override
	public String toString() {
		return "Vista [tipoTarjeta=" + tipoTarjeta + ", nombreTitular=" + nombreTitular + ", tipoCuenta=" + tipoCuenta
				+ ", saldo=" + saldo + ", interes=" + interes + "]";
	}
	public String getTipoTarjeta() {
		return tipoTarjeta;
	}
	public void setTipoTarjeta(String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}
	@Override
	void calcularInteres(IVisitor v) {
		// TODO Auto-generated method stub
		v.visitar(this);
	}

	 

}
