
public interface AlimentacionStrategy {
	// una estrategia se aplicara segun un contexto el cual sera entregado o
	// proporcionado por el usuario
	public boolean puedeComer(Animal animal, Animal otro);
}
