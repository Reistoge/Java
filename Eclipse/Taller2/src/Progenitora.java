//Ferran Rojas Rut: 21.642.668-1
//Maximo Sarno Rut: 21.853.202-0
//Vicente Melendez Rut: 21.661.220-5
import java.util.ArrayList;

public class Progenitora {
	String nombre, rut, rutPareja, rutMadre;
	int edad;
	int nHijos;

	ArrayList<Descendiente> hijos;
	ArrayList<Progenitor> hijosProgenitor;
	ArrayList<Progenitora> hijosProgenitora;

	public Progenitora(String nombre, int edad, String rut, String rutPareja, String rutMadre) {
		this.nombre = nombre;
		this.rut = rut;
		this.rutPareja = rutPareja;
		this.rutMadre = rutMadre;
		this.edad = edad;
		this.nHijos = 0;
		hijos = new ArrayList<Descendiente>();
		hijosProgenitor = new ArrayList<Progenitor>();
		hijosProgenitora = new ArrayList<Progenitora>();
	}

	public Progenitora() {
		this.nombre = null;
		this.rut = null;
		this.rutPareja = null;
		this.rutMadre = null;
		this.edad = 0;
		this.nHijos = 0;
	}

	public void mostrarMadre(ArrayList<Progenitora> progenitoras) {
		// recorremos arrayList progenitoras y si la progenitora coincide con el rut de
		// la madre de la Progenitora entonce es su madre una progenitora puede tener
		// solamente una madre debido a las progenitoras solo tienen rut madre, tomando
		// en cuenta esto el programa deberia tener solamente abuelas.

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
				// si el rut de la madre de esta progenitora (this) coincide con el rut de
				// instancia p de progenitoras
				if (this.getRutMadre().equals(p.getRut())) {
					// es madre
					System.out.println(p.toString());
					exception = false;
					break;
				}

			}
			
			// si en este caso la persona tiene el rut de la madre asociado pero no se ha
			// encontrado en progenitoras ( no se ha añadido todavia ) .
			// es porque la madre todavia no ha sido ingresada o almacenada dentro de
			// progenitoras si no que solo esta como dato dentro del progenitor.

