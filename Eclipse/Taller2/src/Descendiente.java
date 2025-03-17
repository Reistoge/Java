// Ferran Rojas Rut: 21.642.668-1
// Maximo Sarno Rut: 21.853.202-0
// Vicente Melendez Rut: 21.661.220-5
import java.util.ArrayList;


public class Descendiente {
	String nombre, rut, rutMadre, rutPadre;
	int edad;

	public Descendiente(String nombre, int edad, String rut, String rutMadre, String rutPadre) {
		this.nombre = nombre;
		this.rut = rut;
		this.rutMadre = rutMadre;
		this.rutPadre = rutPadre;
		this.edad = edad;
	}

	public void buscarHermanos(ArrayList<Descendiente> descendientes) {
		// se buscan y se muestran al usuario los hermanos de este descendientes usando
		// la lista de "descendientes" como parametro para esto se recorre la lista y si
		// algun otra instancia descendiente coincide con el mismo rutMadre o rutPadre
		// entonces son hermanos
		for (Descendiente d : descendientes) {
			// por cada descendiente d en descendientes

			// si alguno de los ruts de los progenitores coinciden y no es la misma
			// instancia
			if ((d.getRutMadre().equals(this.getRutMadre()) || d.getRutPadre().equals(this.getRutPadre()))
					&& d.getRut() != this.getRut()) {
				// si coinciden en rut madre y ademas el rut esta identificado
				if (d.getRutMadre().equals(this.getRutMadre())
						&& !this.getRutMadre().toLowerCase().equals("no-identificada")) {
					System.out.println(d.toString());
				}
				// si coinciden en rut Padre y ademas el rut esta identificado
				else if (d.getRutPadre().equals(this.getRutPadre())
						&& !this.getRutPadre().toLowerCase().equals("no-identificada")) {
					System.out.println(d.toString());
				}
			}

		}

	}

	public void mostrarPadre(ArrayList<Progenitor> progenitores) {
		// se busca y muestra al usuario el padre/progenitor del descendiente para esto
		// hacemos uso de la lista progenitores la cual la recorremos hasta encontrar
		// una instancia la cual en su atributo "rut" coincida con el rutPadre de este
		// descendiente.
		boolean exception = true;
		if (this.getRutPadre().toLowerCase().equals("no-identificada")) {
			System.out.println("    RUT PROGENITOR NO IDENTIFICADO\n");

		} else {
			// por cada instancia en progenitores en la lista
			for (Progenitor p : progenitores) {
				// si encontramos una instancia que cumpla con el criterio mostramos la
				// informacion al usuario.
				if (this.getRutPadre().equals(p.getRut())) {
					// rutPadre de la instancia coincide con el atributo rut de una instancia p de
					// progenitores, p entonces es padre.
					// es padre
					exception = false;
					System.out.println(p.toString());
					break;
				}

			}
			// si en este caso la persona tiene el rut del padre asociado pero no se ha
			// encontrado en progenitores ( no se ha añadido todavia ) .
			// es porque el padre todavia no ha sido ingresado o almacenado dentro de
			// progenitores si no que solo esta como dato dentro del descendiente.

			if (exception) {
				System.out.println("Rut: " + this.getRutPadre());
				System.out.println("No existen más datos del padre de " + this.getNombre() + "\n "
						+ "Esto sucede ya que el rut del padre esta identificado como dato dentro del descendiente"
						+ this.getNombre() + "\n" + "pero no se ha encontrado al progenitor con este rut\n"
						+ "Se debe agregar un progenitor con este rut " + this.getRutPadre() + " (rut del padre de "
						+ this.getNombre() + " desde el programa o añadirlo al txt.\n");

			}

		}
	}

	public void mostrarMadre(ArrayList<Progenitora> progenitoras) {
		// Se busca y muestra al usuario el madre/progenitora del descendiente para esto
		// hacemos uso de la lista “progenitoras” la cual almacena instancias de la
		// clase Progenitora recorreremos esta lista hasta encontrar una instancia la
		// cual en su atributo "rut" coincida con el “rutMadre” de este descendient
		boolean exception = true;
		if (this.getRutMadre().toLowerCase().equals("no-identificada")) {
			System.out.println("    RUT PROGENITORA NO IDENTIFICADO");

		}

		else {
			// por cada instancia Progenitora p en lista progenitoras
			for (Progenitora p : progenitoras) {
				if (this.getRutMadre().equals(p.getRut())) {
					// rutMadre de esta instancia coincide con el atributo rut de una instancia p de
					// progenitoras, p entonces es Madre.
					// es Madre
					System.out.println(p.toString());
					exception = false;
					break;
				}

			}
			// si en este caso la persona tiene el rut de la madre asociado pero no se ha
			// encontrado en progenitoras ( no se ha añadido todavia ) .
			// es porque la madre todavia no ha sido ingresada o almacenada dentro de
			// progenitoras esta madre solo esta como dato dentro del descendiente.
			if (exception) {
				System.out.println("Rut: " + this.getRutMadre());
				System.out.println("No existen más datos de la madre de " + this.getNombre() + "\n "
						+ "Esto sucede ya que el rut del madre esta identificado como dato dentro del descendiente"
						+ this.getNombre() + "\n" + "pero no se ha encontrado a la progenitora con este rut\n"
						+ "Se debe agregar una progenitora con este rut " + this.getRutMadre() + " (rut de la madre de "
						+ this.getNombre() + " desde el programa o añadirlo al txt.\n");

			}

		}
	}

	@Override
	public String toString() {
		return "\n    Rut: " + this.getRut() + "\n    Nombre: " + this.getNombre() + "\n    Edad: " + this.getEdad()
				+ "\n    Rut Madre: " + this.getRutMadre() + "\n    Rut Padre: " + this.getRutPadre() + "\n";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getRutMadre() {
		return rutMadre;
	}

	public void setRutMadre(String rutMadre) {
		this.rutMadre = rutMadre;
	}

	public String getRutPadre() {
		return rutPadre;
	}

	public void setRutPadre(String rutPadre) {
		this.rutPadre = rutPadre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
}
