//Ferran Rojas Rut: 21.642.668-1
//Maximo Sarno Rut: 21.853.202-0
//Vicente Melendez Rut: 21.661.220-5
import java.util.ArrayList;

public class Progenitor {
	String nombre, rut, rutMadre, rutPareja;
	int edad;
	int nHijos;
	ArrayList<Descendiente> hijos;

	public Progenitor(String nombre, int edad, String rut, String rutMadre, String rutPareja) {
		this.nombre = nombre;
		this.rut = rut;
		this.rutMadre = rutMadre;
		this.rutPareja = rutPareja;
		this.edad = edad;
		hijos = new ArrayList<Descendiente>();

	}

	public Progenitor() {
		this.nombre = null;
		this.rut = null;
		this.rutMadre = null;
		this.rutPareja = null;
		this.edad = 0;
		this.nHijos = 0;

	}

	public void mostrarMadre(ArrayList<Progenitora> progenitoras) {
		// recorremos arrayList progenitoras y si la progenitora coincide con el rut de
		// la madre del Progenitor entonce es su madre un progenitor puede tener
		// solamente una madre debido a que los progenitores solo tienen rut madre,
		// tomando en cuenta esto el programa deberia tener solamente abuelas.

		boolean exception = true;

		if (this.getRutMadre().toLowerCase().equals("no-identificada")) {
			// antes de recorrer el array por completo, verificamos
			// si esta identificada el rut de la madre, en caso de que el rut sea
			// NO-IDENTIFICADA no es necesario recorrer el arrayList
			System.out.println("    RUT PROGENITORA NO IDENTIFICADO");

		}

		else {
			// por cada instancia del arraylist progenotitoras
			for (Progenitora p : progenitoras) {
				// si el rut de la madre de este progenitor (this) coincide con el rut de
				// instancia p de progenitoras
				if (this.getRutMadre().equals(p.getRut())) {
					// es madre
					System.out.println(p.toString());
					exception = false;
					break;
				}

			}
			// si en este caso la persona tiene el rut de la madre asociado pero no se ha
			// encontrado en progenitoras.
			// es porque la madre todavia no ha sido ingresada o almacenada dentro de
			// progenitoras si no que solo esta como dato dentro del progenitor.
			if (exception) {
				System.out.println("Rut: " + this.getRutMadre());
				System.out.println("No existen más datos de la madre de " + this.getNombre() + "\n "
						+ "Esto sucede ya que el rut del madre esta identificado como dato dentro del Progenitor"
						+ this.getNombre() + "\n" + "pero no se ha encontrado a la progenitora con este rut\n"
						+ "Se debe agregar una progenitora con este rut " + this.getRutMadre() + " (rut de la madre de "
						+ this.getNombre() + " desde el programa o añadirlo al txt.\n");

			}
		}

	}

	public void mostrarHermanos(ArrayList<Progenitora> hermanas, ArrayList<Progenitor> hermanos) {
		// Para que un progenitor tenga un herman@ este debe tener el mismo rut de la
		// madre para esto recorremos las listas hermanos y hermanas que serian clases
		// Progenitor y Progenitora, esto se debe a que una instancia Progenitor tiene
		// un herman@ cuando otras instancias Progenitor/a coincide con el mismo
		// rutMadre.

		// primero verificamos si el rut esta identificado,
		// si no esta identificado no seria necesario buscar
		// sus hermanos (no tenemos el rut de la madre).
		if (this.rutMadre.toLowerCase().equals("no-identificada")) {
			System.out.println("    RUT MADRE NO IDENTIFICADA\n");
		} else {
			// buscamos a las hermanas
			for (Progenitora p : hermanas) {
				// si encontramos otra instancia Progenitora dentro de hermanas que coincide
				// con el mismo rutMadre de este Progenitor.
				if (this.rutMadre.equals(p.getRutMadre()) && !p.getRut().equals(this.getRut())) {
					// se encontro a una hermana
					System.out.println(p.toString());

				}
			}
			// ahora buscamos a los hermanos
			for (Progenitor p : hermanos) {
				// si encontramos otra instancia Progenitor dentro de hermanos que coincide con
				// el mismo rutMadre de este Progenitor
				if (this.rutMadre.equals(p.getRutMadre()) && !p.getRut().equals(this.getRut())) {
					// se encontro a un hermano
					System.out.println(p.toString());
				}
			}

		}
	}

