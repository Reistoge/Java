package implementacionYagregacionDeClases;

import java.util.Arrays;

public class ListaPersonas {
	
	Persona listaPersonas[];
	int cantMaxPersonas;
	int cantPersonas;
	public ListaPersonas(int cMax) {
		cantMaxPersonas=cMax;
		listaPersonas=new Persona[cMax];
		cantPersonas=0;
		
	}
	
	public boolean registrarPersona(Persona P) {
		// metodo estricto no es dinamico 
		if(cantMaxPersonas==cantPersonas) {
			return false;
		}
		cantPersonas+=1;
		listaPersonas[cantPersonas-1]=P;
		return true;
		
	}
	public int getCantMaxPersonas() {
		return cantMaxPersonas;
	}

	@Override
	public String toString() {
		return "ListaPersonas [listaPersonas=" + Arrays.toString(listaPersonas) + ", cantMaxPersonas=" + cantMaxPersonas
				+ ", cantPersonas=" + cantPersonas + "]";
	}

	public void setCantMaxPersonas(int cantMaxPersonas) {
		this.cantMaxPersonas = cantMaxPersonas;
	}

	public boolean eliminarPersona(String rut) {
		 // dinamico
		// este si funciona
		for(int i=0;i<this.cantPersonas;i++) {
			if(listaPersonas[i].rut.equals(rut)) {
				listaPersonas[i]=null;
				
			}
		}
		ordenarLista();
		// probablemente se mande como valor en vez de referencia el objeto
//		for(Persona p : listaPersonas) {
//			if(p.rut.equals(rut)) {
//				p=null; // this doesnt happen 
//				p.rut=""; // this happen
//				return true;
//			}
//			
//		}
		return false;
		
		
		
	}
	public void agregarPersona(Persona P) {
		// dinamico: crear una copia
		Persona[] nuevaLista= new Persona[listaPersonas.length+1];
		// creamos una lista más grande
		for(int i=0;i<listaPersonas.length;i++) {
			// igualamos cada indice
			nuevaLista[i]=listaPersonas[i];
		}
		nuevaLista[listaPersonas.length]=P;
		
		listaPersonas=nuevaLista;
		cantPersonas=getCantPersonas();
		cantMaxPersonas+=1;
		
	}
	
	public Persona ObtenerPersona(int pos) {
		if(pos>=cantMaxPersonas || pos<0) {
			return null;
		}
		else {
			return listaPersonas[pos];
			
		}
		
	}
	public int getCantPersonas() {
		int n=0;
		for(int i=0;i<listaPersonas.length;i++) {
			// si se topa con algo que no es vacio seria una persona
			if(listaPersonas[i]!=null) {
				n++;
			}
		}
		return n;
	}
	public void ordenarLista() {
		// dinamico
		Persona[] nuevaLista=new Persona[getCantPersonas()];
		int n=0;
		// creamos una lista del tamaño de cantidad de personas;
		for(int i=0;i<listaPersonas.length;i++) {
			// por cada persona se la añadimos a nuestro nuevo arreglo con un contador 
			// evitando asi el error de index y le sumamos
			
			if(listaPersonas[i]!=null) {
				nuevaLista[n]=listaPersonas[i];
				n++;
			}
			
		}
		listaPersonas=nuevaLista;
		cantMaxPersonas=listaPersonas.length;
		cantPersonas=getCantPersonas();
				
	}
	
	
}
