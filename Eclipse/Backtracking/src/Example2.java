import java.util.Arrays;

public class Example2 {
//	 Implemente la función 
//	 int vueltosPosibles(int[] monedas, int monto)
//	 que retorne el número de formas posibles en que
//	 podemos formar monto de vuelto a partir de las monedas 
//	 presentes en monedas. 
//	 Por ejemplo
//	 int[] monedas = { 100 };
//	 System.out.println(vueltosPosibles(monedas, 1000)); // debe retornar 1
//	 int[] monedas2 = { 1,10,50,100 };
//	 System.out.println(vueltosPosibles(monedas2, 1000)); // debe retornar 4246

	public static void main(String[] args) {

		int[] monedas = {100,200};
		System.out.println(vueltosPosibles(monedas, 500));
		// 100*5
		// 250*2
		// 100*3 + 200
		// 200*2 + 100
	}

	public static int vueltosPosibles(int monedas[], int monto) {
		if (monedas.length == 0) {
			// Si no nos quedan monedas, entonces hay que ver:
			// Si no quedan monedas y no queda monto para restar, éxito
			if (monto == 0)
				return 1;
			return 0;
		}
		// Vamos a probar todas las formas posibles con moneda[0]
		int moneda = monedas[0];
		monedas = Arrays.copyOfRange(monedas, 1, monedas.length);
		int maxCantidad = monto / moneda;
		int cantidad = 0;
		for (int i = 0; i <= maxCantidad; i++) {
			// Esta es la cantidad que le vamos a quitar a MONTO
			// al llamarnos recursivamente
			int aRestar = moneda * i;
			cantidad += vueltosPosibles(monedas, monto - aRestar);
		}
		return cantidad;
	}
	 
}