	public void mostrarPareja(ArrayList<Progenitora> progenitoras, ArrayList<Progenitor> progenitores) {
		// Esta funcion se encarga de mostrar al usuario la pareja del progenitor, para
		// esto necesitamos las dos listas que contienen a los progenitores si en estas
		// listas encontramos una instancia en la cual en el atributo rutPareja coincide
		// con el atributo "rut" esta instancia la cual fue invocado este metodo
		// entonces se encontro la pareja. en caso de que no se encuentre el rut de la
		// pareja pero si esta identificado se le explica al usuario crear la pareja.

		boolean exception = true;
		boolean homo = false;
		// si la pareja no esta identificada entonces no necesitamos recorrer las
		// listas.
		if (this.rutPareja.toLowerCase().equals("no-identificada")) {
			// 4 espacios
			System.out.println("    NO-IDENTIFICADA");
			homo = false;
			exception = false;
		}
		// el rut existe
		else {
			// por cada progenitor buscar si existe una instancia
			// que su rut pareja coincida con el rut de la persona (this)
			for (Progenitor p : progenitores) {
				if (p.getRut().equals(this.rutPareja)) {
					System.out.println(p.toString());
					homo = false;
					exception = false;
					break;
				}

			}
			// por cada progenitora buscar si existe una
			// instancia que su rur pareja coincida con el rut de la persona (this)
			for (Progenitora p : progenitoras) {
				if (p.getRut().equals(this.rutPareja)) {
					System.out.println(p.toString());
					homo = true;
					exception = false;
					break;
				}

			}

		}
		// el rut esta identificado pero no se ha encontrado a la persona
		if (exception) {
			System.out.println("Rut: " + this.getRutPareja());
			System.out.println("No existen más datos de la pareja de " + this.getNombre() + "\n "
					+ "Esto sucede ya que el rut de la pareja esta identificado como dato dentro de la progenitora "
					+ this.getNombre() + "\n" + "pero no se ha encontrado al progenit@r con este rut\n"
					+ "Se debe agregar un progenit@r con este rut " + this.getRutPareja() + " (rut del progenit@r de "
					+ this.getNombre() + ") desde el programa o añadirlo al txt.\n");

		}

	}

	public void buscarHijos(ArrayList<Descendiente> descendientes) {
		// se buscan y se muestran al usuario los descendientes del progenitor para esto
		// se recorre la lista descendientes y se verifica si el rut padre de esta
		// persona coincide con el rut de esta instancia (this)

		this.nHijos = 0;
		for (Descendiente d : descendientes) {

			// si el atributo rutPadre de la instancia d coincide con el rut de esta
			// persona.
			if (d.getRutPadre().equals(this.rut)) {
				// se encontro un descendiente de este progenitor
				this.nHijos++;
				// muestra al descendiente al usuario
				System.out.println(d.toString());
			}
		}

	}

	public void contarHijos(ArrayList<Descendiente> descendientes) {
		// se cuentan los descendientes del progenitor para esto se recorre la lista
		// descendientes y se verifica si el rut padre de esta persona coincide con el
		// rut de esta instancia (this)
		this.nHijos = 0;
		hijos = new ArrayList<Descendiente>();
		for (Descendiente d : descendientes) {
			// si el atributo rutPadre de la instancia d coincide con el rut de esta
			// persona.
			if (d.getRutPadre().equals(this.rut)) {
				// se encontro un descendiente de este progenitor
				this.nHijos++;
				// muestra al descendiente al usuario
				this.hijos.add(d);
			}
		}

	}

	public void esSoltero(ArrayList<Descendiente> descendientes) {
		// muestra al usuario por parte de cuales es hijos es progenitor soltero tomando
		// en cuenta los criterios de progenitor soltero para esto se recorre la lista y
		// si se encuentra una instancia descendiente la cual es hijo del progenitor
		// pero tiene su madre no identificada entonces se cumple el criterio

		// primero rellenamos la lista de los hijos del progenitor.
		contarHijos(descendientes);
		System.out.print(this.toString());
		System.out.println("    Numero de hijos de " + this.nombre + ": " + this.nHijos);
		for (Descendiente d : this.hijos) {

			if (d.rutMadre.toLowerCase().equals("no-identificada")) {
				// el descendiente no tiene una progenitora identificada, progenitor soltero por
				// parte de este descendiente
				System.out
						.println("    " + this.getNombre() + " es Padre soltero por parte de su hij@ " + d.getNombre());

			} else {
				// el descendiente tiene una progenitora identificada, no es progenitor soltero
				// por parte de este descendiente
				System.out.println(
						"    " + this.getNombre() + " es Padre con pareja por parte de su hij@ " + d.getNombre());
			}
		}
	}

	public boolean parejaNoIdentificada() {
		// se verifica si el rut de la pareja del progenitor esta identificado o no.
		if (this.getRutPareja().toLowerCase().equals("no-identificada")) {
			return true;
		} else {
			return false;
		}
	}

	// getters && setters
	@Override
	public String toString() {

		return "\n    Rut: " + this.getRut() + "\n    Nombre: " + this.getNombre() + "\n    Edad: " + this.getEdad()
				+ "\n    Rut Madre: " + this.getRutMadre() + "\n    Rut Pareja: " + this.getRutPareja() + "\n";
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

	public String getRutPareja() {
		return rutPareja;
	}

	public void setRutPareja(String rutPareja) {
		this.rutPareja = rutPareja;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

}