			if (exception) {
				System.out.println("Rut: " + this.getRutMadre());
				System.out.println("No existen más datos de la madre de " + this.getNombre() + "\n "
						+ "Esto sucede ya que el rut del madre esta identificado como dato dentro de la Progenitora"
						+ this.getNombre() + "\n" + "pero no se ha encontrado a la progenitora con este rut\n"
						+ "Se debe agregar una progenitora con este rut " + this.getRutMadre() + " (rut de la madre de "
						+ this.getNombre() + " desde el programa o añadirlo al txt.\n");

			}
		}

	}

	public void mostrarPareja(ArrayList<Progenitor> progenitores, ArrayList<Progenitora> progenitoras) {
		// Esta funcion se encarga de mostrar al usuario la pareja de la progenitora,
		// para esto necesitamos las dos listas que contienen a los progenitores si en
		// estas listas encontramos una instancia en la cual en el atributo rutPareja
		// coincide con el atributo "rut" de esta instancia la cual fue invocada este
		// metodo entonces se encontro la pareja.en caso de que no se encuentre el rut
		// de la pareja pero si esta identificado se le explica al usuario crear la
		// pareja.
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
			// el rut esta identificado pero no se ha encontrado a la persona
			if (exception) {
				System.out.println("Rut: " + this.getRutPareja());
				System.out.println("No existen más datos de la pareja de " + this.getNombre() + "\n "
						+ "Esto sucede ya que el rut de la pareja esta identificado como dato dentro de la progenitora "
						+ this.getNombre() + "\n" + "pero no se ha encontrado al progenit@r con este rut\n"
						+ "Se debe agregar un progenit@r con este rut " + this.getRutPareja()
						+ " (rut del progenit@r de " + this.getNombre() + ") desde el programa o añadirlo al txt.\n");

			}

		}

	}

	public void mostrarHermanos(ArrayList<Progenitora> hermanas, ArrayList<Progenitor> hermanos) {
		// Para que una progenitora tenga un herman@ este debe tener el mismo rut de la
		// madre para esto recorremos las listas hermanos y hermanas que serian clases
		// Progenitor y Progenitora, esto se debe a que una instancia Progenitora tiene
		// un herman@ cuando otras instancias Progenitor/a coincide con el mismo
		// rutMadre.

		// primero verificamos si el rut esta identificado,
		// si no esta identificado no seria necesario buscar
		// sus hermanos (no tenemos el rut de la madre).
		if (this.rutMadre.toLowerCase().equals("no-identificada")) {
			System.out.println("\n    Madre no identificada\n");
		} else {

			// buscamos a las hermanas
			for (Progenitora p : hermanas) {
				// si encontramos otra instancia Progenitora dentro de hermanas que coincide
				// con el mismo rutMadre de esta Progenitora.
				if (this.rutMadre.equals(p.getRutMadre()) && !p.getRut().equals(this.getRut())) {
					// se encontro a la hermana
					System.out.println(p.toString());

				}
			}
			// ahora buscamos a los hermanos
			for (Progenitor p : hermanos) {
				// si encontramos otra instancia Progenitor dentro de hermanos que coincide
				// con el mismo rutMadre de esta Progenitora
				if (this.rutMadre.equals(p.getRutMadre()) && !p.getRut().equals(this.getRut())) {
					// se encontro al hermano
					System.out.println(p.toString());
				}
			}

		}
	}

	public void buscarHijos(ArrayList<Descendiente> descendientes, ArrayList<Progenitora> progenitoras,
			ArrayList<Progenitor> progenitores) {
		// se buscan y se muestran al usuario los descendientes de la progenitora para
		// esto se recorre las 3 listas (descendientes, progenitoras y progenitores ) y
		// se verifica si el rut madre de esta persona coincide con el rut de esta
		// instancia (this)

		this.nHijos = 0;
		for (Descendiente d : descendientes) {
			// si el atributo rutMadre de la instancia d coincide con el rut de esta
			// persona.
			if (d.getRutMadre().equals(this.rut)) {
				// se encontro un descendiente de esta progenitora
				this.nHijos++;
				// muestra al descendiente al usuario
				System.out.println(d.toString());
			}
		}
		// buscamos a los hijos que esten dentro de las listas de progenitoras y
		// progenitores
		buscarHijosProgenitoras(progenitoras, progenitores);

	}

	public void buscarHijosProgenitoras(ArrayList<Progenitora> progenitoras, ArrayList<Progenitor> progenitores) {
		// esta funcion se encarga de buscar a los progenitores y progenitoras el cual
		// en su atributo rut madre coincida con alguna de las instancias de
		// progenitora, esta funcion es unica de progenita ya que solo existen
		// rutMadres.osea solamente buscamos a más descendientes pero que esten en las
		// otras listas.
		this.hijosProgenitor = new ArrayList<Progenitor>();
		this.hijosProgenitora = new ArrayList<Progenitora>();

		for (Progenitora d : progenitoras) {
			// si se encuentra a una progenitora la cual su rutMadre
			// coincida con el rut de esta progenitora
			if (d.getRutMadre().equals(this.rut) && !this.nombre.equals(d.getNombre())) {
				// esta progenitora es abuela !
				this.nHijos++;
				this.hijosProgenitora.add(d);
				System.out.println(d.toString());
			}
		}
		for (Progenitor d : progenitores) {
			// si se encuentra a un progenitor la cual su rutMadre coincida con el rut de
			// esta progenitora
			if (d.getRutMadre().equals(this.rut) && !this.nombre.equals(d.getNombre())) {
				// esta progenitora es abuela !
				this.nHijos++;
				this.hijosProgenitor.add(d);
				System.out.println(d.toString());
			}
		}
	}

	public void contarHijos(ArrayList<Descendiente> descendientes, ArrayList<Progenitora> progenitoras,
			ArrayList<Progenitor> progenitores) {
		// se cuentan los descendientes de la progenitora para esto se recorre las 3
		// listas y se verifica si el rut madre de esta persona coincide con el rut de
		// esta instancia (this)

		this.nHijos = 0;
		hijos = new ArrayList<Descendiente>();
		for (Descendiente d : descendientes) {
			if (d.getRutMadre().equals(this.rut)) {
				this.nHijos++;
				hijos.add(d);
			}
		}
		// contamos a los descendientes que sean progenitores y progenitoras
		contarHijosProgenitoras(progenitoras, progenitores);

	}

	public void contarHijosProgenitoras(ArrayList<Progenitora> progenitoras, ArrayList<Progenitor> progenitores) {
		// esta funcion solo añade a la lista a los descendientes de la progenitora, se
		// usa para rellenas las listas hijosProgenitor e hijosProgenitora.
		this.hijosProgenitor = new ArrayList<Progenitor>();
		this.hijosProgenitora = new ArrayList<Progenitora>();

		for (Progenitora d : progenitoras) {
			if (d.getRutMadre().equals(this.rut) && !this.nombre.equals(d.getNombre())) {
				this.nHijos++;
				this.hijosProgenitora.add(d);

			}
		}
		for (Progenitor d : progenitores) {
			if (d.getRutMadre().equals(this.rut) && !this.nombre.equals(d.getNombre())) {
				this.nHijos++;
				this.hijosProgenitor.add(d);

			}
		}

	}

	public boolean parejaNoIdentificada() {
		// se verifica si el rut de la pareja de la progenitora esta identificado o no.
		if (this.getRutPareja().toLowerCase().equals("no-identificada")) {
			return true;
		} else {
			return false;
		}
	}

	public void esSoltero(ArrayList<Descendiente> descendientes, ArrayList<Progenitora> progenitoras,
			ArrayList<Progenitor> progenitores) {
		// muestra al usuario por parte de cuales hijos es progenitor soltero tomando en
		// cuenta los criterios de progenitora soltera para esto se recorre la lista y
		// si se encuentra una instancia descendiente la cual es hijo de la progenitora
		// pero tiene su padre no identificado entonces se cumple el criterio.

		// contamos los hijos descendientes
		contarHijos(descendientes, progenitoras, progenitores);
		System.out.print(this.toString());
		System.out.println("    Numero de hijos de " + this.nombre + ": " + this.nHijos);
		for (Descendiente d : hijos) {
			// vemos que descendientes cumplen con el criterio
			if (d.rutPadre.toLowerCase().equals("no-identificada")) {
				// el descendiente tiene un padre no identificado, madre soltera.
				System.out
						.println("    " + this.getNombre() + " es Madre soltera por parte de su hij@ " + d.getNombre());

			} else {
				// descendiente tiene un padre identificado es madre con pareja.
				System.out.println(
						"    " + this.getNombre() + " es Madre con pareja por parte de su hij@ " + d.getNombre());
			}
		}
		// confusion : ya que los progenitores solo tienen un rutMadre no se podria
		// aplicar el criterio de progenitora soltera
		// esto es porque si un progenitor/progenitora que sea descendiente de una
		// progenitora solo tendria el rut
		// asociado a su madre por lo tanto por el descendiente al no saber el rut del
		// padre no sabemos si la madre
		// es soltera siguiendo el criterio, deberiamos asumir que el padre de estos
		// desciendes progenitores serian
		// la pareja de esta progenitora pero no siempre es el caso y ademas romperia
		// con el criterio que aplicamos
		// a los descendientes de la lista descendientes
		// EN CASO DE TENER QUE ASUMIR ESTO PARA LOS PROGENITORES EL CODIGO ESTA DEBAJO.

		// mostramos a los hijos progenitores si tambien cumplen el criterio para esto,
		// la pareja de esta progenitora debe ser no identificada
		// ya que esta progenitora es directamente la progenitora.

//		if(this.parejaNoIdentificada()) {
//			// si la pareja de esta progenitora no esta identificada entonces la madre este descendiente no tendria 
//			for(Progenitor p: hijosProgenitor) {
//				System.out.println("    "+this.getNombre()+" es Madre soltera por parte de su hij@ "+p.getNombre());
//			}
//			for(Progenitora p : hijosProgenitora) {
//				System.out.println("    "+this.getNombre()+" es Madre soltera por parte de su hij@ "+p.getNombre());
//			}
//		}
//		else {
//			for(Progenitora p: hijosProgenitora) {
//				System.out.println("    "+this.getNombre()+" es Madre con pareja por parte de su hij@ "+p.getNombre());
//			}
//			for(Progenitor p: hijosProgenitor) {
//				System.out.println("    "+this.getNombre()+" es Madre con pareja por parte de su hij@ "+p.getNombre());
//			}
//		}
	}

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

	public String getRutPareja() {
		return rutPareja;
	}

	public void setRutPareja(String rutPareja) {
		this.rutPareja = rutPareja;
	}

	public String getRutMadre() {
		return rutMadre;
	}

	public void setRutMadre(String rutMadre) {
		this.rutMadre = rutMadre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

}
