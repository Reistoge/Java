
public class PedidoProcessor {
	// Strategy manager
	Processor process;
	public void setStrategy(Processor procesamiento) {
		// TODO Auto-generated method stub
		this.process=procesamiento;
	}

	public void procesar(Pedido p) {
		// TODO Auto-generated method stub
		this.process.ejecutar(p);
	}
 

}
class PedidoEstandarProcessing  implements Processor{

	@Override
	public void ejecutar(Pedido p) {
		// codigo que definira los dias
		p.diasRestantes=7;
	}

}
class PedidoExpressProcessing implements Processor{

	 

	@Override
	public void ejecutar(Pedido p) {
		// codigo que definira los dias.
		p.diasRestantes=3;
	}

}

interface Processor {
	void ejecutar(Pedido p);
}
