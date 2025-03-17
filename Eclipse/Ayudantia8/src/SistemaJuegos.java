import java.util.ArrayList;
import java.util.List;

public class SistemaJuegos implements ISistema{

	List<Videojuego> videojuegos;
	String juegosBusqueda;
	public SistemaJuegos() {
		videojuegos= new ArrayList<Videojuego>();
	}
	 
	@Override
	public boolean ingresarVideojuego(String nextLine) {
		// TODO Auto-generated method stub
		String[] partes= nextLine.split(",");
		if(partes.length==8) {
			Videojuego v=Videojuego.crearVideojuego(partes);
			if(v!=null) {
				videojuegos.add(v);
				return true;
			}
			
			
		}
		return false;
	}

	@Override
	public void eliminarVideojuego(String nombre) {
		for(Videojuego v: videojuegos) {
			if(v.getTitulo().equalsIgnoreCase(nombre)) {
				int i =videojuegos.indexOf(v);
				videojuegos.remove(i);
				break;
			}
		}
		
	}

 
	private void buscarJuegos(String criterio,String busqueda) {
		this.juegosBusqueda="";
		
		for(Videojuego v: videojuegos) {
			
			if(criterio.equalsIgnoreCase("1")) {
				// criterio por desarrollador
				if(v.desarrollador.equalsIgnoreCase(busqueda)) {
					this.juegosBusqueda+=v.getInfo();
					 
				}
			}
			else if(criterio.equalsIgnoreCase("2")) {
				// criterio por jugado;
				if(v.estado.equalsIgnoreCase("no jugados") && v.releaseDate.equalsIgnoreCase(busqueda)) {
					this.juegosBusqueda+=v.getInfo();
					 
				}
				
			}
			 
			
			
			
		}
		
		
	}
	 
	

	@Override
	public String busqueda(String criterio,String busqueda) {
		buscarJuegos(criterio,busqueda);
		return this.juegosBusqueda;
	}

	@Override
	public String noJugados(String tipo) {
		// TODO Auto-generated method stub
		String info="";
		for(Videojuego v : videojuegos) {
			if(v.getTipo().equalsIgnoreCase(tipo) && v.getEstado().equalsIgnoreCase("no jugado")){
				info+=v.getInfo();
			}
		}
		return info;
	}

	@Override
	public int tiempoTotalRpg( ) {
		
		int tiempo = 0;
		for(Videojuego v : videojuegos) {
			if(v.getTipo().equalsIgnoreCase("rpg") && v.getEstado().equalsIgnoreCase("no jugado")){
				Rpg rpg= (Rpg) v;
				tiempo+=Integer.parseInt(rpg.duracion);
			}
		}
		return tiempo;
	}

	 

}
