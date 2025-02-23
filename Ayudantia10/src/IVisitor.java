// lo que puede visitar, sobrecarga.
public interface IVisitor {
	
	void visitar(Vista v);
	void visitar(Corriente c);
	void visitar(Ahorros a);
}
