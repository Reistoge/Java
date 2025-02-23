import java.util.ArrayList;
import java.util.List;

public class SistemaPeliculas implements ISistema{
	List<Pelicula> peliculas;
	List<Cartelera> cine;
	List<String> actores;
		
	public SistemaPeliculas() {
		peliculas=new ArrayList<Pelicula>();
		cine= new ArrayList<Cartelera>();
		actores= new ArrayList<String>();
	}
	@Override
	public void ingresarPelicula(String line) {		 
			Pelicula p =Pelicula.crearPelicula(line);
			peliculas.add(p);
	}

	@Override
	public boolean eliminarPelicula(String input) {
		Pelicula p= buscarPelicula(input);
		if(p!=null) {
			peliculas.remove(peliculas.indexOf(p));
			for(Cartelera c : cine) {
				int index=c.getPeliculas().indexOf(p);
				if(index!=-1) {
					c.getPeliculas().remove(p);
					continue;
				}
				
			}
			return true;
		}
		return false;
		 
	}

	@Override
	public String mostrarPeliculasPorCriterio(String criterio,String busqueda) {
		String output="";
		if("1".equalsIgnoreCase(criterio)) {
			for(Pelicula p: peliculas) {
				if(p.año.equalsIgnoreCase(busqueda)) {
					output+=p.getInfo();
				}
			}
			return output;
		}
		else if("2".equalsIgnoreCase(criterio)) {
			for(Pelicula p: peliculas) {
				if(p.generos.contains(busqueda)) {
					output+=p.getInfo();
				}
			}
			return output;
		}
		else if("3".equalsIgnoreCase(criterio)) {
			for(Pelicula p: peliculas) {
				if(p.tipo.equalsIgnoreCase("animated")) {
					Animated a= (Animated) p;
					if(a.getEstiloAnimacion().equalsIgnoreCase(busqueda)) {
						output+=a.getInfo();
					};
				}
				 
			}
			return output;
		}
		else if("4".equalsIgnoreCase(criterio)) {
			for(Pelicula p: peliculas) {
				if(p.tipo.equalsIgnoreCase("RealAction")) {
					RealAction r= (RealAction) p;
					if(r.getDirector().equalsIgnoreCase(busqueda)) {
						output+=r.getInfo();
					};
				}
				 
			}
			return output;
		}
		return output;
		
		
		
		
		
		 
	}

	@Override
	public String mostrarActoresUnicos() {
		String output = "";
		for(Pelicula p: peliculas) {
			if(p.tipo.equalsIgnoreCase("RealAction")) {
				RealAction r= (RealAction) p;
				for(String a: r.getEstrellas()) {
					if(!actores.contains(a)) {
						actores.add(a);
					}
				}
			}
		}
		for(String actor: actores) {
			output+=actor+"\n";
		}
		
		return output;
	}
	
	private Pelicula buscarPelicula(String titulo) {
		for(Pelicula p: peliculas) {
			if(p.getTitulo().equalsIgnoreCase(titulo)) {
				return p;
			}
		}
		return null;
	}
	private Cartelera buscarCartelera(String id) {
		for(Cartelera c: cine) {
			if(c.getId().equalsIgnoreCase(id)) {
				return c;
			}
		}
		return null;
	}
	@Override
	public void crearCartelera(String id, String fechaInicio,String fechaTermino) {
		Cartelera c = new Cartelera(id.strip(),fechaInicio.strip(),fechaInicio.strip());
		cine.add(c);
		
	}
	@Override
	public boolean crearPelicula(String input) {
		int length=input.split(",").length;
		if(input.split(",").length==6) {
			Pelicula p =Pelicula.crearPelicula(input);
			peliculas.add(p);
			return true;
		}
		return false;
	}

	@Override
	public boolean asignarCartelera(String titulo, String id) {
		Pelicula p=buscarPelicula(titulo);
		Cartelera c = buscarCartelera(id);
		if(p==null || c==null) {
			return false;
		}
		else {
			if(!c.peliculas.contains(p)) {
				c.getPeliculas().add(p);
				return true;
			}
			return true;
		}

		
	}
	public String mostrarCartelera(String input) {
		String out="";
		Cartelera c = buscarCartelera(input);
		if(c!=null) {
			for(Pelicula p : c.getPeliculas()) {
				out += Pelicula.peliculaToString(p);
			}
		}
		return out;
	}

	 

	
		
	
	
	 
		
}
